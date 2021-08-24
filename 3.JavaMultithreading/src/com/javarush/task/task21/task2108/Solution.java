package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/

import java.util.Arrays;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }
    
        @Override
        public int hashCode() {
            int hash = getName() == null ? 0 : getName().hashCode();
            for (String branch : branches) {
                hash = 31 * hash + (branch == null ? 0 : branch.hashCode());
            }
            return hash;
        }
    
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Tree)) return false;
            Tree tree = (Tree) obj;
            if (!Objects.equals(tree.getName(), this.getName())) return false;
            return Arrays.equals(tree.branches, this.branches);
        }
    
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new Tree(getName(), branches == null ? null : branches.clone());
        }
    }
}
