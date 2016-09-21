package ua.kiev.prog.onishchenko.HomeTasks.Lecture08.Task05_MyLists;

import java.util.Iterator;

public abstract class MyList<E> implements Iterable<E>{
    protected int size = 0;

    public abstract void add(E e);

    public abstract void add(E e, int i);

    public abstract void addFirst(E e);

    public abstract E get(int i);

    public abstract void set(E e, int i);

    public abstract void remove();

    public abstract void remove(int i);

    public abstract void removeFirst();

    public abstract void clear();

    public final int getSize() {
        return size;
    }

    public final boolean isEmpty() {
        return size == 0;
    }

    protected void checkIndex(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Wrong index of list");
        }
    }


    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E> {
        private int current;

        @Override
        public boolean hasNext() {
            return current < getSize();
        }

        @Override
        public E next() {
            return get(current++);
        }
    }

}
