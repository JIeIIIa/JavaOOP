package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task5_Figure;

abstract public class Figure {
    protected String name = "";
    protected String color;

    Figure(String color) {
        this.color = color;
    }

    Figure() {
        this("Black");
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    abstract double square();
}
