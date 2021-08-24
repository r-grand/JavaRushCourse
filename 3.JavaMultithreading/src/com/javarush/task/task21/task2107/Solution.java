package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution sol = new Solution();
        for (Map.Entry<String, User> pair : users.entrySet()) {
            sol.users.put(pair.getKey(), (User) pair.getValue().clone());
        }
        return sol;
    }
    
    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    
        @Override
        protected Object clone() {
            return new User(this.age, this.name);
        }
    
        @Override
        public int hashCode() {
            int hash = age;
            hash = 31 * hash + (name == null ? 0 : name.hashCode());
            return hash;
        }
    
        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (!(obj instanceof User)) return false;
            User u = (User) obj;
            if (!(Objects.equals(age, u.age))) return false;
            return Objects.equals(name, u.name);
        }
    }
}
