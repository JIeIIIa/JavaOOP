package ua.kiev.prog.onishchenko.HomeTasks.Lecture3.Task8_ParseIntAnalog;
/*
Написать аналог Integer.parseInt. Использовать исключения.
*/
public class ParseIntRunner {

    public static void main(String[] args) {
        testParsing(null);
        testParsing("");
        testParsing("-1234");
        testParsing("--1234");
        testParsing("75684");
        testParsing("854987", 5);
        testParsing("12345678912345");

    }

    public static void testParsing(String value, int radix) {
        try {
            System.out.print("Parse '" + value + "' = " );
            System.out.println( ParseInt.parse(value, radix));

        } catch (NullPointerException e) {
            System.out.println("Please enter the string.\n" + e);
        } catch (ParseRuntimeException e) {
            System.out.println("Other parse exception.\n" + e);
        }
        System.out.println();
    }

    public static void testParsing(String value) {
        testParsing(value, 10);
    }
}
