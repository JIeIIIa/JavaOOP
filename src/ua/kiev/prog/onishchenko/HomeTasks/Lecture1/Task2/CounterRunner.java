package ua.kiev.prog.onishchenko.HomeTasks.Lecture1.Task2;

public class CounterRunner {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        System.out.println("Objects created: " + new Counter().objectsCreated());
    }
}
