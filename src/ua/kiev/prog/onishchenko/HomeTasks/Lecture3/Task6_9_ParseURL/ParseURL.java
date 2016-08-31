package ua.kiev.prog.onishchenko.HomeTasks.Lecture3.Task6_9_ParseURL;

import java.util.Scanner;

/*  6. Написать метод разбора списка параметров в формате URL: para1=value1&param2=value2&param3=value3. В случае ошибки в
формате бросать исключение.
    9. Придумать свое исключение и написать соответствующий класс и использующий его код.
 */

class ParseException extends Exception {
    public ParseException(String message) {
        super(message);
        System.out.println("\nCritical parse exception ");
    }
}

public class ParseURL {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input string for parse URL parameters:");
        try {
            String[][] param = parseURL(in.nextLine());
            printParameters(param);
        } catch (ParseException e) {
            System.out.println("Error during parse string:\n" + e);
        } catch (RuntimeException e) {
            System.out.println("Runtime exception:\n" + e);
        }

    }

    public static void printParameters(String[][] param) throws RuntimeException{
        if (param.length != 2 || param[0].length != param[1].length) {
            throw new RuntimeException("Disparate length array");
        }
        for (int i = 0; i < param[0].length; i++) {
            System.out.println("{ param[" + i + "] = " + param[0][i] + ", value = " + param[1][i] + "}");
        }
    }
    public static String[][] parseURL(String line) throws ParseException {
        if (line.isEmpty()) {
            throw new ParseException("Can't parse empty line");
        }
        String[] list = line.split("&");

        String[][] result = new String[2][list.length];

        for (int i=0; i < list.length; i++) {
            String[] parse = list[i].split("=");

            if (parse.length > 2) {
                throw new ParseException("Too many values in '" + list[i] + "'");
            } else if (parse[0].isEmpty() || parse[0].equals("")) {
                throw new ParseException("Can't find parameter name in '" + list[i] + "'");
            } else if (parse.length < 2 || parse[1].isEmpty() || parse[1].equals("")) {
                throw new ParseException("Can't find parameter value in '" + list[i] + "'");
            } else {
                result[0][i] = parse[0];
                result[1][i] = parse[1];
            }
        }
        return result;
    }
}
