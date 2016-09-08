package ua.kiev.prog.onishchenko.HomeTasks.Lecture6.Task5_FileCopy;

/*
Копирование файла блоками (1 поток на блок).
*/

import java.io.RandomAccessFile;
import java.util.List;

public class FileCopy {
    private static final int countThreads = 20;

    public static void main(String[] args) {
        String filename = "D:\\Java\\TEMP\\DirectoryInfo.txt";
        String filename_dest = "D:\\Java\\TEMP\\DirectoryInfo_copy.txt";

        long size = createDestFile(filename, filename_dest);
        if (size == -1) {
            System.out.println("Can't create file");
            return;
        }

        List<FileCopyThread> threadList = FileCopyThreadUtils.createThreads(filename, filename_dest, size, countThreads);
        FileCopyThreadUtils.startThreads(threadList);
        FileCopyThreadUtils.joinThreads(threadList);
    }

    public static long createDestFile(String filename, String filename_dest) {
        long size = -1;
        try (RandomAccessFile src = new RandomAccessFile(filename, "r");
             RandomAccessFile dest = new RandomAccessFile(filename_dest, "rw")) {
            dest.setLength(src.length());
            size = dest.length();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }


}
