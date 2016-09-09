package ua.kiev.prog.onishchenko.HomeTasks.Lecture6.Task4_SubThreads;

import java.util.ArrayList;
import java.util.List;

public class GeneratingThread extends Thread {
    private int countSubthread;
    private List<Thread> threadList;

    public GeneratingThread(int countSubthread) {
        this.countSubthread = countSubthread;
    }

    @Override
    public void run() {
        printInfo("RUN");
        threadList = generateSubThreads();
        printInfo("generated " + threadList.size() + " subthread(-s)");
        runAllSubThreads();
        while (!isInterrupted());
        printInfo("FINISH");
    }

    private void printInfo(String message) {
        System.out.println("Thread (id: " + getId() + ", name: " + getName() + ") " + message);
    }

    private List<Thread> generateSubThreads() {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < countSubthread; i++) {
            list.add(new GeneratingThread(-1));
        }
        return list;
    }

    private void runAllSubThreads() {
        for (Thread thread : threadList) {
            thread.start();
        }
    }

    @Override
    public void interrupt() {
        if(threadList.size() > 0) {
            printInfo("is interrupting all subthreads.");
        }
        for (Thread thread : threadList) {
            thread.interrupt();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.interrupt();
    }
}
