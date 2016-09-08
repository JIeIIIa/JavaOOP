package ua.kiev.prog.onishchenko.HomeTasks.Lecture6.Task6_CopyWithProgress;

import java.io.*;

public class CopyThread extends Thread{
    private String filename;
    private String filename_copy;

    public CopyThread(String filename, String filename_copy) {
        this.filename = filename;
        this.filename_copy = filename_copy;
    }

    @Override
    public void run() {
        ProgressThread progressThread = null;
        try (RandomAccessFile src = new RandomAccessFile(filename, "r");
             RandomAccessFile dest = new RandomAccessFile(filename_copy, "rw")
        ){
            progressThread = new ProgressThread(src.length(), filename_copy);
            progressThread.start();

            byte[] buf = new byte[1024];
            int cnt;
            do {
                cnt = src.read(buf);
                if (cnt != -1) {
                    dest.write(buf);
                }
            } while (cnt > -1);

        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        } finally {
            if (progressThread != null) {
                progressThread.interrupt();
            }
        }

    }
}
