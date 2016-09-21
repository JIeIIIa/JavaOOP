package ua.kiev.prog.onishchenko.HomeTasks.Lecture08.Task02_ListDemo;

/*
Написать метод, который создаст список, положит в него 10 элементов, затем удалит первые два и последний, а
затем выведет результат на экран.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = createList(10);
        printList(list);
        modifyList(list);
        printList(list);
    }

    public static List<Integer> createList(int size) {
        List<Integer> list = new ArrayList<>(size);
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(100));
        }
        return list;
    }

    public static void modifyList(List list) {
        list.subList(0, 2).clear();
        list.remove(list.size()-1);
    }

    public static void printList(List list) {
        System.out.println(list.toString());
    }
}
