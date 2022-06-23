package tw.brad.mytest;

import java.io.Serializable;

public class Bike  implements Serializable{
	 protected double speed;//屬性
	 public void upSpeed() {
		 speed =speed<1 ? 1:speed*1.2;
	 }
	 public void downSpeed() {
		 speed=speed<1 ? 0:speed*0.7;
	 }
	 public double getSpeed() {
		 return speed;
	 }
	 
	 
	 
}
