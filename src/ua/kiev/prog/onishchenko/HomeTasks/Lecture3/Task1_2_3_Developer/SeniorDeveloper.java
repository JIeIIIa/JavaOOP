package ua.kiev.prog.onishchenko.HomeTasks.Lecture3.Task1_2_3_Developer;

public class SeniorDeveloper extends Developer {

	public SeniorDeveloper(String name, int basicSalary, int experience) {
		super(name, basicSalary, experience);
	}

	@Override
	public double getSalary() {
		return (basicSalary * 2) + (experience > 0 ? basicSalary * experience * 0.1 : 0);
	}
}
