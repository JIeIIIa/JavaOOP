package ua.kiev.prog.onishchenko.HomeTasks.Lecture4.Task01_Human;

import java.util.Arrays;

/*
    1. Модифицировать код для сортировки Human чтобы элементы упорядочивались по убыванию.
 */
public class Main {
    public static void main(String[] args) {
        Human[] list = {new Human(40), new Human(20), new Human(3), new Human(7)};

        System.out.println("Sort ascending:");
        Arrays.sort(list, new HumanComparator());
        printList(list);

        System.out.println("Sort descending:");
        Arrays.sort(list, new HumanInvertComparator());
        printList(list);


    }

    public static void printList(Human[] list) {
        for (Human human : list) {
            System.out.print(human.getAge() + "\t");
        }
        System.out.println();
    }
}
