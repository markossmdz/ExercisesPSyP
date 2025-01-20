package example1;

public class MultiThreadCarWashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WashingCar car1 = new WashingCar("Opel Corsa", 1); 
		WashingCar car2 = new WashingCar("Volkswagen Golf", 3); 
		WashingCar car3 = new WashingCar("Citröen C15", 5); 
		
		car1.start();
		car2.start();
		car3.start();
		
		System.out.println("All the cars started their washing");


	}

}
