package ua.kiev.prog.onishchenko.HomeTasks.Lecture3.Task4_RectanglePrinter;
/*
Написать программу, которая будет рисовать на консоли прямоугольник с заданными длинами сторон.
 */

import java.util.Scanner;

public class RectanglePrinter {
    public static void main(String[] args) {
        int height = 0;
        int width = 0;
        Scanner in = new Scanner(System.in);

        while (height <= 0 || width <= 0) {
            System.out.print("Input height: ");
            height = in.nextInt();
            System.out.print("Input width: ");
            width = in.nextInt();
        }
        System.out.println("\n\nYour rectangle:   \n");
        printRectangle(height, width);
    }

    public static void printRectangle(int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char ch = ' ';
                if (i * j == 0 || i == height - 1 || j == width - 1) {
                    ch = '*';
                }
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
