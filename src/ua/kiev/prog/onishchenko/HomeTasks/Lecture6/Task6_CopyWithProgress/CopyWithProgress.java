package ua.kiev.prog.onishchenko.HomeTasks.Lecture6.Task6_CopyWithProgress;

/*
Написать программу копирования файла с выводом прогресса в % на консоль.
*/

public class CopyWithProgress {
    private static String filename = "D:\\Java\\TEMP\\input.tmp";
    private static String filename_copy = "D:\\Java\\TEMP\\copyWithProgress.tmp";
    public static void main(String[] args) {
        try {
            CopyThread copyThread = new CopyThread(filename, filename_copy);
            copyThread.start();
            copyThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
