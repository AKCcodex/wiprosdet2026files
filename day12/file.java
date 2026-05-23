package day12;
import java.io.*;
public class file {
	  public static void main(String[] args) {
	        try {
	           
	            FileWriter fw = new FileWriter("ashish1.txt");
	            fw.write("hi my name is ashish");
	            fw.write("\n namaste");
	            fw.close();
	            System.out.println("Write successful");

	            BufferedReader br = new BufferedReader(new FileReader("ashish1.txt"));
	            String line;

	            while ((line = br.readLine()) != null) {
	                System.out.println(line);
	            }

	            br.close();

	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
}
