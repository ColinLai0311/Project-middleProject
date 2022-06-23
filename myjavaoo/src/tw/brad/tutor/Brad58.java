package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Brad58 {
	public static void main(String[] args) {
		try {
			FileInputStream fin=new FileInputStream("./dir1/file1");
//			int d1=fin.read();
//			System.out.println((char)d1);
//			d1=fin.read();
//			System.out.println((char)d1);
//			d1=fin.read();
//			System.out.println((char)d1);
			int c;
			while((c = fin.read())!= -1){//the next byte of data, or -1 if the end of the file is reached.
				System.out.print((char)c);
			}
		
		
			
			
			fin.close();
			System.out.println("ok");

		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
