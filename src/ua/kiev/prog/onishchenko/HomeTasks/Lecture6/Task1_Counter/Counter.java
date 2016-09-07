package ua.kiev.prog.onishchenko.HomeTasks.Lecture6.Task1_Counter;

/*
Модифицировать класс Counter так, чтобы он циклически выводил числа из определенного диапазона.
*/

public class Counter {
    public static class CounterThread extends Thread {
        private int from;
        private int to;

        public CounterThread(int from, int to) {
            super();
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {
            int x = 0;
            while (!isInterrupted()) {
                System.out.println(getId() + ": " + (from + x));
                if (from < to) {
                    x++;
                    if (from + x > to) {
                        x = 0;
                    }
                } else {
                    x--;
                    if(from + x < to){
                        x = 0;
                    }
                }
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            CounterThread counterThread = new CounterThread(9, 15);
            counterThread.start();

            Thread.sleep(6000);
            counterThread.interrupt();
        } catch (Exception e) {
            return;
        }

    }
}
