package ua.kiev.prog.onishchenko.HomeTasks.Lecture3.Task1_2_3_Developer;

/*
	1. Написать своего наследника Developer. Добавить его в существующий проект.
	2. Создать список разработчиков и заполнить его случайным образом. Вывести на экран только Senior developer-ов с
		зарплатой больше 1500 у.е.
	3. Написать код, который разделит список объектов Developer на 3 отдельных списка для Juniors, Seniors и Team Leads.
		Вывести списки на экран.
*/

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Developer[] list = createDevelopers();

		System.out.println("All developers:  ");
		printDevelopers(list);

		System.out.println("\n\nSenior developers with salary more 1500:");
		printDevelopers(filterDeveloper(list, 1500.0, 2));

		Developer[] juniorDev = filterDeveloper(list, 0, 0);
		Developer[] middleDev = filterDeveloper(list, 0, 1);
		Developer[] seniorDev = filterDeveloper(list, 0, 2);

		System.out.println("\n\nAll junior developers:");
		printDevelopers(juniorDev);

		System.out.println("\n\nAll junior developers:");
		printDevelopers(middleDev);

		System.out.println("\n\nAll junior developers:");
		printDevelopers(seniorDev);

	}

	public static Developer[] createDevelopers() {
		Random rand = new Random();
		Developer[] list = new Developer[rand.nextInt(15)+5];
		int[] cnt = new int[4];

		for (int i = 0; i < list.length; i++) {
			switch (rand.nextInt(4)) {
				case 0:
					list[i] = new JuniorDeveloper("Junior #"+(++cnt[0]), 200.0 + rand.nextDouble()*600.0, rand.nextInt(2));
					break;
				case 1:
					list[i] = new MiddleDeveloper("Middle #"+(++cnt[1]), 300.0 + rand.nextDouble()*500.0, rand.nextInt(3)+1);
					break;
				case 2:
					list[i] = new SeniorDeveloper("Senior #"+(++cnt[2]), 300 + rand.nextInt(700), rand.nextInt(5));
					break;
				case 3:
					list[i] = new TeamLeadDeveloper("TeamLead #"+(++cnt[3]), 500.0 + rand.nextDouble()*200.0, rand.nextInt(10)+5);
					break;
			}
		}

		return list;
	}

	public static void printDevelopers(Developer[] list) {
		if (list == null) {
			System.out.println("ListDevelopers is EMPTY");
		} else {
			for (Developer developer : list) {
				System.out.println(developer);
			}
		}
	}

	public static Developer[] filterDeveloper(Developer[] list, double salary, int rang) {
		Developer[] tmp = new Developer[list.length];
		int p = 0;
		for (Developer developer : list) {
			if (validator(developer, salary, rang)) {
				tmp[p++] = developer;
			}
		}
		if (p == 0) {
			return null;
		} else {
			Developer[] result = new Developer[p];
			System.arraycopy(tmp, 0, result, 0, p);
			return result;
		}

	}

	public static boolean validator(Developer developer, double salary, int rang) {
		if (developer.getSalary() < salary) {
			return false;
		} else {
			switch (rang) {
				case 0: return developer instanceof JuniorDeveloper;
				case 1: return developer instanceof MiddleDeveloper;
				case 2: return developer instanceof SeniorDeveloper;
				case 3: return developer instanceof TeamLeadDeveloper;
				default: return false;
			}
		}
	}

}
