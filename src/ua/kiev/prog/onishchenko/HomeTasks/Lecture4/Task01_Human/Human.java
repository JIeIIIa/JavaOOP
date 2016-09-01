package ua.kiev.prog.onishchenko.HomeTasks.Lecture4.Task01_Human;

public class Human implements Comparable{
    private int age;

    public Human(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Human h = (Human) o;
        if (age < h.age) {
            return -1;
        } else if (age == h.age) {
            return 0;
        } else {
            return 1;
        }
    }
}
