package ua.kiev.prog.onishchenko.HomeTasks.Lecture08.Task05_MyLists;

/**
 * Created by JIeIIIa on 21.09.2016.
 */
public class MyLinkedList<E> extends MyList<E> {
    private class Node<E> {
        E key;
        Node next;
        Node prev;
    }

    private Node head;
    private Node tail;

    @Override
    public void add(E e) {
        if (head == null) {
            add(e, 0);
        } else {
            Node<E> node = new Node<>();
            node.key = e;
            node.prev = tail;
            tail.next = node;
            tail = node;
            size++;
        }
    }

    private Node<E> toElementBefore(int i) {

        Node<E> tmpHead = head;
        while (--i > 0) {
            tmpHead = tmpHead.next;
        }
        return tmpHead;
    }

    @Override
    public void add(E e, int i) {
        Node<E> node = new Node<>();
        node.key = e;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            checkIndex(i);
            if (i == 0) {
                node.next = head;
                head.prev = node;
                head = node;
            } else {
                Node tmpHead = toElementBefore(i);
                node.next = tmpHead.next;
                node.prev = tmpHead;
                tmpHead.next.prev = node;
                tmpHead.next = node;
            }
        }
        size++;
    }

    @Override
    public void addFirst(E e) {
        add(e, 0);
    }

    @Override
    public E get(int i) {
        checkIndex(i);
        return toElementBefore(i + 1).key;
    }

    @Override
    public void set(E e, int i) {
        checkIndex(i);
        toElementBefore(i+1).key = e;
    }

    @Override
    public void remove() {
        remove(size-1);
    }

    @Override
    public void remove(int i) {
        checkIndex(i);
        if (head == tail) {
            clear();
        } else {
            if (i == 0) {
                head.next.prev = null;
                head = head.next;
            } else if (i == size - 1) {
                tail.prev.next = null;
                tail = tail.prev;
            } else {
                Node<E> tmp = toElementBefore(i+1);
                tmp.prev.next = tmp.next;
                tmp.next.prev = tmp.prev;
            }
            size--;
        }

    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<E> tmpHead = head;
        while (tmpHead != null) {
            sb.append(tmpHead.key);
            if (tmpHead != tail) {
                sb.append(", ");
            }
            tmpHead = tmpHead.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
