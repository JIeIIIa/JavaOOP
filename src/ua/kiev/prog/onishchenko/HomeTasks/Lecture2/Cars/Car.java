package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Cars;

public class Car {
    private String name;
    private Engine engine; // мотор
    private Climate climate = new Climate(); // климат-контроль
    
    public Car(String name) {
        this.name = name;
        engine = new Engine(0, 1.6);
    }
    
    public Car(String name, double mileage, double capacity) {
        this.name = name;
        engine = new Engine(mileage, capacity);
    }
    
    public String getName() {
        return name;
    }
    
    public double getMileage() {
        return engine.getMileage();
    }

    public double getCapacity() {
        return engine.getCapacity();
    }

    public double getFuelPerMile() {
        return engine.getFuelPerMile();
    }

    public double spentFuel() {
        return engine.getMileage()*engine.getFuelPerMile();
    }

    public double spentFuel(double start, double finish) {
        if (start >= finish) {
            return 0.0;
        } else {
            return (finish - start) * engine.getFuelPerMile();
        }
    }

    public double spentFuel(double start) {
        if (start >= engine.getMileage()) {
            return 0.0;
        } else {
            return (engine.getMileage() - start) * engine.getFuelPerMile();
        }
    }

    // завести мотор
    public void turnOn() {
        engine.turnOn();
        climate.turnOn();
        climate.setTemperature(21);
    }
    
    // заглушить мотор
    public void turnOff() {
        climate.turnOff();
    	engine.turnOff();
    }
    
    // установить скорость
    public void start(int speed, double hours) {
        if (engine.isStarted()) { // еще не заведен мотор
        	// пройденная дистанция
        	double distance = hours * speed;
        	engine.addMileage(distance);
        }
    }
}