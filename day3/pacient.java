package day3;

public class pacient {
static class patient{
	public String name;
	private String status;
	
	public patient(String name,String status) {
		this.name=name;
		this.status=status;
	}
	public void info(String role) {
		if(role.equals("doc")) {
			System.out.println("Access granted " + name +" "+ status);
		}
		else {
			System.out.println("Protected info ");
		}
	}
	public void newstatus(String role,String status) {
		if(role.equals("doc")){
				this.status=status;
	}
		else {
			System.out.println("private info can not be accessed");
		}
	
}
}
public static void main(String[] args) {
	String name="ashish";
	String status="alive";
	patient ashish = new patient(name,status);
	ashish.info("doc");
	ashish.newstatus("doc","dead");
	ashish.info("doc");
}
}