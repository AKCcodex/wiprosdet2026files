package day11;
import java.io.*;


class Student implements Serializable {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
public class searlization {
	public static void main(String[] args) {
        try {
            Student s1 = new Student(101, "Ashish");

            FileOutputStream fos = new FileOutputStream("student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(s1);
     
            oos.close();
            fos.close();

            System.out.println("Object Serialized Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
