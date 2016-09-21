package ua.kiev.prog.onishchenko.HomeTasks.Lecture08.Task05_MyLists;

/*
Написать свою реализацию классов ArrayList и LinkedList
*/

import java.util.Random;

public class MyListRunner {
    public static void main(String[] args) {
        System.out.println("LINKED LIST <Integer>");
        MyList<Integer> listInt = new MyLinkedList<>();
        Integer[] arr = new Integer[]{1, 2, 3};
        doSmth(listInt, arr);

        System.out.println("\n\nLINKED LIST <Double>");
        MyList<Double> listDbl = new MyLinkedList<>();
        Double[] arrDbl = new Double[]{1.2, 3.4, 5.6};
        doSmth(listDbl, arrDbl);

        System.out.println("\n\nARRAY LIST <Integer>");
        MyList<Integer> listInt2 = new MyArrayList<>();
        doSmth(listInt2, arr);

        System.out.println("\n\nARRAY LIST <Double>");
        MyList<Double> listDbl2 = new MyArrayList<>();
        doSmth(listDbl2, arrDbl);


    }

    @SuppressWarnings("unchecked")
    private static <E extends Number> void doSmth(MyList<E> list, E[] arr) {
        System.out.println("List at start:");
        System.out.println(list);

        System.out.println("Fill list");
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            list.addFirst(arr[i]);
        }

        System.out.println("Iterator: ");
        for (E i : list) {
            System.out.print(i + "\t");
        }
        System.out.println();

        System.out.println("Add element " + arr[0] + "in position 3");
        list.add(arr[0], 3);

        System.out.println(list);
        System.out.println("Remove element in position 3");
        list.remove(3);
        System.out.println(list);

        deletingElements(list);
        System.out.println("Clear list");
        list.clear();
        System.out.println(list);
    }

    private static <E extends Number> void deletingElements(MyList<E> list) {
        System.out.println("While size > 2");
        Random rnd = new Random();
        while (list.size > 2) {
            switch (rnd.nextInt(2)) {
                case 0:
                    System.out.println(">>remove first element");
                    list.removeFirst();
                    break;
                case 1:
                    int p = rnd.nextInt(list.size);
                    System.out.println(">>remove element in position " + p);
                    list.remove(p);
                    break;
                default:
                    System.out.println(">>remove last element");
                    list.remove();
            }
            System.out.println(list);
        }
    }
}
