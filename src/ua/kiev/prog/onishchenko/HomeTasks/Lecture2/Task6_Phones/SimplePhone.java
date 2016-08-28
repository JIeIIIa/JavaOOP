package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task6_Phones;

public class SimplePhone {
    private String number;
    private boolean registered;

    public SimplePhone(String number, boolean registered) {
        this.number = number;
        this.registered = registered;
    }

    public SimplePhone() {
        this("", false);
    }

    public SimplePhone(String number) {
        this(number, false);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void register() {
        this.registered = true;
    }

    public void unRegister() {
        this.registered = false;
    }

    public void answer() {
        System.out.println("Phone #" + number + " listening You.");
    }

    public void call(String number) {
        System.out.println("#" + this.number + " is calling to #" + number);
    }

    @Override
    public String toString() {
        return "Phone{ number = " + number +
                ", registered = " + registered +
                "}";
    }
}
