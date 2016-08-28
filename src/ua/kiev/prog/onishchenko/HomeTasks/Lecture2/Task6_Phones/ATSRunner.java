package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task6_Phones;

public class ATSRunner {
    public static void main(String[] args) {

        ATS ats = new ATS();
        System.out.println(ats);
        System.out.println();

        System.out.println("After add phones:");
        ats.addPhone(new SimplePhone("111-11-11", true));
        ats.addPhone(new SimplePhone("111-11-22", false));
        ats.addPhone(new SimplePhone("111-11-33", true));
        ats.addPhone(new SimplePhone("222-11-11", true));
        ats.addPhone(new SimplePhone("333-31-11", false));
        ats.addPhone(new SimplePhone("456-78-11", true));
        System.out.println(ats);

        SimplePhone myPhone = new SimplePhone("555-55-55", false);
        ats.call(myPhone, "222-11-11");
        System.out.println("\nAfter register myPhone in Network");
        ats.addPhone(myPhone);
        ats.registerPhone(myPhone.getNumber());

        ats.call(myPhone, "222-11-11");
        ats.call(myPhone, "333-31-11");
        ats.call(myPhone, "123-45-67");
        ats.registerPhone("333-31-11");
        System.out.println("Phone #333-31-11 registered.");
        ats.call(myPhone, "333-31-11");
    }

}

