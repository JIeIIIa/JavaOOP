package ua.kiev.prog.onishchenko.HomeTasks.Lecture5.Task4_FilesCopy;

/*
Написать программу для копирования всех файлов из одного каталога в другой.
*/

import java.io.*;

public class FilesCopy {
    public static boolean copyFile(String src, String dest) {
        try (BufferedInputStream fin = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(dest))
        ) {
            byte[] buf = new byte[1024];
            int r;

            do {
                r = fin.read(buf);
                if (r > 0) {
                    fout.write(buf);
                }
            } while (r>0);
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
            return false;
        }
        return true;
    }

    public static int copyAll(String src, String dest) {
        int err = 0;
        new File(dest).mkdirs();
        File[] files = new File(src).listFiles();
        if (files != null) {
            for (File file : files) {
                try {
                    if (file.isFile()) {
                        if (!copyFile(file.getCanonicalPath(), dest + "\\" + file.getName())) {
                            err++;
                        }
                    } else {
                        new File(dest + "\\" + file.getName()).mkdir();
                        copyAll(src + "\\" + file.getName(), dest + "\\" + file.getName());
                    }

                } catch (IOException e) {
                    System.out.println("I/O error: " + e);
                    err++;
                }
            }
        }
        return err;
    }

    public static void main(String[] args) {
        int err = copyAll("D:\\Java\\TEMP\\IN", "D:\\Java\\TEMP\\OUT");
        if (err == 0) {
            System.out.println("copy successful");
        } else {
            System.out.println(err + " error(-s)");
        }
    }

}
