package tw.brad.mytest;

public class Test03 extends Test02 {//37
	public Test03() {
		//super()
		super(1);
		
		System.out.println("Test03()");
	}
	public Test03(int a){
		this();
	}
	public Test03(double b){
		this(2);
	}
	public Test03(String c){
		this(1.0);
	}
}
