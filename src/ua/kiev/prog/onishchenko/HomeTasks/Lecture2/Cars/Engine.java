package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Cars;

public class Engine {
    private double mileage;
    private boolean started;
    private double capacity;


    public Engine(double mileage, double capacity) {
        this.capacity = capacity;
        this.mileage = mileage;
    }

    public double getCapacity() {
        return capacity;
    }

    public static double getFuelPerMile(double capacity) {
        if(capacity < 1.6) {
            return 0.08;
        } else if (capacity < 2) {
            return 0.095;
        } else if (capacity < 3) {
            return  0.11;
        } else if (capacity < 4) {
            return 0.125;
        } else {
            return 0;
        }
    }

    public double getFuelPerMile() {
        return getFuelPerMile(capacity);
    }

    public double getMileage() {
        return mileage;
    }
    
    public void addMileage(double mileage) {
        if (started)
            this.mileage += mileage;
    }
    
    public boolean isStarted() {
        return started;
    }
    
    public void turnOn() {
        started = true;
    }
    
    public void turnOff() {
        started = false;
    }
}
