package tw.brad.tutor;

public class Brad52 {

	public static void main(String[] args) {
		int a=10,b=0;
		int c;
		int[] d= {1,2,3,4};
		try {
			

			c=a/b;
			System.out.println(c);
			System.out.println(d[20]);

		}catch(ArithmeticException e1) {
			System.out.println("error");
		}catch(ArrayIndexOutOfBoundsException e2) {
			
		}catch(Exception e3) {
			
		}
		System.out.println("game over");
		
	}
	}


