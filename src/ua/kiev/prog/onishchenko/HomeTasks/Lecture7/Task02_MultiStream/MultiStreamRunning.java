package ua.kiev.prog.onishchenko.HomeTasks.Lecture7.Task02_MultiStream;

/*
Написать класс, который позволит записывать текстовые данные в один файл из разных потоков.
*/

import java.io.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.locks.ReentrantLock;

public class MultiStreamRunning {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ForkJoinPool es = new ForkJoinPool();
        try (OutputStreamWriter out = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("D:\\Java\\TEMP\\output.txt")));
             InputStreamReader in1 = new InputStreamReader(new BufferedInputStream(new FileInputStream("D:\\Java\\TEMP\\1.txt")));
             InputStreamReader in2 = new InputStreamReader(new BufferedInputStream(new FileInputStream("D:\\Java\\TEMP\\2.txt")));
             InputStreamReader in3 = new InputStreamReader(new BufferedInputStream(new FileInputStream("D:\\Java\\TEMP\\3.txt")))
        ) {
            es.invoke(new MultiStreamAction(in1, out, lock));
            es.invoke(new MultiStreamAction(in2, out, lock));
            es.invoke(new MultiStreamAction(in3, out, lock));
        } catch (IOException e) {
            e.printStackTrace();
        }
        es.shutdown();
    }
}

class MultiStreamAction extends RecursiveAction{
    private InputStreamReader in;
    private ReentrantLock lock;
    private OutputStreamWriter out;

    public MultiStreamAction(InputStreamReader in, OutputStreamWriter out, ReentrantLock lock) {
        this.in = in;
        this.lock = lock;
        this.out = out;
    }

    @Override
    protected void compute() {
        lock.lock();
        int c;
        try {

            do {
                c = in.read();
                if(c > -1) {
                    out.write(c);
                }
            } while (c > -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}
