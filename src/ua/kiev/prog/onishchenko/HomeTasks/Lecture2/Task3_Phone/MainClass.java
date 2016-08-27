package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task3_Phone;

public class MainClass {

	public static void main(String[] args) {
		// Phone p = new Phone(); ошибка т.к. класс абстрактный
		
		Nokia3310 nokia = new Nokia3310();
		System.out.println("Nokia3310 screent size: " + nokia.getScreenSize());
		nokia.call("123-45-67");
		nokia.sendSMS("567-78-89", "text message");
		nokia.statistics();
		System.out.println("----------------------------------");
		
		IPhone iphone = new IPhone();
		System.out.println("IPhone screent size: " + iphone.getScreenSize());
		iphone.call("123-45-67");
		iphone.sendSMS("567-78-89", "text message");
        iphone.statistics();
		System.out.println("----------------------------------");
		
		IPhone5 iphone5 = new IPhone5();
		System.out.println("IPhone screent size: " + iphone5.getScreenSize());
		iphone5.call("123-45-67");
		iphone5.sendSMS("567-78-89", "text message");
        iphone5.statistics();
        System.out.println("----------------------------------");

        Samsung4 samsung4 = new Samsung4();
        System.out.println("Samsung4 screent size: " + samsung4.getScreenSize());
        samsung4.call("123-45-67");
        samsung4.sendSMS("567-78-89", "text message");
        samsung4.sendSMS("567-78-89", "another text message");
        samsung4.sendSMS("567-78-89", "my friend.");
        samsung4.statistics();
	}
}
