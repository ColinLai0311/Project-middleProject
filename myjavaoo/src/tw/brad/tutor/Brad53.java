package tw.brad.tutor;

public class Brad53 {

	public static void main(String[] args) {
		Bird b1=new Bird();
		try {
		b1.setLegv2(2);
		}catch(Exception e) {
			
		}
	}

}

class Bird{
	private int leg;
	void setLeg(int leg) {
		if(leg>=0&&leg<=2) {
			this.leg=leg;
		}
		
	}
	void setLegv2(int leg) throws Exception {
		if(leg>=0&&leg<=2) {
			this.leg=leg;
		}else {
			throw new Exception();
		}
		
	}
}