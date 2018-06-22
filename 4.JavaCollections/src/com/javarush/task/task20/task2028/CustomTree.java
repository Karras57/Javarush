package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String > implements Cloneable, Serializable {
    Entry<String> root;

    public CustomTree() {
        root = new Entry<>("root");
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return root.size()-1;
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {
        boolean added = false;
        Queue<Entry> queue = new ArrayDeque<>();
        queue.add(root);
        Entry entry;
        while (!added  && (entry = queue.poll())!=null){
            if (entry.isAvailableToAddChildren()){
                Entry addedEntry = new Entry(s);
                addedEntry.lineNumber = entry.lineNumber+1;
                addedEntry.parent = entry;
                if (entry.availableToAddLeftChildren){
                    entry.leftChild = addedEntry;
                } else {
                    entry.rightChild = addedEntry;
                }
                entry.checkChildren();
                added = true;
            } else {
                if (entry.leftChild!=null){
                    queue.add(entry.leftChild);
                }
                if (entry.rightChild!=null){
                    queue.add(entry.rightChild);
                }
            }
        }
        if (!added){
            addAbylityToAddChildren();
            added = add(s);
        }
        return added;
    }

    private void addAbylityToAddChildren(){
        Queue<Entry> queue = new ArrayDeque<>();
        queue.add(root);
        Entry entry;
        while ( (entry = queue.poll())!=null) {
            if (entry.leftChild ==null && !entry.availableToAddLeftChildren){
                entry.availableToAddLeftChildren = true;
            } else {
                queue.add(entry.leftChild);
            }
            if (entry.rightChild ==null && !entry.availableToAddRightChildren){
                entry.availableToAddRightChildren = true;
            } else {
                queue.add(entry.rightChild);
            }
        }
    }

    public String getParent(String s){
        String parentName = null;
        boolean found = false;
        Queue<Entry> queue = new ArrayDeque<>();
        queue.add(root);
        Entry entry;
        while (!found  && (entry = queue.poll())!=null){
            if (entry.elementName.equals(s)){
                found = true;
                parentName = entry.parent.elementName;
            } else {
                if (entry.leftChild!=null){
                    queue.add(entry.leftChild);
                }
                if (entry.rightChild!=null){
                    queue.add(entry.rightChild);
                }
            }
        }
        return parentName;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)){
            throw new UnsupportedOperationException();
        }
        String s = (String)o;

        boolean found = false;
        Queue<Entry> queue = new ArrayDeque<>();
        queue.add(root);
        Entry entry;
        while (!found  && (entry = queue.poll())!=null){
            if (entry.elementName.equals(s)){
                found = true;
               if (entry.parent.leftChild!=null && entry.parent.leftChild.equals(entry)){
                   entry.parent.leftChild=null;
               } else {
                   entry.parent.rightChild=null;
               }
            } else {
                if (entry.leftChild!=null){
                    queue.add(entry.leftChild);
                }
                if (entry.rightChild!=null){
                    queue.add(entry.rightChild);
                }
            }
        }
        return found;
    }

    static class Entry<T> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }
        void checkChildren(){
            if (leftChild!=null){
                availableToAddLeftChildren = false;
            }
            if (rightChild!=null){
                availableToAddRightChildren = false;
            }
        }

        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        int size(){
            int result = 1;
            if (leftChild!=null){
                result+= leftChild.size();
            }
            if (rightChild!=null){
                result+= rightChild.size();
            }
            return result;
        }
    }
}
