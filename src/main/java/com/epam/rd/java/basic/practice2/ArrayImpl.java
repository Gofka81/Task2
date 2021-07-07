package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayImpl implements Array {

    private Object[] arrayData;
    private int size;

    public Object[] getArrayData() {
        return arrayData;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayImpl(int initialCapacity){
        if (initialCapacity > 0) {
            this.arrayData = new Object[initialCapacity];
        }
        else {
            throw new IllegalArgumentException();
        }
        size =0;
    }
    public ArrayImpl(){
        arrayData = new Object[10];
        size =0;
    }

	@Override
    public void clear() {
        for (int to = size, i = size = 0; i < to; i++) {
            arrayData[i] = null;
        }
    }

	@Override
    public int size() {
        return size;
    }
	
	@Override
    public Iterator<Object> iterator() {
	    return new IteratorImpl();
    }
	
	private class IteratorImpl implements Iterator<Object> {

        private int indexNext;
        private int lastIndex =-1;

        @Override
        public boolean hasNext() {
            return indexNext!=size;
        }

        @Override
        public Object next() {
            if(indexNext>=size){
                throw new NoSuchElementException();
            }
            lastIndex = indexNext;
            indexNext++;
            return arrayData[lastIndex];
        }

        @Override
        public  void remove() {
            ArrayImpl.this.remove(lastIndex);
            size--;
            indexNext = lastIndex;
            lastIndex=-1;
        }
    }
	
	@Override
    public void add(Object element) {
        try{
            arrayData[size] = element;
            size++;
        }
        catch(ArrayIndexOutOfBoundsException exception){
            grow(5+size);
            arrayData[size] = element;
            size++;
        }
    }

	@Override
    public void set(int index, Object element){
        try{
            arrayData[index] = element;
        }
        catch (NoSuchElementException exception){
            System.out.println("NoSuchElementException");
        }
    }

	@Override
    public Object get(int index) {
        try{
            return arrayData[index];
        }
        catch (NoSuchElementException exception){
            return null;
        }
    }

	@Override
    public int indexOf(Object element) {
        int place =0;
        for(Object st: arrayData){
           try {
               if (st.equals(element)) {
                   return place;
               } else {
                   place++;
               }
           }
           catch (NullPointerException exception){
               if(st == element){
                   return place;
               }
           }
        }
        return -1;
    }
	@Override
    public void remove(int index) {
        try{
            Object[]temp = arrayData;
            if (size - 1 - index >= 0) System.arraycopy(temp, index + 1, temp, index, size - 1 - index);
            size--;

        }
        catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("ArrayIndexOutOfBoundsException");
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        for(int i=0; i<size; i++){
            string.append(arrayData[i]);
            if(i!=size-1) {
                string.append(", ");
            }
        }
        string.append("]");
        return string.toString();
    }

    public void grow(int newCapacity){
        Object[] oldData = arrayData;
        Object[] newData = new Object[newCapacity];
        System.arraycopy(oldData,0,newData,0,size);
        arrayData = newData;
    }

    public static void main(String[] args) {
        ArrayImpl array = new ArrayImpl(10);
        for(String a:args) {
            array.add(a);
        }
        System.out.print(array.toString());
        array.remove(2);
        array.remove(1);
        System.out.println(array.size());
        array.remove(0);
        System.out.println(array.size());
        System.out.println(array.toString());
        System.out.println(array.indexOf(null));

        for(Object o: array){
            System.out.println(o);
        }
    }
}