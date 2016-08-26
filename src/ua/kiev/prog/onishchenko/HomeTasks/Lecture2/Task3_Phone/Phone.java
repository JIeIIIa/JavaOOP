package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task3_Phone;

public abstract class Phone {
	
	protected boolean touch;
	protected boolean hasWifi;
	protected int screenSize;
    private int cntSms;
    private int cntCall;
	
	public Phone() {
		System.out.println("Phone constructor");
        cntCall = 0;
        cntSms = 0;
	}
	
	public boolean isTouch() {
		return touch;
	}
	
	public boolean isHasWifi() {
		return hasWifi;
	}
	
	public int getScreenSize() {
		return screenSize;
	}
	
	public void call(String number) {
	    cntCall++;
		System.out.println("Phone class is calling " + number);
	}

    public abstract void sendSMSAPI(String number, String message);

    public void sendSMS(String number, String message) {
        cntSms++;
        sendSMSAPI(number, message);
    }

    public void statistics() {
        System.out.println("SMS:  " + cntSms + "     Calls:  " + cntCall);
    }
}
