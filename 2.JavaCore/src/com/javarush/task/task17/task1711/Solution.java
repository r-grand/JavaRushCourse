package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();
    static SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    
    private static void create(String name, String sex, String birthDate) throws ParseException {
        if (sex.equals("м")) {
            Person person = Person.createMale(name, inputFormat.parse(birthDate));
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
        if (sex.equals("ж")) {
            Person person = Person.createFemale(name, inputFormat.parse(birthDate));
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
    }
    
    public static void read(String id) {
        System.out.println(allPeople.get(Integer.parseInt(id)));
    }
    
    public static void update(String id, String name, String sex, String birthDate) throws ParseException {
        if (sex.equals("м")) {
            Person person = Person.createMale(name, inputFormat.parse(birthDate));
            allPeople.set(Integer.parseInt(id), person);
        }
        if (sex.equals("ж")) {
            Person person = Person.createFemale(name, inputFormat.parse(birthDate));
            allPeople.set(Integer.parseInt(id), person);
        }
    }
    
    public static void delete(String id) {
        allPeople.get(Integer.parseInt(id)).setName(null);
        allPeople.get(Integer.parseInt(id)).setSex(null);
        allPeople.get(Integer.parseInt(id)).setBirthDate(null);
    }
    
    
    public static void main(String[] args) throws ParseException {
        if (args.length != 0) {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        int count = 1;
                        while (count < args.length) {
                            create(args[count], args[count + 1], args[count + 2]);
                            count += 3;
                        }
                    }
                    break;
                case "-i":
                    synchronized (allPeople) {
                        int count = 1;
                        while (count < args.length) {
                            if (Integer.parseInt(args[count]) < allPeople.size() && Integer.parseInt(args[count]) >= 0) {
                                read(args[count]);
                            }
                            count++;
                        }
                    }
                    break;
                case "-u":
                    synchronized (allPeople) {
                        int count = 1;
                        while (count < args.length) {
                            update(args[count], args[count + 1], args[count + 2], args[count + 3]);
                            count += 4;
                        }
                    }
                    break;
                case "-d":
                    synchronized (allPeople) {
                        int count = 1;
                        while (count < args.length) {
                            if (Integer.parseInt(args[count]) < allPeople.size() && Integer.parseInt(args[count]) >= 0) {
                                delete(args[count]);
                            }
                            count++;
                        }
                    }
                    break;
            }
        }
    }
}
