package ua.kiev.prog.onishchenko.HomeTasks.Lecture4.Task02_Figure;

import java.util.Comparator;

public class FigureComparator implements Comparator<Figure> {
    @Override
    public int compare(Figure o1, Figure o2) {
        if (o1 == null & o2 != null) {
            return -1;
        } else if (o1 != null & o2 == null) {
            return 1;
        } else {
            return Double.compare(o1.square(), o2.square());
        }

    }
}
