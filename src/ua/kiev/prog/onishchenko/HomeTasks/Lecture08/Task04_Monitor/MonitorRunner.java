package ua.kiev.prog.onishchenko.HomeTasks.Lecture08.Task04_Monitor;
/*
Написать монитор, которых хранит дату модификации файлов и выводит сообщения при изменении в файлах.
*/

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MonitorRunner {
    private static class MyEvent implements IFileEvents {
        @Override
        public void onFileAdded(String path) {
            System.out.println("File added: " + path);
        }

        @Override
        public void onFileDeleted(String path) {
            System.out.println("File deleted: " + path);
        }

        @Override
        public void onFileChanged(String path, Long last, Long current) {
            System.out.println("File changed: " + path + " (last = " +
                    new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(last))+ "; current = " +
                    new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(current)));
        }
    }

    public static void main(String[] args) {
        Monitor monitor = new Monitor("D:/Java");
        monitor.setEvents(new MyEvent());
        monitor.setTimeout(2000);
        monitor.start();
        InputStreamReader in = new InputStreamReader(new BufferedInputStream(System.in));
        System.out.println("Input any symbol for exit");
        int c = 0;
        do {
            try {
                c = in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (c == 0 );

        monitor.stop();
    }
}
