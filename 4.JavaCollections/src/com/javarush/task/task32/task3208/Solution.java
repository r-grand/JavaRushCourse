package com.javarush.task.task32.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

/* 
RMI-2
*/

public class Solution {
    public static Registry registry;
    public static final String BINDING_NAME_CAT = "cat.proxy";
    public static final String BINDING_NAME_DOG = "dog.proxy";

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Cat cat = new Cat("Barsik");
                Dog dog = new Dog("Albert");
                registry = LocateRegistry.createRegistry(2099);
                Remote stubCat = UnicastRemoteObject.exportObject(cat, 0);
                Remote stubDog = UnicastRemoteObject.exportObject(dog, 0);
                registry.bind(BINDING_NAME_CAT, stubCat);
                registry.bind(BINDING_NAME_DOG, stubDog);
            } catch (RemoteException | AlreadyBoundException e) {
                e.printStackTrace(System.err);
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}
