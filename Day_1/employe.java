package Day_1;

public class employe {
public static void main(String[] args) {

	int salary=45000;
	

	int bonus=4500;
	

	int tax=14;
	
	int total= (salary+bonus);
	tax= total/tax;
	int net=total-tax;
	
	System.out.print("your net salary is" + net + "." );

}
}
