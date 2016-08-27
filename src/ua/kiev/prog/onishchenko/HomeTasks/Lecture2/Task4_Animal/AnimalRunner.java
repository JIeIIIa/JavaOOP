package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task4_Animal;

public class AnimalRunner {
    public static void main(String[] args) {
        Animal rabbit1 = new Rabbit("Black");
        Animal rabbit2 = new Rabbit();


        System.out.println(rabbit1);
        System.out.println(rabbit2);
        rabbit1.eat();
        System.out.println("------------------------\n");

        Fish fish1 = new Crucian(1.2);
        Fish fish2 = new Perch(3.2);
        System.out.println(fish1);
        System.out.println(fish2);
        fish1.swim();
        fish2.swim();
        fish1.eat();
    }
}
