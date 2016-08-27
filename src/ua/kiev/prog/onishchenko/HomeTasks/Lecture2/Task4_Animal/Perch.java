package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task4_Animal;

public class Perch extends Fish {
    Perch() {
        this(1.0);
    }

    Perch(double weight) {
        isRiver = false;
        NAME = "Perch";
        this.weight = weight;
    }

    @Override
    public void eat() {
        System.out.println("Perch eating");
    }

    @Override
    public String toString() {
        return "Perch{canSwim, not river fish, " +
                "weight=" + weight + '}';
    }

    @Override
    public void swim() {
        super.swim();
        System.out.println("perch: swimming");
    }
}
