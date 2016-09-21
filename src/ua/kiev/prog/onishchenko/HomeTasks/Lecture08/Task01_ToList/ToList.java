package ua.kiev.prog.onishchenko.HomeTasks.Lecture08.Task01_ToList;

/*
Написать метод для конвертации массива строк/чисел в список.
*/

import java.util.ArrayList;
import java.util.List;

public class ToList {
    public static void main(String[] args) {
        Integer[] arrInt = new Integer[]{new Integer(1), 2, 3, 4, 5};
        String[] arrStr = new String[]{"one", "two", "three", "four"};
        Double[] arrDbl = new Double[]{1.0, 2.0, 3.0, 4.5, 6.0, 10.0};

        List<Integer> listInt = toList(arrInt);
        List<String> listStr = toList(arrStr);
        List<Double> listDbl = toList(arrDbl);

        System.out.println("Integers: " + listInt.toString());
        System.out.println("Strings:  " + listStr.toString());
        System.out.println("Doubles:  " + listDbl.toString());
    }


    public static <T extends Number> List<T> toList(T[] array) {
        List<T> list = new ArrayList<>(array.length);
        for (T element : array) {
            list.add(element);
        }
        return list;
    }

    public static List<String> toList(String[] array) {
        List<String> list = new ArrayList<>(array.length);
        for (String element : array) {
            list.add(element);
        }
        return list;
    }



}
