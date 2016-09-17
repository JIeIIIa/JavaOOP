package ua.kiev.prog.onishchenko.HomeTasks.Lecture7.Task01_SumThreads;

/*
Написать код для многопоточного подсчета суммы элементов массива целых чисел. Сравнить скорость подсчета с простым алгоритмом.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class SumThreadRunning {
    private static final int SIZE = 400000;

    public static void main(String[] args) {
        int[] arr = generateArray(SIZE);
        int cntThread = Runtime.getRuntime().availableProcessors();
        printArray(arr);

        if (args.length > 0) {
            try {
                cntThread = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Wrong parameters. Used default count of threads.");
            }
        }
        System.out.println("Count of threads = " + cntThread);
        long start = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(cntThread);
        List<Future<Integer>> futureResult = createThreads(es, arr, cntThread);

        System.out.println("Sum = " + summa(futureResult) + "; time for calc = " + (System.currentTimeMillis() - start) + "ms");
        es.shutdown();
        System.out.println("\nCalc in main thread: ");
        System.out.println("Sum = " + simpleSumma(arr) + "; time for calc = " + (System.currentTimeMillis() - start) + "ms");
    }

    private static int[] generateArray(int length) {
        int[] arr = new int[length];
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = rnd.nextInt(100);
        }
        return arr;
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    private static List<Future<Integer>> createThreads(ExecutorService es, int[] arr, int cntThread) {
        List<Future<Integer>> result = new ArrayList<>(cntThread);
        for (int i = 0; i < cntThread; i++) {
            result.add(es.submit(new SumThread(arr, arr.length * i / cntThread, arr.length * (i+1) / cntThread)));
        }
        return result;
    }

    private static Integer summa(List<Future<Integer>> partResult) {
        Integer result = 0;

        for (Future<Integer> future : partResult) {
            try {
                result += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static int simpleSumma(int[] arr) {
        int result = 0;
        for (int i : arr) {
            result += i;
        }
        return result;
    }

}

class SumThread implements Callable<Integer>{
    private int[] arr;
    private int start;
    private int finish;

    public SumThread(int[] arr, int start, int finish) {
        this.arr = arr;
        this.start = indexInRange(arr, start);
        this.finish = indexInRange(arr, finish);
    }

    private int indexInRange(int[] arr, int index) {
        if (index < 0) {
            return 0;
        } else if (index > arr.length) {
            return arr.length;
        } else if(arr != null && arr.length > 0){
            return index;
        } else {
            throw new IllegalArgumentException("Wrong index: " + index + "(array length = " + arr.length + ")");
        }
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;

        for (int i = start; i < finish; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
