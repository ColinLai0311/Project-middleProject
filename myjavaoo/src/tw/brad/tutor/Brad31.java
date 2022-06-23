package tw.brad.tutor;

import tw.brad.mytest.Bike;

public class Brad31 {

	public static void main(String[] args) {
		Bike myBike=new Bike();
		Bike urBike=new Bike();
		
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
		myBike.upSpeed();
	
			
		
		
		urBike.upSpeed();
		urBike.upSpeed();
		urBike.upSpeed();
		urBike.downSpeed();
		urBike.downSpeed();
		
		System.out.println(myBike.getSpeed());
		System.out.println(urBike.getSpeed());

		
		
		
		
		
	}

}
