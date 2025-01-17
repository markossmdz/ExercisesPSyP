package example2;

public class MultiThreadCarWashing_Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			WashingCar_Runnable car1 = new WashingCar_Runnable("Opel Corsa", 1); 
			WashingCar_Runnable car2 = new WashingCar_Runnable("Volkswagen Golf", 3); 
			WashingCar_Runnable car3 = new WashingCar_Runnable("Citröen C15", 5); 
			
			Thread thread1 = new Thread(car1);
			Thread thread2 = new Thread(car2);
			Thread thread3 = new Thread(car3);
			
			thread1.start();
			thread2.start();
			thread3.start();
			
			System.out.println("All the cars started their washing");

	}

}
