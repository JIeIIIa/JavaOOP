package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task3_Phone;

public class IPhone5 extends IPhone {
	
	public IPhone5() {
		System.out.println("IPhone5 constructor");

		screenSize = 4;
	}
	
	/*@Override
	public void call(String number) {
		System.out.println("IPhone class is calling " + number);
	}*/ // ошибка т.к. метод final
	
	@Override
	public void sendSMSAPI(String number, String message) {
		super.sendSMSAPI(number, message);
		System.out.println("IPhone5 class is sending sms " + message + " to " + number);	
	}
}
