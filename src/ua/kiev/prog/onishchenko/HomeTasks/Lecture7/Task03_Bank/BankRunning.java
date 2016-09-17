package ua.kiev.prog.onishchenko.HomeTasks.Lecture7.Task03_Bank;

/*
Решить задачу про банк с помощью чего-нибудь из java.util.concurrent.* Не через Atomic
*/

import java.util.concurrent.Semaphore;

public class BankRunning {
    public static void main(String[] args) {
        Account acc = new Account(1000);
        Semaphore sem = new Semaphore(1);
        Transaction[] transactions = {
                new Transaction(acc, 100, sem),
                new Transaction(acc, 500, sem),
                new Transaction(acc, 200, sem),
                new Transaction(acc, 25, sem),
                new Transaction(acc, 150, sem),
        };

        for (Transaction transaction : transactions) {
            transaction.start();
        }

        for (Transaction transaction : transactions) {
            try {
                transaction.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total: " + acc.getMoney());
    }
}
