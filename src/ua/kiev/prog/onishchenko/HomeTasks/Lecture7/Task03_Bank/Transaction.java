package ua.kiev.prog.onishchenko.HomeTasks.Lecture7.Task03_Bank;

import java.util.concurrent.Semaphore;

public class Transaction extends Thread{
    private Account account;
    private int withdraw;
    private Semaphore semaphore;

    public Transaction(Account account, int withdraw, Semaphore semaphore) {
        this.account = account;
        this.withdraw = withdraw;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(System.currentTimeMillis() % 50);
            System.err.println("wait acquire for " + withdraw);
            semaphore.acquire();
            System.err.println("acquire for " + withdraw);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.withdraw(withdraw);
        semaphore.release();
        System.err.println("release for " + withdraw);
    }
}
