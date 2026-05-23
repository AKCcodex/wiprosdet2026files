package day12;
import java.io.*;
class Employee implements Serializable {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id +
                           " Name: " + name +
                           " Salary: " + salary);
    }
}
public class employesystem {
	 public static void main(String[] args) throws IOException{

	        try {
	            Employee e1 = new Employee(101, "Ashish", 50000);

	            ObjectOutputStream oos = new ObjectOutputStream(
	                    new FileOutputStream("employee1.sre"));

	            oos.writeObject(e1);  
	            oos.close();

	            System.out.println("Employee Saved!");
	            
	            ObjectInputStream ois = new ObjectInputStream(
	                    new FileInputStream("employee1.sre"));

	            Employee e = (Employee) ois.readObject(); 
	            ois.close();

	            e.display();
	            
	        } 
	        catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
}
