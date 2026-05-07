package day4;

public class healthapp {
static class Patient{
	private String id;
	private String name;
	private int age;
	private String illness;
	
	public Patient(String id, String name, int age , String illness) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.illness=illness;
	}
	public String getid() 
	{ return id; }
    public String getname() 
    { return name; }
    public String getillness() 
    { return illness; }
    public String getinfo() {
        return "ID: " + id + " | Name: " + name + " | Illness: " + illness +" | age: " + age;
    }
}
static interface PatientService{
	void registedPatient(Patient patient);
	void showPatientDetails(String id);
}
static class PatientServiceImpl implements PatientService{
	private Patient[] patients=new Patient[10];
	private int patientCount=0;
	
	public void registedPatient(Patient patient) {
		if(patientCount<patients.length) {
			patients[patientCount]=patient;
			patientCount++;
			System.out.println("succes patient created" + patient.getname());
		}
		else {
			System.out.println("Hospital is fill!");
		}
	}
	public void showPatientDetails(String id) {
		for(int i=0;i<patientCount;i++) {
			if(patients[i].getid().equals(id)) {
				System.out.println("Patients is their" + patients[i].getinfo());
				return;
			}
			
		}
		
		      System.out.println("Patient with ID " + id + " not found.");
	}
}
static abstract class Doctor{
	String name;
	String special;
	
	abstract void diagnose(Patient patient);
}
static class genralphysician extends Doctor{
	genralphysician(String docname){
		name=docname;
		special="genral medicine";
	}
	void diagnose(Patient patient) {
		System.out.println("Dr. " + name + " is performing on" + patient.getname());
	}
	
}
static class Cardiologist extends Doctor {   
    Cardiologist(String docName) {
        name = docName;
        special = "Cardiology";
    }

    void diagnose(Patient patient) {
        System.out.println("Dr. " + name + " is checking " + patient.getname() + "'s heart rate.");
    }
}
public static void main(String[] args) {


    Patient p1 = new Patient("1", "ashish", 40, "Flu");
    Patient p2 = new Patient("2", "akash", 35, "Heart Pain");
	PatientServiceImpl service = new PatientServiceImpl();
    service.registedPatient(p1);
    service.registedPatient(p2);
    Doctor doc1 = new genralphysician("aryan");
    Doctor doc2 = new Cardiologist("abhi");
    service.showPatientDetails("2");
    doc1.diagnose(p1);
    doc2.diagnose(p2);
}
}
