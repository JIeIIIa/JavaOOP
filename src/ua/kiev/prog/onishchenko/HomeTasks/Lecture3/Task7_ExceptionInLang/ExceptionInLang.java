package ua.kiev.prog.onishchenko.HomeTasks.Lecture3.Task7_ExceptionInLang;
/*
Найти в стандартной библиотеке 5 классов, методы которых кидают исключения и написать пример кода для их обработки
(пример: Integer.parseInt).

*/
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ExceptionInLang {
    public static void main(String[] args) {
        try {
            int size = -10;
            int[] array = new int[size];

        } catch (NegativeArraySizeException e) {
            System.out.println("Negative Array Size Exception:\n -> " + e);
        }

        try {
            ArrayList<Integer> list = new ArrayList<>();
            list.iterator().next();

        } catch (NoSuchElementException e) {
            System.out.println("No Such Element Exception:\n -> " + e);
        }

        String st = "Test string";
        try {
            st = st.toLowerCase(null);
        } catch (NullPointerException e) {
            System.out.println("NullPointer Exception:\n -> " + e);
        }

        try {
            st.charAt(100);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Index Out Of Bounds Exception:\n -> " + e);
        }

        Number n = new Double(10.0);

        try {
            int i = (int) n;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException:\n -> " + e);
        }

        try {
            st = Character.getName(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException:\n -> " + e);
        }

        try {
            byte b = Byte.parseByte("123456");
        } catch (IllegalArgumentException e) {
            System.out.println("NumberFormatException:\n -> " + e);
        }

    }
}
