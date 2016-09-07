package ua.kiev.prog.onishchenko.HomeTasks.Lecture5.Task7_MergeFiles;
/*
Написать программу, которая скопирует несколько файлов в один.
Подумать как для этого использовать java.io.SequenceInputStream.
*/

import java.io.*;
import java.util.*;

public class MergeFiles {
    public static void merge(List<InputStream> list, OutputStream out) {
        try (SequenceInputStream in = new SequenceInputStream(Collections.enumeration(list))) {
            int c;
            do {
                c = in.read();
                if (c != -1) {
                    out.write(c);
                }
            } while (c != -1);

        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
    }



    public static void main(String[] args) {
        List<InputStream> list = new LinkedList<>();
        try {
            list.add(new BufferedInputStream(new FileInputStream("D:\\Java\\TEMP\\testing.txt")));
            list.add(new FileInputStream("D:\\Java\\TEMP\\DirectoryInfo.txt"));
            list.add(new FileInputStream("D:\\Java\\TEMP\\testing.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        merge(list, System.out);
    }

}
