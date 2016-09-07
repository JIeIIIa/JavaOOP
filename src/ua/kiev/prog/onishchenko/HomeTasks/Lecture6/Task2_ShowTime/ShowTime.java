package ua.kiev.prog.onishchenko.HomeTasks.Lecture6.Task2_ShowTime;
/*
Создать поток, который будет каждые 10 секунд выводить текущее время на экран.
Сделать возможность прерывания потока с помощью команды с консоли.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class ShowTime {
    static public class TimeThread extends Thread {
        private int delay;

        public TimeThread(int delay) {
            this.delay = delay;
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                System.out.printf("%tT\n", new Date(System.currentTimeMillis()));
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

    }

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        TimeThread timeThread = new TimeThread(10000);

        System.out.println("Input EXIT to stop\n");
        try {
            timeThread.start();
            do {
                try {
                    input = in.readLine();
                } catch (IOException e) {

                }
            } while (!input.equalsIgnoreCase("exit"));
            timeThread.interrupt();
        } catch (Exception e) {
            return;
        }
    }

}
