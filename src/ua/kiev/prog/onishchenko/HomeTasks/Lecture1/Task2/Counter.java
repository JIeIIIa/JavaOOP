package ua.kiev.prog.onishchenko.HomeTasks.Lecture1.Task2;

/**
 * Написать класс, который умеет считать
 * количество созданных объектов этого класса
 * (static)
 */
public class Counter {
    static private int count = 0;

    Counter() {
        count++;
    }

    public int objectsCreated() {
        return count;
    }
}
