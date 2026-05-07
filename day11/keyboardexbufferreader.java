package day11;
import java.io.*;
public class keyboardexbufferreader {
	  public static void main(String[] args) throws IOException {
		  BufferedReader br = new BufferedReader(new FileReader("filename.txt"));

	        System.out.print("Enter your name: ");
	        String name = br.readLine();

	        System.out.print("Enter your age: ");
	        int age = Integer.parseInt(br.readLine());

	        System.out.println("Name: " + name);
	        System.out.println("Age: " + age);
	    }
}
