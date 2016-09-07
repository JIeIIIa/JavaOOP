package ua.kiev.prog.onishchenko.HomeTasks.Lecture5.Task3_ReplaceHello;
/*
Написать программу, которая считает текстовый файл, заменит в нем все слова “Hello” на “1234” и запишет изменения в тот-же файл.
*/


import java.io.*;

public class ReplaceHello {
    private static StringBuffer sb = new StringBuffer();

    public static boolean readData(String filename, StringBuffer sb) {
        int c;
        try (FileInputStream fin = new FileInputStream(filename)) {
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
        try (FileOutputStream fout = new FileOutputStream(filename)) {
            fout.write(sb.toString().getBytes());
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
            return false;
        }
        return true;
    }

    public static void replaceData(StringBuffer sb, String target, String replacement) {
        StringBuffer tmp = new StringBuffer(sb.toString().replace( target, replacement));
        sb.delete(0, sb.length()).append(tmp);

    }

    public static void main(String[] args) {
        readData("D:\\Java\\JavaOOP\\src\\ua\\kiev\\prog\\onishchenko\\HomeTasks\\Lecture5\\Task3_ReplaceHello\\testing.txt", sb);
        System.out.println("Input file:\n" + sb);
        replaceData(sb, "Hello", "1234");
        writeData("D:\\Java\\JavaOOP\\src\\ua\\kiev\\prog\\onishchenko\\HomeTasks\\Lecture5\\Task3_ReplaceHello\\testing.txt", sb);
        System.out.println("\n\nOutput file:\n" + sb);


    }
}
