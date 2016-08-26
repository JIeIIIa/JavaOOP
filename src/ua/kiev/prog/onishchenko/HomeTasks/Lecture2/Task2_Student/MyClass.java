package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task2_Student;

import java.util.Date;

public class MyClass {

	public static void main(String[] args) {
		StudentList sl = new StudentList();
		
		sl.add(new Student("Seva", "Evgienko", new Date(1986, 1, 1)));
		sl.add(new Student("Vasya", "Pupkin", new Date(1970, 3, 28)));
		
		int n = sl.find("Seva");
		System.out.println(sl.get(n).getBirth().toString());
	}
}
