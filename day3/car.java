package day3;

public class car {
static class carc{
	public boolean engine_status;
	public int speed;
	public int fuelLevel;
	
	public carc(int fuelLevel) {
		this.fuelLevel=fuelLevel;
		this.engine_status=false;
		this.speed=0;
	}
	public void startEngine() {
		if(fuelLevel>0) {
			engine_status=true;
			System.out.println("car on"+ engine_status);
		}else {
			System.out.println("fuel is not saficienct");
		}
	}
	public void speed() {
		speed=100;
	}
	public void stop() {
		speed=0;
		
	}
	public void status() {
		System.out.println("on status" + engine_status+"fuel level is" + fuelLevel + 
				"speed is" + speed );
	}
}
public static void main(String[] args) {
	carc auto=new carc(123);
	auto.startEngine();
	auto.speed();
	auto.status();	
	auto.stop();
	auto.status();
}


}
