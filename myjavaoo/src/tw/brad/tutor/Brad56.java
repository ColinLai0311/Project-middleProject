package tw.brad.tutor;

import java.io.File;
import java.io.IOException;

public class Brad56 {

	public static void main(String[] args) {//在static不能呼叫類別中的屬性
		File f1=new File("d:\\brad\\test3");
		if(f1.exists()){//在不在
			System.out.println("ok");
		}else {
//			try {
//			f1.createNewFile();
//			}catch(IOException e) {
//				System.out.println(e.toString());
//			}
			f1.mkdir();
			System.out.println("xx");

		}
	}

}
