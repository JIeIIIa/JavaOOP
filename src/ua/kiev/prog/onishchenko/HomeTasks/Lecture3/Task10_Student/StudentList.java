package ua.kiev.prog.onishchenko.HomeTasks.Lecture3.Task10_Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentList {
	private List<Student> list = new ArrayList<>();

	
	public void add(Student s) {
		list.add(s);
	}
	
	public Student get(int n) throws IndexOutOfBoundsException{
		if (n < 0) {
			throw new IndexOutOfBoundsException("Too small index");
		} else if (n >= list.size()) {
			throw new IndexOutOfBoundsException("Too great index");
		} else {
			return list.get(n);
		}
	}

	public void delete(int n) throws IndexOutOfBoundsException{
		if (n >= 0 && n < list.size()) {
			list.remove(n);
		} else {
			throw new IndexOutOfBoundsException("Incorrect index");
		}

	}
	
	public int find(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equalsIgnoreCase(name))
				return i;
		}
		return -1;

	}

	public int findBySurname(String surname) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSurname().equalsIgnoreCase(surname)) {
				return i;
			}
		}
		return -1;
	}

	public int findByBirth(Date birth) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBirth().equals(birth)) {
				return i;
			}
		}
		return -1;
	}

	public void printAll() {
		for (Student student : list) {
			System.out.println(student);
		}
	}

}
