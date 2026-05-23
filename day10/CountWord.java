package day10;
import java.io.*;
public class CountWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sai.txt"));
        String line;
        int count = 0;
        String target = "Java";

        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");

            for (String word : words) {
                if (word.equalsIgnoreCase(target)) {
                    count++;
                }
            }
        }

        br.close();
        System.out.println("Occurrences of '" + target + "': " + count);
    }
}