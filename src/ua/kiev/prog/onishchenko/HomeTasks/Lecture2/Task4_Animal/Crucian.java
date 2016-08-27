package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task4_Animal;

public class Crucian extends Fish {
    Crucian() {
        this(1.0);
    }

    Crucian(double weight) {
        isRiver = true;
        NAME = "Crucian";
        this.weight = weight;
    }
    @Override
    public void eat() {
        System.out.println("Crucian eating");
    }

    @Override
    public String toString() {
        return "Crucian{canSwim, river fish, " +
                "weight=" + weight + '}';
    }

    @Override
    public void swim() {
        super.swim();
        System.out.println("crucian: swimming");
    }
}
