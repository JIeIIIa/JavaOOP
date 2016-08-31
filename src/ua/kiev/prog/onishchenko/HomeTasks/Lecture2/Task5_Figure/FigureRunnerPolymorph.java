package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task5_Figure;

import java.util.Random;

/*
 Построить иерархию классов «Фигуры» с учетом знаний о полиморфизме. У каждого класса фигуры должен быть
метод подсчета площади. Создать список фигур. Вывести площади всех фигур на экран.
 */
public class FigureRunnerPolymorph {
    public static void main(String[] args) {
        Figure[] list = createFigure();
        printSquare(list);
    }

    public static void printSquare(Figure[] list) {
        int cnt = 0;
        for (Figure figure : list) {
            System.out.print("Figure#" + (++cnt) + " is ");
            if (figure instanceof Circle) {
                System.out.print("Circle.");
            } else if (figure instanceof Rectangle) {
                System.out.print("Rectangle.");
            } else if (figure instanceof Triangle) {
                System.out.print("Triangle.");
            }
            System.out.println(" Square = " + figure.square());
        }
    }

    public static Figure[] createFigure() {
        Random rand = new Random();
        Figure[] list = new Figure[rand.nextInt(20) + 5];

        for (int i = 0; i < list.length; i++) {
            switch (rand.nextInt(3)) {
                case 0:
                    list[i] = new Circle("Black", rand.nextDouble() * 20 + 1.0);
                    break;
                case 1:
                    list[i] = new Rectangle("Green", rand.nextDouble() * 40 + 1.0, rand.nextDouble() * 40 + 1.0);
                    break;
                case 2:
                    list[i] = new Triangle("Blue", rand.nextDouble() * 35 + 1.0, rand.nextDouble() * 35 + 1.0, rand.nextDouble() * 179 + 1);
                    break;
            }
        }
        return list;
    }
}
