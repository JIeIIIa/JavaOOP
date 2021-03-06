package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task1_Cars;

public class MyClass {
    public static void main(String[] args) {
        Car bmw = new Car("BMW");
        Car ferrari = new Car("Ferrari", 20000, 3.2);

        System.out.println(bmw.getName() + ": " + bmw.getFuelPerMile() + " liters per mile");
        System.out.println(ferrari.getName() + ": " + Engine.getFuelPerMile(ferrari.getCapacity()) + " liters per mile");
        System.out.println("");

        bmw.turnOn();
        ferrari.turnOn();
            
        final int[] speeds = new int[] {20, 60, 100};
            
        for (int s : speeds)
            bmw.start(s, 0.5);
        for (int s : speeds)
            ferrari.start(s, 1);
            
        bmw.turnOff();
        ferrari.turnOff();
            
        System.out.println(bmw.getName() + ": " + bmw.getMileage() + " miles, " + bmw.spentFuel() + " liters");
        System.out.println(ferrari.getName() + ": " + ferrari.getMileage() + " miles, " + ferrari.spentFuel() + " liters");
    }
}
