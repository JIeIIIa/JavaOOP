package ua.kiev.prog.onishchenko.HomeTasks.Lecture3.Task8_ParseIntAnalog;

public class ParseInt {
    public static int parse(String value, int radix) throws NullPointerException, ParseRuntimeException{
        if (value == null) {
            throw new NullPointerException("Can't parse null string");
        }
        if (value.isEmpty()) {
            throw new ParseRuntimeException("Can't parse empty string");
        }
        if (radix < 2 || radix > 10) {
            throw new ParseRuntimeException("Wrong radix");
        }
        int sign = 1;
        int result = 0;
        int p = 0;
        char[] array = value.toCharArray();
        if (array[0] == '-') {
            p++;
            sign = -1;
            if (array.length == 1) {
                throw new ParseRuntimeException("Incorrect string");
            }
        }
        while (p < array.length) {
            if (Character.isDigit(array[p]) && array[p] < '0' + radix) {
                int tmp = result * radix + (array[p] - '0');
                if (tmp < result) {
                    throw new ParseRuntimeException("Can't parse number to int.");
                } else {
                    result = tmp;
                }
            } else {
                throw new ParseRuntimeException("Unexpected character '"+array[p] + "' in position " + p);
            }
            p++;
        }

        return result*sign;
    }

    public static int parse(String value) throws NullPointerException, ParseRuntimeException {
        return parse(value, 10);
    }
}
