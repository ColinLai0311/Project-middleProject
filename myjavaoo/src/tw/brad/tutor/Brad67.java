package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import tw.brad.mytest.Student;

public class Brad67 {
	public static void main(String[] args) {
		try {
			ObjectInput ooin=new ObjectInputStream(new FileInputStream("dir1/student.brad"));
			Object obj= ooin.readObject();
			ooin.close();
			
//			if(obj instanceof String) {//物件是否直系
//				System.out.println("ok");
//			}else {
//				System.out.println("xx");
//			}
			
			Student s1=(Student) obj;
			System.out.println(s1.toString());
			System.out.println(s1.score());
			System.out.println(s1.avg());

			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
