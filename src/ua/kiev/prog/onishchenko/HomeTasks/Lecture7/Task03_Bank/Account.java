package ua.kiev.prog.onishchenko.HomeTasks.Lecture7.Task03_Bank;

public class Account {
    private int money;

    public Account(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void withdraw(int amount) {
        try {
            if (money >= amount) {
                money -= amount;
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
