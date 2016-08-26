package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task3_Phone;

public class Nokia3310 extends Phone {
	
	public Nokia3310() {
		System.out.println("Nokia3310 constructor");
		
		touch = false;
		hasWifi = false;
		screenSize = 2;
	}
	
	@Override
	public void call(String number) {
		super.call(number);
		System.out.println("Nokia3310 class is calling " + number);
	}
	
	@Override
	public void sendSMSAPI(String number, String message) {
		System.out.println("Nokia3310 class is sending sms " + message + " to " + number);	
	}
}
