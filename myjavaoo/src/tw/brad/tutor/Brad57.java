package tw.brad.tutor;

import java.io.File;

public class Brad57 {

	public static void main(String[] args) {//相對路徑表示法
		File f1=new File("./dir3");// .=> 專案底下的路徑
		if(f1.exists()) {
			System.out.println("ok");
		}System.out.println("XX");
	}

}
