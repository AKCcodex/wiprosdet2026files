package day3;

public class vote {
static class voteapp{
	private String name;
	private int age;
	
	public voteapp(String role,String name,int age) {
		if(role.equals("admin")){
				System.out.println("acces granted");
				this.name=name;
				this.age=age;
	}
		else {
			System.out.println("Access denied");
		}}
	public void info(String role) {
		if(role.equals("admin")){
			System.out.println(name);
			if(age>=18) {
				System.out.println("eligible to vote");
				
			}else {
				System.out.println("not eligible to vote");
			}
			
}
	else {
		System.out.println("Access denied");
	}
	}
}
public static void main(String[] args) {
	voteapp vote1=new voteapp("admin","ashish",18);
	vote1.info("admin");
	voteapp vote2=new voteapp("admin","akash",17);
	vote2.info("admin");
}
}
