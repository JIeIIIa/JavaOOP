package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task3_Phone;

public class IPhone extends Phone {
	
	public IPhone() {
		System.out.println("IPhone constructor");
		
		touch = true;
		hasWifi = true;
		screenSize = 3;
	}
	
	@Override
	final public void call(String number) {
		System.out.println("IPhone class is calling " + number);
	}
	
	@Override
	public void sendSMSAPI(String number, String message) {
		System.out.println("IPhone class is sending sms " + message + " to " + number);	
	}
}
