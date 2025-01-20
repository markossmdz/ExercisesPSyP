package example2;

//Main class to simulate washing cars
public class WashingCar_Runnable99 {

 public static void main(String[] args) {
     // Loop through 8 cars to wash
     for (int carNumber = 0; carNumber < 8; carNumber++) {
         // Create a CarWashing_Runnable object for each car
         CarWashing_Runnable car = new CarWashing_Runnable("Seat Leon Number: " + carNumber, 5);

         // Create a thread for each car and start it
         Thread thread = new Thread(car);
         thread.start();
     }

     // Print message when all threads have started
     System.out.println("All the cars started their washing");
 }
}

//Class to represent a car washing process
class CarWashing_Runnable implements Runnable {

 private String carModel; // The car model or identifier
 private int washingTime; // Time to wash the car in seconds

 // Constructor to initialize car model and washing time
 public CarWashing_Runnable(String carModel, int washingTime) {
     this.carModel = carModel;
     this.washingTime = washingTime;
 }

 @Override
 public void run() {
     // Print message when washing starts
     System.out.println(carModel + " started washing");
     try {
         // Simulate washing time (convert seconds to milliseconds)
         Thread.sleep(washingTime * 1000L);
     } catch (InterruptedException e) {
         // Handle the interruption during the washing process
         System.out.println(carModel + " The owner ran out of coins");
     }
     // Print message when washing is finished
     System.out.println(carModel + " finished the washing");
 }
}



		