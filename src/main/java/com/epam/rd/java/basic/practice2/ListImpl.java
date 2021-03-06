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

        public Node getNext() {
            return next;
        }

        public Object getVal() {
            return val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public Node getHead() {
        return head;
    }


    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl(head);
    }

    private class IteratorImpl implements Iterator<Object> {

        IteratorImpl(Node head){
            this.pointer = head;
        }

        private Node pointer;
        private int index;

        @Override
        public boolean hasNext() {
            return pointer.next != null;
        }

        @Override
        public Object next() {
            try {
                if(index>=size){
                    throw new NoSuchElementException();
                }
                if(index>0) {
                    pointer = pointer.next;
                }
                index++;
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
        head = new Node(element, head);
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
        tail = temp;
        temp.next = null;
        size--;
    }

    @Override
    public Object getFirst() {
        try {
            return head.val;
        }catch (NullPointerException exeption){
            return null;
        }

    }

    @Override
    public Object getLast() {
        try {
            return tail.val;
        }catch (NullPointerException exeption){
            return null;
        }
    }

    @Override
    public Object search(Object element) {
        try{
            Node temp = head;
            while (temp != null){
                if(temp.val.equals(element)){
                    return element;
                }
                temp = temp.next;
            }
            return null;
        }catch(NullPointerException exception){
            return null;
        }
    }

    @Override
    public boolean remove(Object element) {
        Node temp = head;
        Node safeTemp = null;
        while (temp != null){
            if((temp.val == element)&&(temp.val == null)){
                if(temp == tail){
                    tail =safeTemp;
                }
                if (safeTemp != null) {
                    safeTemp.next = temp.next;
                }
                else{
                    head = head.next;
                }
                size--;
                return true;
            }
            if(temp.val == null){
                safeTemp = temp;
                temp = temp.next;
                continue;
            }

            if(checkNull(temp,safeTemp, element)){
                return true;
            }
            safeTemp = temp;
            temp = temp.next;
        }

        return false;
    }

    public boolean checkNull(Node temp, Node safeTemp, Object element){
        if(temp.val.equals(element)){
            if(temp == tail){
                tail =safeTemp;
            }
            if (safeTemp != null) {
                safeTemp.next = temp.next;
            }else{
                head = head.next;
            }
            size--;
            return true;
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
        System.out.println();
        for (String arg:args) {
            list.addLast(arg);
        }
        System.out.println(list.toString());
        list.remove("Dat");
        System.out.println(list.toString());
        list.remove(null);
        System.out.println(list.toString());
        list.remove(null);
        System.out.println(list.toString());
        System.out.println(list.getLast());
    }
}
