package ua.kiev.prog.onishchenko.HomeTasks.Lecture3.Task10_Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Student {
	private String name;
	private String surname;
	private Date birth;
	
	public Student(String name, String surname, Date birth) {
		setName(name);

		setSurname(surname);
		this.birth = birth;
	}

	public Student(String name, String surname, String birth) throws IllegalArgumentException{
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date birthDay;
		try {
			birthDay = format.parse(birth);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Unexpected format for BirthDay.");
		}
		setName(name);
		setSurname(surname);
		this.birth = birthDay;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalArgumentException, NullPointerException{
		if (name == null) {
			throw new NullPointerException("NAME can't be null");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("NAME can't be empty");
		}
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		if (surname == null) {
			throw new NullPointerException("NAME can't be null");
		}
		if (surname.isEmpty()) {
			throw new IllegalArgumentException("NAME can't be empty");
		}
		this.surname = surname;
	}
	
	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Student{")
				.append("name='").append(name).append('\'')
				.append(", surname='").append(surname).append('\'')
				.append(", birth=").append(birth)
				.append('}').toString();
	}
}
