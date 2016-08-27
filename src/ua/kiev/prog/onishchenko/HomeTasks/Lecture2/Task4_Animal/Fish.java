package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task4_Animal;

public abstract class Fish extends Animal{
    protected boolean isRiver;
    Fish() {
        canSwim = true;
    }

    public void swim() {
        System.out.println("fish: swim-swim-swim");
    }

}
