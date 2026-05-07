package day9;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Order implements Runnable {
    private int orderId;

    Order(int id) {
        this.orderId = id;
    }

    public void run() {
        System.out.println("Processing Order " + orderId +
                " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        System.out.println("Completed Order " + orderId);
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {

        ExecutorService agents = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            agents.execute(new Order(i));
        }

        agents.shutdown();
    }
}
