package tw.brad.tutor;

import tw.brad.mytest.Bike;
import tw.brad.mytest.Scooter;

public class Brad33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bike bike =new Bike();
		Scooter scooter=new Scooter();
		bike.upSpeed();bike.upSpeed();
		scooter.upSpeed();scooter.upSpeed();
		
		System.out.println(bike.getSpeed());
		System.out.println(scooter.getSpeed());

		
	}

}
