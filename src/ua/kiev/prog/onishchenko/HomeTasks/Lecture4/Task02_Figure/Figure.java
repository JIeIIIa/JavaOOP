package ua.kiev.prog.onishchenko.HomeTasks.Lecture4.Task02_Figure;

abstract public class Figure implements Comparable{
    protected String name = "";
    protected String color;

    Figure(String color) {
        this.color = color;
    }

    Figure() {
        this("Black");
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    abstract double square();

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return 1;
        }

        return Double.compare(this.square(), ((Figure)o).square());
    }


}
