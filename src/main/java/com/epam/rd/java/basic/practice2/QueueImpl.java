package com.epam.rd.java.basic.practice2;

import org.w3c.dom.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {

    ListImpl list;

    public QueueImpl(){
        list = new ListImpl();
    }


    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int size() {
        return list.size();
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl(list);
    }

    private class IteratorImpl implements Iterator<Object> {

        private ListImpl.Node pointer;
        private int index;

        IteratorImpl(ListImpl list){
            pointer = list.getHead();
        }

        @Override
        public boolean hasNext() {
            return pointer.next != null;
        }

        @Override
        public Object next() {
            try {
                if(index>=size()){
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
    public void enqueue(Object element) {
        list.addLast(element);
    }

    @Override
    public Object dequeue() {
        try {
            Object o = list.getFirst();
            list.removeFirst();
            return o;
        }catch (NullPointerException exception){
            return null;
        }
    }

    @Override
    public Object top() {

        return list.getFirst();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        for(String arg: args){
            queue.enqueue(arg);
        }
        System.out.println(queue.toString());
        System.out.println(queue.dequeue());
        System.out.println(queue.toString());
        queue.clear();
        System.out.println(queue.toString());

    }

}
