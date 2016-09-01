package ua.kiev.prog.onishchenko.HomeTasks.Lecture4.Task02_Figure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/*
 Создать список фигур. Реализовать сортировку списка по возрастанию площади фигуры.
 */
public class CompareFigureDemo {
    public static void main(String[] args) {
        Figure[] list = createFigure();

        System.out.println("\n\nFirst list");
        printSquare(list);

        System.out.println("Sorted list (by comparable):");
        Arrays.sort(list);
        printSquare(list);

        System.out.println("\n\nSecond list");
        list = createFigure();
        printSquare(list);
        System.out.println("Sorted list (by comparator):");
        Arrays.sort(list, new FigureComparator());
        printSquare(list);


        System.out.println("\n\nThird list");
        list = createFigure();
        printSquare(list);
        System.out.println("Sorted list descending (by anonymous comparator):");
        Arrays.sort(list, new Comparator<Figure>() {
            @Override
            public int compare(Figure o1, Figure o2) {
                return Double.compare(o2.square(), o1.square());
            }
        });


        printSquare(list);
    }



    public static void printSquare(Figure[] list) {
        System.out.print("[");
        for (Figure figure : list) {
            if (figure instanceof Circle) {
                System.out.print("(C)");
            } else if (figure instanceof Rectangle) {
                System.out.print("(R)");
            } else if (figure instanceof Triangle) {
                System.out.print("(T)");
            }
            System.out.printf("%.2f  ",figure.square());
        }
        System.out.println("]");
    }

    public static Figure[] createFigure() {
        Random rand = new Random();
        Figure[] list = new Figure[rand.nextInt(20) + 5];

        for (int i = 0; i < list.length; i++) {
            switch (rand.nextInt(3)) {
                case 0:
                    list[i] = new Circle("Black", rand.nextDouble() * 3 + 1.0);
                    break;
                case 1:
                    list[i] = new Rectangle("Green", rand.nextDouble() * 3 + 1.0, rand.nextDouble() * 4 + 1.0);
                    break;
                case 2:
                    list[i] = new Triangle("Blue", rand.nextDouble() * 3 + 1.0, rand.nextDouble() * 3 + 1.0, rand.nextDouble() * 179 + 1);
                    break;
            }
        }
        return list;
    }
}
