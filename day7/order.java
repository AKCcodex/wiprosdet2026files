//package day7;
//
//class Order implements Runnable {
//    public void run() {
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Order processing");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println(e);
//            }
//        }
//    }
//}
//
//class Payment implements Runnable {
//    public void run() {
//    	System.out.println("Payment processing");
//    	try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            System.out.println(e);
//        }
//        
//    }
//}
//
//class Notification implements Runnable {
//    public void run() {
//        System.out.println("Order is ready to pick up");
//    }
//}
//
//public class order {
//    public static void main(String[] args) throws  InterruptedException{
//
//        Thread t1 = new Thread(new Order());
//        Thread t2 = new Thread(new Payment());
//        Thread t3 = new Thread(new Notification());
//
//       
//            t1.start();
//            
//            t2.start();
//           t1.join();
//
//            t3.start(); 
//
//    }
//}