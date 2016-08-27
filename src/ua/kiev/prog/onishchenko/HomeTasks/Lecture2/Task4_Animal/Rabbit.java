package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task4_Animal;

public class Rabbit extends Animal {
    protected String color;
    Rabbit() {
        this("White");
    }

    Rabbit(String color) {
        this.canJump = true;
        this.canRun = true;
        this.NAME = "Rabbit";
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void eat() {
        System.out.println("Rabbit eating");
    }

    @Override
    public String toString() {
        return "Rabbit{canJump, canRun, " +
                "color='" + color + '\'' +
                "weight=" + weight + '}';
    }
}
