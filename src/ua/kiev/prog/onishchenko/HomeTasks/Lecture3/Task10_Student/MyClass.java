package ua.kiev.prog.onishchenko.HomeTasks.Lecture3.Task10_Student;
/*
 Модифицировать проект «Список студентов» так, чтобы
    1) список вводился с клавиатуры
    2) была возможность удалять студента по номеру
    3) при введении неправильных данных (пустое имя, неправильная дата) программа кидала исключение
        и обрабатывала его с выводом соотв. сообщений на экран.
 */

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) {
		StudentList sl = new StudentList();

		sl.add(new Student("Seva", "Evgienko", new Date(1986, 1, 1)));
        sl.add(new Student("Vasya", "Pupkin", new Date(1970, 3, 28)));
        sl.add(new Student("Ivan", "Ivanov", new Date(1992, 4, 30)));
        sl.add(new Student("Petr", "Ivanov", new Date(1989, 12, 03)));
        sl.printAll();

        char ch = ' ';
        do{
            Scanner in = new Scanner(System.in);
            System.out.println("\n\n\n1 - Print all students");
            System.out.println("2 - New student");
            System.out.println("3 - Remove student");
            System.out.println("4 - Find first by name");
            System.out.println("0 - Print all students");
            System.out.print(">>");
            ch = in.next().charAt(0);
            switch (ch) {

                case '1':
                    sl.printAll();
                    break;
                case '2':
                    try {
                        sl.add(inputData());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Wrong one or more argument" + e);
                    } catch (NullPointerException e) {
                        System.out.println("Any parameter can't be null" + e);
                    }
                    break;
                case '3':
                    int p = 0;
                    try {
                        System.out.print("  Position for delete>>");
                        p = in.nextInt();
                        sl.delete(p);
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong input position\n" + e);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Can't delete student at position " + p +"\n" + e);
                    }
                    break;
                case '4':
                    System.out.print("  name for find>>");
                    String name = in.next();
                    try {
                        System.out.println(sl.get(sl.find(name)));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Student can't be found");
                    }
                    break;
                case '0': break;
                default:
                    System.out.println("Input Incorrect");
            }
        } while (ch != '0');
        System.out.println("\n\n\nGOOD BYE...");
	}

	public static Student inputData() {
        Scanner in = new Scanner(System.in);
        System.out.println(  "  -=Input student=-");
        System.out.print("    name>> ");
        String name = in.next();
        System.out.print("    surname>> ");
        String surname = in.next();
        System.out.print("    birth (dd.mm.yyyy))>> ");
        String birth = in.next();
        return new Student(name, surname, birth);

    }

}
