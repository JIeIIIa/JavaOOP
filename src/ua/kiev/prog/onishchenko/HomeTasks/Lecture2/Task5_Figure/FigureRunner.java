package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task5_Figure;

public class FigureRunner {
    public static void main(String[] args) {
        Triangle triangle = new Triangle("Green", 3, 4, 90);
        System.out.println(triangle);
        triangle.setColor("Red");
        triangle.setSide1(10);

        Figure figure = new Rectangle(10, 12);
        System.out.println(figure);

        figure = new Circle();
        System.out.println(figure);

        System.out.println("triangle.square() > figure.square() = " + (triangle.square() > figure.square()));
    }
}
