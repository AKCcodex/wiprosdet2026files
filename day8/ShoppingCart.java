package day8;
import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {


        Map<String, Integer> productMap = new HashMap<>();
        productMap.put("Laptop", 50000);
        productMap.put("Phone", 20000);
        productMap.put("Headphones", 2000);


        List<String> cart = new ArrayList<>();
        cart.add("Laptop");
        cart.add("Phone");

        int total = 0;

        System.out.println("Cart Items:");
        for (String item : cart) {
            System.out.println(item + " - " + productMap.get(item));
            total += productMap.get(item);
        }

        System.out.println("Total Price: " + total);
    }
}