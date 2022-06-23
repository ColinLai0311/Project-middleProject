package tw.brad.tutor;

public class Brad100 {

	public static void main(String[] args) {
		
		
		Dir dir=Dir.RIGHT;
		System.out.println(dir.name());
		System.out.println(dir.getValue());
		System.out.println(dir.toString());

		switch(dir) {
		case UP:System.out.println("UP.....");break;
		case DOWN:System.out.println("DOWN.....");break;
		case LEFT:System.out.println("LEFT.....");break;
		case RIGHT:System.out.println("RIGHT.....");break;
		case STOP:System.out.println("STOP.....");break;

}		
	}

}

//列舉項目寫在第一列
enum Dir{
	UP(1),DOWN(2),LEFT(3),RIGHT(4),STOP(0);
	
	private int value;
	Dir(int a){
		value=a;
	}
	
	
	int getValue(){
		return value;
	}
}
