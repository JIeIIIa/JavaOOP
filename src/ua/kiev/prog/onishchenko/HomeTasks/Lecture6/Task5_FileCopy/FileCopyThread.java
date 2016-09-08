package ua.kiev.prog.onishchenko.HomeTasks.Lecture6.Task5_FileCopy;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileCopyThread extends Thread {
    private RandomAccessFile src;
    private RandomAccessFile dest;
    private long from;
    private long to;

    public FileCopyThread(String filename, String filename_dest, long from, long to) {

        try {
            this.src = new RandomAccessFile(filename, "r");
            this.dest = new RandomAccessFile(filename_dest, "rw");
        } catch (IOException e) {
        }
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        if (src == null || dest == null) {
            return;
        }
        long p = from;

        try {
            while (p < to && p < src.length() && p < dest.length()) {
                src.seek(p);
                byte b = src.readByte();
                dest.seek(p);
                dest.write(b);
                p++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
