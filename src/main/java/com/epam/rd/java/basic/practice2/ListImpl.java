package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {

    public static class Node{
        private Node next;
        private Object val;

        public Node(Object val, Node next){
            this.val = val;
            this.next = next;
        }

        public Node(){
            next = null;
            val = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        private Node pointer;

        @Override
        public boolean hasNext() {
            if(pointer == null){
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            try {
                pointer = pointer.next;
                return pointer.val;
            }
            catch (NullPointerException exception){
                return null;
            }
        }

    }

    @Override
    public void addFirst(Object element) {
        size++;
        if(head == null){
            head = new Node(element,null);
            tail = head;
            return;
        }
        Node newNode = new Node(element, head);
        head = newNode;
    }

    @Override
    public void addLast(Object element) {
        size++;
        if(head == null){
            head = new Node(element,null);
            tail = head;
            return;
        }
        Node newNode = new Node(element, null);
        tail.next = newNode;
        tail = newNode;
    }

    @Override
    public void removeFirst() {
        head = head.next;
        size--;
    }

    @Override
    public void removeLast() {
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    @Override
    public Object getFirst() {
        return head.val;
    }

    @Override
    public Object getLast() {
        return tail.val;
    }

    @Override
    public Object search(Object element) {
        Node temp = head;
        while (temp != null){
            if(temp.val.equals(element)){
                return element;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        Node temp = head;
        Node safeTemp = null;
        while (temp != null){
            if (temp.val.equals(element)){
                if(safeTemp != null){
                    safeTemp.next = temp.next;
                }
                else{
                    temp = temp.next;
                }
                size --;
                return true;
            }
            safeTemp = temp;
            temp= temp.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        Node temp = head;
        while (temp != null){
            string.append(temp.val);
            if(temp.next != null) {
                string.append(", ");
            }
            temp = temp.next;
        }
        string.append("]");
        return string.toString();
    }

    public static void main(String[] args) {
        ListImpl list = new ListImpl();
        list.addFirst(args[0]);
        list.addFirst(args[1]);
        list.addLast(args[2]);
        list.remove("Dat");
        System.out.println(list.toString());
        System.out.println(list.size());
        list.removeFirst();
        list.addLast(args[3]);
        System.out.println(list.toString());
        list.clear();
        System.out.println(list.toString());
    }
}
