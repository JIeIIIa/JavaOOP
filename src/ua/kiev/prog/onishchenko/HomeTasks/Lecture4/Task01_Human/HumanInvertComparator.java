package ua.kiev.prog.onishchenko.HomeTasks.Lecture4.Task01_Human;

public class HumanInvertComparator extends HumanComparator {
    @Override
    public int compare(Object o1, Object o2) {
        return super.compare(o2, o1);
    }
}
