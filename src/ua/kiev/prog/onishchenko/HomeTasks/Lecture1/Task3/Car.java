package ua.kiev.prog.onishchenko.HomeTasks.Lecture1.Task3;

/**
 * Написать класс «автомобиль», который должен
 * уметь заводится, глушить мотор, ехать и держать
 * необходимую скорость
 */
public class Car {
    private String brand;
    private String model;
    private String color;
    private double distance = 0.0;
    private static final double MAXSPEED = 220.0;

    private boolean engineOn;
    private double speed;

    public Car(String brand, String model, String color, boolean engineOn, double speed) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.engineOn = engineOn;
        setSpeed(speed);
    }

    public Car(String brand, String model, String color) {
        this(brand, model, color, false, 0.0);
    }

    public Car(String brand, String model, String color, boolean engineOn) {
        this(brand, model, color, engineOn, 0.0);
    }

    public Car(String brand, String model, String color, double speed) {
        this(brand, model, color, true, speed);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if(engineOn) {
            this.speed = Math.min(MAXSPEED, Math.max(0, speed));
        }
    }

    public boolean engineStatus() {
        return engineOn;
    }

    public void startEngine() {
        engineOn = true;
        speed = 0.0;
    }

    public void stopEngine() {
        engineOn = false;
        speed = 0;
    }

    public void drive(double hours) {
        distance += speed*hours;
    }

    public double distance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", distance=" + distance +
                ", engineOn=" + engineOn +
                ", speed=" + speed +
                '}';
    }

    public void printMaxSpeed() {
        System.out.println("Max speed = " + MAXSPEED);
    }





}

