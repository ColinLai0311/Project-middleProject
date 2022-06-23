package tw.brad.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad62 {

	public static void main(String[] args) {//62=61
		long start=System.currentTimeMillis();
		try {
			File source=new File("dir1/kafi.jpg");
			
			FileInputStream fin=new FileInputStream(source);
			byte[] buf=new byte[(int)source.length()];
			fin.read(buf);
			fin.close();
			
			FileOutputStream fout=new FileOutputStream("dir2/kafi123.jpg");
		
			fout.write(buf);
			fout.flush();
			fout.close();
			System.out.println("finish");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		System.out.println(System.currentTimeMillis()-start);
	}

}
