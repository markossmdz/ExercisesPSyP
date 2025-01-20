package example1;

public class WashingCar extends Thread {
	private String carModel;
	private int washingTime; //seconds

	public WashingCar(String carModel, int washingTime) {
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
		
