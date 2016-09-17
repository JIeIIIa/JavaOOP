package ua.kiev.prog.onishchenko.HomeTasks.Lecture7.Task04_MatrixMult;

/*
Реализовать многопоточное перемножение квадратных матриц. Сравнить скорость выполнения алгоритма с однопоточным решением.
*/

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixMult {
    private static final int SIZE = 20;
    public static void main(String[] args) {
        int[][] a = createMatrix(SIZE);
        int[][] b = createMatrix(SIZE);
        int[][] c = new int[SIZE][SIZE];


        printMatrix(a, "A");
        printMatrix(b, "B");
        int threadCnt = Runtime.getRuntime().availableProcessors();
        ExecutorService es = Executors.newFixedThreadPool(threadCnt);
        long start = System.currentTimeMillis();
        createThreads(a, b, c, threadCnt, es);

        es.shutdown();
        while (!es.isTerminated());

        printMatrix(c, "Result");
        System.out.println("Time for calc = " + (System.currentTimeMillis() - start) + "ms");


        System.out.println("\n\nCalc for single thread");
        es = Executors.newFixedThreadPool(1);
        c = new int[SIZE][SIZE];
        start = System.currentTimeMillis();
        createThreads(a, b, c, 1, es);

        es.shutdown();
        while (!es.isTerminated());
        //printMatrix(c, "Result");
        System.out.println("Time for calc = " + (System.currentTimeMillis() - start) + "ms");
    }

    private static int[][] createMatrix(int size) {
        int[][] result = new int[size][size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = rnd.nextInt(10);
            }
        }
        return result;
    }

    private static void createThreads(int[][] a, int[][] b, int[][] c, int threadCnt, ExecutorService es) {
        for (int i = 0; i < threadCnt; i++) {
            es.submit(new ThreadMatrixMult(a, b, c, c.length * i / threadCnt, c.length * (i + 1) / threadCnt));
        }
    }

    private static void printMatrix(int[][] matrix, String name) {
        System.out.println(name + " = [");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("]");
    }
}

class ThreadMatrixMult implements Runnable {
    int[][] a;
    int[][] b;
    int[][] matrix;
    int start;
    int finish;

    public ThreadMatrixMult(int[][] a, int[][] b, int[][] matrix, int start, int finish) {
        this.a = a;
        this.b = b;
        this.matrix = matrix;
        this.start = start;
        this.finish = finish;
    }



    @Override
    public void run() {
        for (int i = start; i < finish; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = multiplicate(i, j);
            }
        }
    }

    private int multiplicate(int i, int j) {
        int result = 0;
        for (int k = 0; k < matrix.length; k++) {
            result += a[i][k] * b[k][j];
        }
        return result;
    }
}
