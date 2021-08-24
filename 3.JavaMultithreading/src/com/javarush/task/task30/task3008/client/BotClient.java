package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {
	@Override
	protected SocketThread getSocketThread() {
		return new BotSocketThread();
	}
	
	@Override
	protected boolean shouldSendTextFromConsole() {
		return false;
	}
	
	@Override
	protected String getUserName() {
		return String.format("date_bot_%d", (int) (Math.random() * 100));
	}
	
	public static void main(String[] args) {
		new BotClient().run();
	}
	
	public class BotSocketThread extends SocketThread {
		@Override
		protected void clientMainLoop() throws IOException, ClassNotFoundException {
			sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
			super.clientMainLoop();
		}
		
		@Override
		protected void processIncomingMessage(String message) {
			ConsoleHelper.writeMessage(message);
			if (!message.contains(": ") && message == null) return;
			
			String[] arguments = message.split(": ");
			if (arguments.length != 2) return;
			
			String userName = arguments[0];
			String data = arguments[1];
			Date date = Calendar.getInstance().getTime();
			switch (data) {
				case "дата":
					SimpleDateFormat dateFormat = new SimpleDateFormat("d.MM.yyyy");
					String dateAnswer = dateFormat.format(date);
					sendTextMessage(String.format("Информация для %s: %s", userName, dateAnswer));
					break;
				case "день":
					SimpleDateFormat dayFormat = new SimpleDateFormat("d");
					String dayAnswer = dayFormat.format(date);
					sendTextMessage(String.format("Информация для %s: %s", userName, dayAnswer));
					break;
				case "месяц":
					SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
					String monthAnswer = monthFormat.format(date);
					sendTextMessage(String.format("Информация для %s: %s", userName, monthAnswer));
					break;
				case "год":
					SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
					String yearAnswer = yearFormat.format(date);
					sendTextMessage(String.format("Информация для %s: %s", userName, yearAnswer));
					break;
				case "время":
					SimpleDateFormat timeFormat = new SimpleDateFormat("H:mm:ss");
					String timeAnswer = timeFormat.format(date);
					sendTextMessage(String.format("Информация для %s: %s", userName, timeAnswer));
					break;
				case "час":
					SimpleDateFormat hourFormat = new SimpleDateFormat("H");
					String hourAnswer = hourFormat.format(date);
					sendTextMessage(String.format("Информация для %s: %s", userName, hourAnswer));
					break;
				case "минуты":
					SimpleDateFormat minuteFormat = new SimpleDateFormat("m");
					String minuteAnswer = minuteFormat.format(date);
					sendTextMessage(String.format("Информация для %s: %s", userName, minuteAnswer));
					break;
				case "секунды":
					SimpleDateFormat secondFormat = new SimpleDateFormat("s");
					String secondAnswer = secondFormat.format(date);
					sendTextMessage(String.format("Информация для %s: %s", userName, secondAnswer));
					break;
				case "команды":
					String commands = "Доступные команды: дата, день, месяц, год, время, час, минуты, секунды.";
					sendTextMessage(String.format("Информация для %s:%n%s", userName, commands));
					break;
			}
		}
	}
}
