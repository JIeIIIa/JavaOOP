package ua.kiev.prog.onishchenko.HomeTasks.Lecture1.Task1;


public class CircleRunner {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(10.3, 2.2, 4.0);

        System.out.println(circle1 + ":   length = " + circle1.length() + "   square = " + circle1.square());
        System.out.println(circle2 + ":   length = " + circle2.length() + "   square = " + circle2.square());
        System.out.println();

        //change circle1
        circle1.setRadius(6.4);
        circle1.moveTo(4.0, 6.0);
        System.out.println(circle1);

        //combine circles
        Circle circleCombine = Circle.combine(circle1, circle2);
        System.out.println("Combine two circles: " + circleCombine);
        System.out.println("Another print for circleCombine: radius = " + circleCombine.getRadius()
                            + ", oX = " + circleCombine.getoX()
                            + ", oY = " + circleCombine.getoY());

    }
}
