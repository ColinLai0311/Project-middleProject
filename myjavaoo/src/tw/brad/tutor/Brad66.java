package tw.brad.tutor;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import tw.brad.mytest.Student;

public class Brad66 {
	public static void main(String[] args) {		
		Student s1=new Student("Bra555d", 90, 40, 50);
		System.out.println(s1.toString()+":"+s1.avg());
		try {
			FileOutputStream fout=new FileOutputStream("dir1/student.brad");
			ObjectOutput oout=new ObjectOutputStream(fout);//物件序列化
			oout.writeObject(s1);
			oout.flush();
			oout.close();
			System.out.println("ok");
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
