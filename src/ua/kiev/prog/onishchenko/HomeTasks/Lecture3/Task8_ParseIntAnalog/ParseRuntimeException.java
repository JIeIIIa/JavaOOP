package ua.kiev.prog.onishchenko.HomeTasks.Lecture3.Task8_ParseIntAnalog;

public class ParseRuntimeException extends RuntimeException {
    public ParseRuntimeException(String message) {
        super(message);
        System.out.println("-=PARSE EXCEPTION=-");
    }
}
