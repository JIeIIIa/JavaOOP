package ua.kiev.prog.onishchenko.HomeTasks.Lecture08.Task03_WrappedArray;

/*
Написать класс, который умеет хранить в себе массив любых типов данных (int, long etc.). Реализовать метод,
который возвращает любой элемент массива по индексу.
*/

public class WrappedArrayRunner {
    public static void main(String[] args) {
        WrappedArray<Integer> arr = new WrappedArray<>(null);
        printWrappedArray(arr);
        arr = new WrappedArray<>(new Integer[]{1, 2, 3, 4});
        printWrappedArray(arr);

        try {
            System.out.println(arr.getElement(100));
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            System.out.println("ERROR: " + e);
        }

        WrappedArray<Double> arrD = new WrappedArray<>(new Double[]{1.2, 3.4, 5.6, 7.890});
        printWrappedArray(arrD);

        WrappedArray<String> arrS = new WrappedArray<>(new String[]{"one", "two", "three", "four", "five"});
        printWrappedArray(arrS);
    }

    public static void printWrappedArray(WrappedArray array) {
        System.out.print("[ ");
        for (int i = 0; i < array.getSize(); i++) {
            System.out.print(array.getElement(i));
            if (i < array.getSize() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

class WrappedArray<T> {
    private T[] array;

    public WrappedArray(T[] array) {
        this.array = array;
    }

    public int getSize() {
        if (array != null) {
            return array.length;
        } else {
            return 0;
        }
    }

    public T getElement(int index) {
        if (array == null) {
            throw new NullPointerException("null array");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException("too small index");
        } else if (index >= array.length) {
            throw new IndexOutOfBoundsException("too large index");
        } else {
            return array[index];
        }
    }


}