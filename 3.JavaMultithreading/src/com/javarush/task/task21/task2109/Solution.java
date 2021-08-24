package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/

import java.util.Objects;

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    
        @Override
        public int hashCode() {
            int hash = i;
            hash = 31 * hash + j;
            return hash;
        }
    
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof A)) return false;
            A a = (A) obj;
            return Objects.equals(this, a);
        }
    
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    
        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
    
        @Override
        public int hashCode() {
            int hash = getI();
            hash = 31 * hash + getJ();
            hash = 31 * hash + (getName() == null ? 0 : getName().hashCode());
            return hash;
        }
    
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof C)) return false;
            C c = (C) obj;
            return Objects.equals(this, c);
        }
    
        @Override
        protected Object clone() throws CloneNotSupportedException {
            C clone = new C(getI(), getJ(), getName());
            return clone;
        }
    }

    public static void main(String[] args) {

    }
}
