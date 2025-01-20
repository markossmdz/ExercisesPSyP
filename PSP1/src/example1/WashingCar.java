package example1;

public class WashingCar extends Thread {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarWashing car1 = new CarWashing("Opel Corsa", 1); 
		CarWashing car2 = new CarWashing("Volkswagen Golf", 3); 
		CarWashing car3 = new CarWashing("Citröen C15", 5); 
		
		car1.start();
		car2.start();
		car3.start();
		
		System.out.println("All the cars started their washing");
	}
	
	
}

class CarWashing extends Thread {
	private String carModel;
	private int washingTime; //seconds

	public CarWashing(String carModel, int washingTime) {
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

		
