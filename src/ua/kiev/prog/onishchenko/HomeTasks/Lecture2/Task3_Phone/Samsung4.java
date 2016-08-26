package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task3_Phone;

public class Samsung4 extends Phone{
    Samsung4() {
        System.out.println("Samsung4 constructor");

        screenSize = 5;
        hasWifi = true;
    }

    @Override
    public void sendSMSAPI(String number, String message) {
        System.out.println("Samsung4 class is sending sms \"Hello, " + message + "\" to " + number);
    }
}
