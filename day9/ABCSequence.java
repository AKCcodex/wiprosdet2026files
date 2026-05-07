package day9;
class ABCPrinter {
    private int state = 0; 
    public synchronized void printA() {
        for (int i = 0; i < 5; i++) {
            while (state != 0) {
                try { wait(); } catch (InterruptedException e) {}}
            System.out.print("A ");
            state = 1;
            notifyAll();}}
    public synchronized void printB() {
        for (int i = 0; i < 5; i++) {
            while (state != 1) {
                try { wait(); } catch (InterruptedException e) {}
            }
            System.out.print("B ");
            state = 2;
            notifyAll();}}
    public synchronized void printC() {
        for (int i = 0; i < 5; i++) {
            while (state != 2) {
                try { wait(); } catch (InterruptedException e) {}
            }
            System.out.print("C ");
            state = 0;
            notifyAll();}}}
public class ABCSequence {
    public static void main(String[] args) {
        ABCPrinter obj = new ABCPrinter();
        new Thread(() -> obj.printA()).start();
        new Thread(() -> obj.printB()).start();
        new Thread(() -> obj.printC()).start();
    }
}