package day7;


class Process {


 synchronized void execute(String task) {
     System.out.println(Thread.currentThread().getName() + " started " + task);
     System.out.println(task);
     System.out.println(Thread.currentThread().getName() + " finished " + task);
 }
}

class Order implements Runnable {
 Process p;

 Order(Process p) {
     this.p = p;
 }

 public void run() {
     p.execute("Order Processing");
 }
}

class Payment implements Runnable {
 Process p;

 Payment(Process p) {
     this.p = p;
 }

 public void run() {
     p.execute("Payment Processing");
 }
}

class Notification implements Runnable {
 Process p;

 Notification(Process p) {
     this.p = p;
 }

 public void run() {
     p.execute("Notification");
 }
}


public class allkeyword {
	

		 public static void main(String[] args) throws InterruptedException {

		        Process p = new Process(); // shared object

		        Thread t1 = new Thread(new Order(p));
		        Thread t2 = new Thread(new Payment(p));
		        Thread t3 = new Thread(new Notification(p));

		        t1.setName("Order-Thread");
		        t2.setName("Payment-Thread");
		        t3.setName("Notification-Thread");

		        t1.start();
		        t1.join();
		        t2.start();
		        t2.join();
		        System.out.println("Is t1 alive? " + t1.isAlive());
		        t3.start();
		        
		 }
		    }


  





    


