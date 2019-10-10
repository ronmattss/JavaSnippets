package school;

public class UseVehicle {

	public static void main(String[] args) {
		
		Vehicle motor = new Motorcycle(2,30);
		Car limo  = new Car(4,60);
		
		
		System.out.println(motor.toString());
		System.out.println(limo.toString());

	}

}
