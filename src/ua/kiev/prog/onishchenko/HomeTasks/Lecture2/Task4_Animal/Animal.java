package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task4_Animal;

public abstract class Animal {
    protected String NAME;
    protected double weight;

    protected boolean canJump;

    protected boolean canSwim;
    Animal() {
        canJump = false;
        canRun = false;
        canSwim = false;
    }

    protected boolean canRun;
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isCanJump() {
        return canJump;
    }

    public boolean isCanRun() {
        return canRun;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public String getName () {
        return NAME;
    }

    public abstract void eat();
}
