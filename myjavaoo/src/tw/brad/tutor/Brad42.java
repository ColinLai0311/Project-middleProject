package tw.brad.tutor;

public class Brad42 {

	public static void main(String[] args) {
		Brad421 obj1=new Brad421();
		obj1.m1();

	}

}
	class Brad421{
		{
			System.out.println("brad{}");
		}
		Brad421(){
			System.out.println("Brad421");
		}
		void m1() {
			System.out.println("m1()");
		}
}
class Brad422 extends Brad421{
	
}