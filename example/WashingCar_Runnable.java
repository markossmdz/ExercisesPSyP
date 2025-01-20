package example2;

public class WashingCar_Runnable {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarWashing_Runnable car1 = new CarWashing_Runnable("Opel Corsa", 1); 
		CarWashing_Runnable car2 = new CarWashing_Runnable("Volkswagen Polo", 3); 
		CarWashing_Runnable car3 = new CarWashing_Runnable("Citröen C15", 5); 
			
		Thread thread1 = new Thread(car1);
		Thread thread2 = new Thread(car2);
		Thread thread3 = new Thread(car3);
			
		thread1.start();
		thread2.start();
		thread3.start();
			
		System.out.println("All the cars started their washing");
	}
	
	
}

class CarWashing_Runnable implements Runnable {
	private String carModel;
	private int washingTime; //seconds

	public CarWashing_Runnable(String carModel, int washingTime) {
		// TODO Auto-generated constructor stub
		this.carModel = carModel;
		this.washingTime = washingTime;
	}
	
	@Override
	public void run() {
		System.out.println(carModel + " started its washing");
		try {
			Thread.sleep(washingTime * 1000L);
		}catch(InterruptedException e){
			System.out.println(carModel + " The owner ran out of coins");
		}
		System.out.println(carModel + " finished the washing");
	}
	
}
		