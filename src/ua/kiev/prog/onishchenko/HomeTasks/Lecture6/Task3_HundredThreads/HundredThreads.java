package ua.kiev.prog.onishchenko.HomeTasks.Lecture6.Task3_HundredThreads;

/*
Создать 100 потоков, каждый их которых выведет на экран свой номер и дождется, пока его прервут.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HundredThreads {
    private static class CurrentThread extends Thread{
        private int i;

        public CurrentThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.printf("%3d. Thread #%d was run\n", i, getId());
            while (!isInterrupted()) {
            }
            System.out.printf("%3d. Thread #%d was stopped\n", i, getId());
        }
    }

    public static void main(String[] args) {
        List<Thread> threads = createStartThreads(100);
        System.out.println(threads.size() + "already run");
        waitStop();
        stopThreads(threads);

    }

    public static void waitStop() {
        String input = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Input STOP for stop all thread");
            try {
                input = in.readLine();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
        } while (!input.equalsIgnoreCase("stop"));
    }

    public static List<Thread> createStartThreads(int count) {
        List<Thread> threads = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            try {
                threads.add(new CurrentThread(i + 1));
                threads.get(threads.size() - 1).start();
            } catch (Exception e) {

            }
        }
        return threads;
    }

    public static void stopThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.interrupt();
            } catch (Exception e) {

            }
        }
    }
}
