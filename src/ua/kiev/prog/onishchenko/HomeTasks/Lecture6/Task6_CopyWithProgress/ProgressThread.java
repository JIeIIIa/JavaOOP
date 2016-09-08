package ua.kiev.prog.onishchenko.HomeTasks.Lecture6.Task6_CopyWithProgress;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ProgressThread extends Thread{
    private long targetSize;
    private String filename;

    public ProgressThread(long targetSize, String filename) {
        this.targetSize = targetSize;
        this.filename = filename;
    }

    @Override
    public void run() {

        try (RandomAccessFile file = new RandomAccessFile(filename, "r")) {
            while (!isInterrupted()) {
                System.out.printf(">> %3.2f%%\n", 100.0 * file.length() / targetSize );
                Thread.sleep(50);
            }
        } catch (IOException e) {
            System.out.println("Can't calculate progress.");
        } catch (InterruptedException e) {

        }
    }
}
