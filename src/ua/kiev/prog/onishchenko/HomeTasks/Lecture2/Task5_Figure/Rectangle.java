package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task5_Figure;

public class Rectangle extends Figure {
    protected double side1;
    protected double side2;

    Rectangle(String color, double side1, double side2) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
    }

    Rectangle(double side1, double side2) {
        this("Black", side1, side2);
    }

    Rectangle() {
        this(1.0, 1.0);
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        if (side1 > 0) {
            this.side1 = side1;
        } else {
            this.side1 = 1;
        }
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        if (side2 > 0) {
            this.side2 = side2;
        } else {
            this.side2 = 1;
        }
    }

    @Override
    double square() {
        return side1 * side2;
    }

    @Override
    public String toString() {
        return "Rectangle{color=" + color +
                ", side1=" + side1 +
                ", side2=" + side2 +
                " | square = " + square() + "}";
    }
}
