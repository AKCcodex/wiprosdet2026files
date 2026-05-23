package day12;
import java.io.*;
public class hospitalmanagement {
public static void main(String[] args) {
	try {
		BufferedWriter pw=new BufferedWriter(new FileWriter("patitents.txt"));
		int pId=101;
		String pname="ashihs";
		int age=23;
		String disease="diabetes";
		String p="ID: "+pId+
				" name : "+pname+
				" age : "+age+
				" Disease: "+disease;
		pw.write(p);
		pw.newLine();
		pw.close();
		 System.out.println("patitent created");
		BufferedWriter rw=new BufferedWriter(new FileWriter("patitents"+pId + ".txt"));
		String doctor="prashant";
		String treatment="meads";
		rw.write("----- MEDICAL REPORT -----\n");
         rw.write("Patient ID: " + pId + "\n");
         rw.write("Name: " + pname + "\n");
         rw.write("Doctor: " + doctor + "\n");
         rw.write("Diagnosis: " + disease + "\n");
         rw.write("Treatment: " + treatment + "\n");
	
	rw.close();
	   System.out.println("Medical Report Generated! named: patitents"+pId+".txt");
	}
	catch(IOException e){
		e.printStackTrace();	
	}
	 
}
}
