package ua.kiev.prog.onishchenko.HomeTasks.Lecture1.Task1;

/**
 * Написать класс Circle (круг) по аналогии с
 * Rectangle и метод, который будет возвращать его
 * площадь.
 */

public class Circle {
    private double radius;
    private double oX;
    private double oY;

    Circle(double radius, double oX, double oY) {
        this.radius = radius;
        this.oX = oX;
        this.oY = oY;
    }
    Circle() {
        this(1.0, 0.0, 0.0);
    }
    Circle(double radius) {
        this(radius, 0.0, 0.0);
    }

    Circle(double oX, double oY) {
        this(1.0, oX, oY);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getoX() {
        return oX;
    }

    public void setoX(double oX) {
        this.oX = oX;
    }

    public double getoY() {
        return oY;
    }

    public void setoY(double oY) {
        this.oY = oY;
    }

    public double square() {
        return Math.PI * radius * radius;
    }

    public void moveTo(double oX, double oY) {
        this.oX = oX;
        this.oY = oY;
    }

    public double length() {
        return 2 * Math.PI * radius;
    }

    public static Circle combine(Circle circle1, Circle circle2) {
        return new Circle(circle1.radius + circle2.radius, circle1.oX + circle2.oX, circle1.oY + circle2.oY);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", oX=" + oX +
                ", oY=" + oY +
                '}';
    }
}
