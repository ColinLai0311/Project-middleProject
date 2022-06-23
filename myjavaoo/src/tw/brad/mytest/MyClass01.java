package tw.brad.mytest;

public class MyClass01 {
	public int var1;
	public String name;
	
	//建構式
	public MyClass01() {
		System.out.println("MyClass()");
		var1=123;
		name="brad";
	}
	public MyClass01(int a) {
		System.out.println("MyClass(int)");
		var1=a;
		name="OK";
		
	}
	//
	
	public void m1() {
		System.out.println("MyClass:m1()");
		
	}
	
	public void m2() {
		System.out.println("MyClass:m2()");
	}
	
	
	
}
