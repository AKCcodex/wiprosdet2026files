package day11;
import java.io.*;
public class bufer {
	 public static void main(String[] args) {
		    try (BufferedWriter bw = new BufferedWriter(new FileWriter("filename.txt"))) {
		      bw.write("First line");
		      bw.newLine(); 
		      bw.write("Second line");
		      System.out.println("Successfully wrote to the file.");
		      } catch (IOException e) {
		       System.out.println("Error writing file.");
		    }
		    
		   try(BufferedReader br = new BufferedReader(new FileReader("filename.txt"))){
			  String line;
			  while((line=br.readLine())!=null) {
				  System.out.println(line);
			  }
		   }catch(IOException e) {
				  System.out.println("Error in reading file");
			  }
		   }
		  }

