package ua.kiev.prog.onishchenko.HomeTasks.Lecture1.Task3;

public class CarRunner {
    public static void main(String[] args) {
        //create objects
        Car audi = new Car("Audi", "A6", "white");
        Car bmw = new Car("BMW", "X5", "black", true, 60.0);

        System.out.println("Audi engine status: " + audi.engineStatus());
        System.out.println("BMW engine status: " + bmw.engineStatus());

        //drive
        audi.startEngine();
        audi.setSpeed(50.0);
        for(int i = 0; i<10; i++) {
            audi.drive(Math.random()*10);
            audi.setSpeed(Math.random()*100);
            bmw.drive(Math.random()*10);
            bmw.setSpeed(Math.random()*150);
            System.out.println("Audi: speed = " + audi.getSpeed() + ", distance = " + audi.distance());
            System.out.println("BMW : speed = " + bmw.getSpeed() + ", distance = " + bmw.distance());
        }

        //info about cars
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println();

        //stop engines
        audi.stopEngine();
        bmw.stopEngine();

        System.out.println(audi);
        System.out.println(bmw);

    }
}
