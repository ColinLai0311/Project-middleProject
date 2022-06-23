package tw.brad.tutor;

public class Brad39 {

	public static void main(String[] args) {
		System.out.println("hello, world".charAt(4));
		String s1="brad";
		String s2="brad";
		String s3=new String("brad");
		String s4=new String("brad");
		System.out.println(s1==s2);
		System.out.println(s1==s3);// x
		System.out.println(s1.equals(s3));//v
		System.out.println("-----------------");
		
		Object obj1=new Object();
		Object obj2=new Object();
		Object obj3=obj2;
		System.out.println(obj1.equals(obj2));
		System.out.println(obj2.equals(obj3));
		System.out.println("-----------------");

		String s5=s1.concat("chao");
		System.out.println(s1);
		System.out.println(s5);
		String s6="0123456789";
		System.out.println(s6.substring(1, 7));

		
	}

}
