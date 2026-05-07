package day12;
import java.io.*;

class Student implements Serializable{
	int id;
	String name;
	
	Student(int id,String name){
		this.id=id;
		this.name=name;
	}
}

public class serial {
public static void main(String[] args) throws Exception {
	Student s=new Student(1,"Ashish");
	ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("student.ser"));
	oos.writeObject(s);
	oos.close();
	System.out.println("object serialized");
}
}
