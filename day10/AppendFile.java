package day10;
import java.io.*;
import java.util.Scanner;

public class AppendFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        FileWriter fw = new FileWriter("input.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        System.out.println("Enter text to append:");
        String data = sc.nextLine();

        bw.write(data);
        bw.newLine();

        bw.close();
        sc.close();

        System.out.println("Data appended successfully.");
    }
}