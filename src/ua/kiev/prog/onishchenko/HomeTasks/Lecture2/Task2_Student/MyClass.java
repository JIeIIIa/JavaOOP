package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task2_Student;

import java.util.Date;

public class MyClass {

	public static void main(String[] args) {
		StudentList sl = new StudentList();

		sl.add(new Student("Seva", "Evgienko", new Date(1986, 1, 1)));
        sl.add(new Student("Vasya", "Pupkin", new Date(1970, 3, 28)));
        sl.printAll();

        sl.delete(2);
        System.out.println("\nAfter deleting:");
        sl.printAll();

        System.out.println();
        int n = sl.find("Seva");
		System.out.println("Find by name: " + sl.get(n).getBirth().toString());
        System.out.println("Find by surname: " + sl.get(sl.findBySurname("Pupkin")));
        System.out.println("Find by date: " + sl.get(sl.findByBirth(new Date(1986, 1, 1))));

        sl.delete(1);
        System.out.println("\nAfter deleting:");
        sl.printAll();
	}
}
