package day9;
class BankAccount {
    private int balance = 1000;
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() +
                " Deposited: " + amount + " | Balance: " + balance);
        notify();
    }
    public synchronized void withdraw(int amount) {
        while (balance < amount) {
            System.out.println("Waiting for deposit...");
            try { wait(); } catch (InterruptedException e) {}
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() +
                " Withdraw: " + amount + " | Balance: " + balance);}}
public class BankSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Runnable depositTask = () -> {
            for (int i = 0; i < 3; i++) {
                account.deposit(500);
            }
        };
        Runnable withdrawTask = () -> {
            for (int i = 0; i < 3; i++) {
                account.withdraw(700);
            } };
        new Thread(depositTask, "Depositor").start();
        new Thread(withdrawTask, "Withdrawer").start();
    }
}