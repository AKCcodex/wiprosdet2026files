package day10;
import java.io.*;

public class ReadJavaLines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sai.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.contains("Java")) {
                System.out.println(line);
            }
        }

        br.close();
    }
}