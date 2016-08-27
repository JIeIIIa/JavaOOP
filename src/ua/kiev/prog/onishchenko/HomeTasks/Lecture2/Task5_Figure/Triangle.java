package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task5_Figure;

public class Triangle extends Rectangle {
    protected double angle;

    Triangle(String color, double side1, double side2, double angle) {
        super(color, side1, side2);
        this.angle = angle;
    }

    Triangle(double side1, double side2, double angle) {
        this("Black", side1, side2, angle);
    }

    Triangle() {
        this(1.0, 1.0, 90.0);
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        if (angle > 0 && angle < 180) {
            this.angle = angle;
        } else {
            this.angle = 90.0;
        }
    }

    @Override
    double square() {
        return side1 * side2 * Math.sin(angle/180.0*Math.PI)/2.0;
    }

    @Override
    public String toString() {
        return "Triangle{color=" + color +
                ", side1=" + side1 +
                ", side2=" + side2 +
                ", angle=" + angle +
                " | square = " + square() + "}";
    }
}
