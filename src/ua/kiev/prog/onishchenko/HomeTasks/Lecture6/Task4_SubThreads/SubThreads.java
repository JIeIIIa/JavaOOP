package ua.kiev.prog.onishchenko.HomeTasks.Lecture6.Task4_SubThreads;

/*
Создать поток, который создаст 50 потоков, каждый их которых выведет на экран свой номер и дождется, пока его прервут.
Прерывание дочерних потоков должно выполнятся из потока их порождающего.
*/

public class SubThreads {

    public static void main(String[] args) {
        GeneratingThread subThread = new GeneratingThread(50);
        try {
            subThread.start();
            Thread.sleep(3000);
            System.out.println("MAIN is interrupting subthread");
            subThread.interrupt();
            subThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All threads was interrupted");
    }
}
