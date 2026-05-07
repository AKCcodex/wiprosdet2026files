package day9;
class NumberPrinter {
    private int number = 1;
    private final int MAX = 100;

    public synchronized void printOdd() {
        while (number <= MAX) {
            if (number % 2 == 0) {
                try { wait(); } catch (InterruptedException e) {}
            } else {
                System.out.println("Odd: " + number++);
                notify();
            }}}

    public synchronized void printEven() {
        while (number <= MAX) {
            if (number % 2 != 0) {
                try { wait(); } catch (InterruptedException e) {}
            } else {
                System.out.println("Even: " + number++);
                notify();
            }}}}

public class EvenOdd {
    public static void main(String[] args) {
        NumberPrinter obj = new NumberPrinter();

        Thread t1 = new Thread(() -> obj.printOdd());
        Thread t2 = new Thread(() -> obj.printEven());

        t1.start();
        t2.start();
    }
}