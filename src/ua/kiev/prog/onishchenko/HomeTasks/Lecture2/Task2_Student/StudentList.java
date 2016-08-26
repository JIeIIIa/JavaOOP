package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task2_Student;

import java.util.Date;

public class StudentList {
	private Student[] list = new Student[100];
	private int p = 0;
	
	public void add(Student s) {
		if(p == list.length) {
			Student[] tmp = new Student[list.length * 2];
			System.arraycopy(list, 0, tmp, 0, p);
			list = tmp;
		}
		list[p++] = s;
	}
	
	public Student get(int n) {
		if (n < 0) {
			return list[0];
		} else if (n > p) {
			return list[p];
		} else {
			return list[n];
		}
	}

	public void delete(int n) {
		if (n>=0 && n<p) {
			System.arraycopy(list,n+1, list, n, list.length - n - 1);
			p--;
		}
	}
	
	public int find(String name) {
		for (int i = 0; i < p; i++) {
			if (list[i].getName().equalsIgnoreCase(name))
				return i;
		}
		
		return -1;
	}

	public int findBySurname(String surname) {
		for (int i = 0; i < p; i++) {
			if (list[i].getSurname().equalsIgnoreCase(surname)) {
				return i;
			}
		}
		return -1;
	}

	public int findByBirth(Date birth) {
		for (int i = 0; i < p; i++) {
			if (list[i].getBirth().equals(birth)) {
				return i;
			}
		}
		return -1;
	}

	public void printAll() {
		for (int i = 0; i < p; i++) {
			System.out.println(list[i]);
		}
	}
}
