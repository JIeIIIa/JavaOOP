package ua.kiev.prog.onishchenko.HomeTasks.Lecture3.Task1_2_3_Developer;

import java.util.Formatter;

public abstract class Developer {

	protected String name;
	protected double basicSalary;
	protected int experience;
	
	public Developer(String name, double basicSalary, int experience) {
		this.name = name;
		this.basicSalary = basicSalary;
		this.experience = experience;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBasicSalary() {
		return basicSalary;
	}
	
	public abstract double getSalary();

    @Override
    public String toString() {
        return new Formatter().format("{ name = %11s, basicSalary = %7.2f, experience = %2d} with salary %8.2f",
                name, basicSalary, experience, getSalary()).toString();
    }
}
