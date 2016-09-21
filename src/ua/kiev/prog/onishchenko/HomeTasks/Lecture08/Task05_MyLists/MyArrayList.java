package ua.kiev.prog.onishchenko.HomeTasks.Lecture08.Task05_MyLists;

import java.util.Arrays;

public class MyArrayList<E> extends MyList<E> {
    private Object[] elements;
    private final int DEFAULT_CAPACITY = 16;
    private int capacity;

    public MyArrayList() {
        clear();
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
    }

    private void resizeArray() {
        if (size == capacity) {
            capacity *= 1.25;
            Object[] tmp = new Object[capacity];
            System.arraycopy(elements, 0, tmp, 0, size);
            elements = tmp;
        }
    }

    @Override
    public void add(E e) {
        resizeArray();
        elements[size++] = e;
    }

    @Override
    public void add(E e, int i) {
        resizeArray();
        System.arraycopy(elements, i, elements, i+1, size - i);
        elements[i] = e;
        size++;
    }

    @Override
    public void addFirst(E e) {
        add(e, 0);
    }


    @Override
    public E get(int i) {
        checkIndex(i);
        return (E)elements[i];
    }

    @Override
    public void set(E e, int i) {
        checkIndex(i);
        elements[i] = e;
    }

    @Override
    public void remove() {
        remove(size-1);
    }

    @Override
    public void remove(int i) {
        checkIndex(i);
        System.arraycopy(elements, i+1, elements, i, size - i - 1);
        elements[size--] = null;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void clear() {
        capacity = DEFAULT_CAPACITY;
        elements = new Object[capacity];
        size = 0;
    }

    @Override
    public String toString() {
        Object[] tmp = new Object[size];
        System.arraycopy(elements, 0, tmp, 0, size);
        return Arrays.toString(tmp);
    }
}
