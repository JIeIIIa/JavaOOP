package ua.kiev.prog.onishchenko.HomeTasks.Lecture4.Task01_Human;

import java.util.Comparator;

public class HumanComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Human h1 = (Human) o1;
        Human h2 = (Human) o2;

        if (h1.getAge() < h2.getAge()) {
            return -1;
        } else if (h1.getAge() == h2.getAge()) {
            return 0;
        } else {
            return 1;
        }
    }
}
