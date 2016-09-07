package ua.kiev.prog.onishchenko.HomeTasks.Lecture5.Task6_ReplaceHelloImprove;

/*
Разобраться с java.io.BufferedInputStream и java.io. BufferedOutputStream.
Подумать как улучшить программу №3 с помощью этих классов.

(3. Написать программу, которая считает текстовый файл, заменит в нем все
    слова “Hello” на “1234” и запишет изменения в тот-же файл.)
*/

import java.io.*;

public class ReplaceHelloImprove {
    private static StringBuffer sb = new StringBuffer();

    public static boolean readData(String filename, StringBuffer sb) {
        int c;

        try (BufferedInputStream fin = new BufferedInputStream(new FileInputStream(filename))) {
            do {
                c = fin.read();
                if (c > -1) {
                    sb.append((char) c);
                }
            } while (c != -1);

        } catch (FileNotFoundException e) {
            System.out.println("File '" + filename + "' not found.");
            return false;
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
            return false;
        }
        return true;
    }

    public static boolean writeData(String filename, StringBuffer sb) {
        try (BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(filename))) {
            for (int i = 0; i < sb.length(); i++) {
                fout.write(sb.charAt(i));
            }
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
            return false;
        }
        return true;
    }

    public static void replaceData(StringBuffer sb, String target, String replacement) {
        int p;
        while((p=sb.indexOf(target)) > -1) {
            sb.replace(p, p + target.length(), replacement);
        }
    }

    public static void main(String[] args) {
        readData("D:\\Java\\TEMP\\testing.txt", sb);
        System.out.println("Input file:\n" + sb);
        replaceData(sb, "1234", "Hello");
        writeData("D:\\Java\\TEMP\\testing.txt", sb);
        System.out.println("\n\nOutput file:\n" + sb);


    }

}
