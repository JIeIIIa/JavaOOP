package ua.kiev.prog.onishchenko.HomeTasks.Lecture5.Task1_FindFiles;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
Модифицировать проект FindFiles так, чтобы программа искала в каталоге все файлы с расширениями из списка
*/

public class FindFiles {
    static class MyFilter implements FilenameFilter {
        private List<String> ext;

        public MyFilter(List<String> ext) {
            this.ext = ext;
        }

        @Override
        public boolean accept(File dir, String name) {
            for (String s : ext) {
                if (name.endsWith(s)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static void findFiles(String srcPath, List<String> ext, ArrayList<String> list) throws IOException {
        File dir = new File(srcPath);
        File[] files = dir.listFiles(new MyFilter(ext));

        for (int i = 0; i < files.length; i++) {
            list.add(srcPath + files[i].getName());
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> ext = new ArrayList<>();
        ext.add(".txt");
        ext.add(".doc");
        ext.add(".log");
        ext.add(".dat");

        try {
            findFiles("d:\\", ext, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : list) {
            System.out.println(s);
        }
    }


}
