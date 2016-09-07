package ua.kiev.prog.onishchenko.HomeTasks.Lecture5.Task2_RecursionListFiles;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/*
2. Написать рекурсивную ф-ю для вывода на экран всех файлов и каталогов, имя которых длиннее 5 символов и вторая буква равна ‘A’.
*/

public class RecursionListFiles {
    //filename - all characters between first character in string and last character '.'
    private static void checkAdd(File f, ArrayList<String> res) throws IOException {
        if (f != null && f.getName().lastIndexOf('.') > 5 &&
                (f.getName().length() > 2 && f.getName().charAt(1) == 'A')) {
            if (f.isFile()) {
                res.add("F: " + f.getCanonicalPath());
            } else {
                res.add("D: " + f.getCanonicalPath());
            }
        }

    }

    private static void listAll(String path, ArrayList<String> res)
            throws IOException
    {
        File dir = new File(path);
        File[] list = dir.listFiles();
        if (list != null) {
            for (File f : list) {
                checkAdd(f, res);
                if(f.isDirectory()) {
                    listAll(f.getCanonicalPath(), res);
                }
            }
        }
    }

    public static void main(String[] args) {
        final String path = "D:\\Java\\";
        ArrayList<String> res = new ArrayList<>();

        try {
            listAll(path, res);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : res)
            System.out.println(s);
    }
}
