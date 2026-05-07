package day11;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "aashish";
        Set<Character> set = new LinkedHashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        StringBuilder result = new StringBuilder();
        for (char ch : set) {
            result.append(ch);
        }
        System.out.println("After removing duplicates: " + result);
    }
}