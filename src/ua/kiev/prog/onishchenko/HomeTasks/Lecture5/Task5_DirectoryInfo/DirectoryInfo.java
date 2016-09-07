package ua.kiev.prog.onishchenko.HomeTasks.Lecture5.Task5_DirectoryInfo;

/*
Написать программу, которая создаст текстовый файл и запишет в него список файлов (путь, имя, дата создания) из заданного каталога.
*/

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;


public class DirectoryInfo {

    private static void listAll(String path, List<String> res)
            throws IOException {
        File dir = new File(path);
        File[] list = dir.listFiles();

        if (list == null) return;

        for (File f : list) {
            if (f.isFile()) {
                res.add(String.format("<F> path: %s\n    name: %s\n    date: %s\n",
                        f.getCanonicalPath().substring(0, f.getCanonicalPath().length() - f.getName().length() - 1),
                        f.getName(),
                        new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(f.lastModified()))
                );

            } else {
                res.add(String.format("<D> path: %s\n    date: %s\n",
                        f.getCanonicalPath(),
                        new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(f.lastModified()))
                );
                listAll(f.getCanonicalPath(), res);
            }
        }
    }

    public static void print(List<String> list, OutputStream out) throws IOException {
        if (list == null) {
            return;
        }

        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                out.write(s.charAt(i));
            }
            out.write('\n');
        }
    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        try (BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream("D:\\Java\\Temp\\DirectoryInfo.txt"))) {
            listAll("D:\\Java\\TEMP\\IN", list);
            print(list, System.out);
            print(list, fout);
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
    }
}
