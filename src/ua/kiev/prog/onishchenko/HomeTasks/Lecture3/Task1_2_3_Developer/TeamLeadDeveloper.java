package ua.kiev.prog.onishchenko.HomeTasks.Lecture3.Task1_2_3_Developer;

public class TeamLeadDeveloper extends Developer {

	public TeamLeadDeveloper(String name, double basicSalary, int experience) {
		super(name, basicSalary, experience);
	}

	@Override
	public double getSalary() {
		return (basicSalary * 4) + (experience > 0 ? basicSalary * experience * 0.1 : 0);
	}
}
