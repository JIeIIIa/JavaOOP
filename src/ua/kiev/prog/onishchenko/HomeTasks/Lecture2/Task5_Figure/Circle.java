package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task5_Figure;

public class Circle extends Figure{
    double radius;

    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    Circle() {
        this("Black", 1.0);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 1.0;
        }
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                " | square=" + square() + '}';
    }

    @Override
    double square() {
        return Math.PI * radius * radius;
    }
}
