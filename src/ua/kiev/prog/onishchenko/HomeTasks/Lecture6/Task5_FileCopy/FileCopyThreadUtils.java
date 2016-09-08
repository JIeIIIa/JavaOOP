package ua.kiev.prog.onishchenko.HomeTasks.Lecture6.Task5_FileCopy;

import java.util.ArrayList;
import java.util.List;

public class FileCopyThreadUtils {
    public static List<FileCopyThread> createThreads(String filename, String filename_dest, long size, int countThreads) {
        List<FileCopyThread> threadList = new ArrayList<>(countThreads);

        for (int i = 0; i < countThreads; i++) {
            threadList.add(new FileCopyThread(filename,
                    filename_dest,
                    size / countThreads * i,
                    size / countThreads * (i + 1))
            );
        }
        return threadList;
    }


    public static void startThreads(List<FileCopyThread> threadList) {
        for (int i = 0; i < threadList.size(); i++) {
            threadList.get(i).start();
        }
    }

    public static void joinThreads(List<FileCopyThread> threadList) {
        try {
            for (int i = 0; i < threadList.size(); i++) {
                threadList.get(i).join();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
