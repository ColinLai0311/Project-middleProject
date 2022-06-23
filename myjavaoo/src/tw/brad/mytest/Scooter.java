package tw.brad.mytest;

public class Scooter extends Bike{
	@Override
	public void upSpeed() {
		speed=speed <1?2:speed*1.7;
	}
}
