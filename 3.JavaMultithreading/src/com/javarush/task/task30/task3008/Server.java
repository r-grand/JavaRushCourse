package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
	private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
	
	public static void sendBroadcastMessage(Message message) {
		for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
			try {
				pair.getValue().send(message);
			} catch (IOException e) {
				ConsoleHelper.writeMessage(String.format("Сообщение для [%s] отправить не удалось.%n", pair.getKey()));
			}
		}
	}
	
	private static class Handler extends Thread {
		private Socket socket;
		
		public Handler(Socket socket) {
			this.socket = socket;
		}
		
		private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
			connection.send(new Message(MessageType.NAME_REQUEST, "Укажите своё имя_пользователя для отображения в чате:"));
			Message answer = connection.receive();
			String newClientName = answer.getData();
			if (answer.getType() == MessageType.USER_NAME
					&& !newClientName.isEmpty()
					&& !connectionMap.containsKey(newClientName)) {
				connectionMap.put(newClientName, connection);
				connection.send(new Message(MessageType.NAME_ACCEPTED, "Ваше имя_пользователя принято. Вы добавлены в чат. Приятного общения)"));
				return newClientName;
			} else {
				return serverHandshake(connection);
			}
		}
		
		private void notifyUsers(Connection connection, String userName) throws IOException {
			for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
				if (!pair.getKey().equals(userName)) {
					connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
				}
			}
		}
		
		private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
			while (true) {
				Message message = connection.receive();
				if (message.getType() == MessageType.TEXT) {
					String messageText = String.format("%s: %s", userName, message.getData());
					sendBroadcastMessage(new Message(MessageType.TEXT, messageText));
				} else {
					ConsoleHelper.writeMessage(String.format("Сообщение, принятое от %s имеет не верный ТИП", socket.getRemoteSocketAddress()));
				}
			}
		}
		
		@Override
		public void run() {
			ConsoleHelper.writeMessage(String.format("Установлено соединение с %s", socket.getRemoteSocketAddress()));
			String clientName = null;
			try {
				Connection connection = new Connection(socket);
				clientName = serverHandshake(connection);
				sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
				notifyUsers(connection, clientName);
				serverMainLoop(connection, clientName);
			} catch (IOException | ClassNotFoundException e) {
				ConsoleHelper.writeMessage(String.format("Произошла ошибка при обмене данными с %s", socket.getRemoteSocketAddress()));
			} finally {
				if (clientName != null) {
					connectionMap.remove(clientName);
					sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
				}
				ConsoleHelper.writeMessage(String.format("Соединение с %s закрыто", socket.getRemoteSocketAddress()));
			}
		}
	}
	
	public static void main(String[] args) {
		ConsoleHelper.writeMessage("Введите номер порта:");
		try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
			ConsoleHelper.writeMessage("Сервер успешно запущен.");
			while (true) {
				Socket client;
				if ((client = serverSocket.accept()) != null) {
					new Handler(client).start();
				}
			}
		} catch (IOException e) {
			ConsoleHelper.writeMessage(e.getMessage());
		}
	}
}
