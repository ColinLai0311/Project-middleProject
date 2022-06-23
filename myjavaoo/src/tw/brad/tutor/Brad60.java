package tw.brad.tutor;

import java.io.FileOutputStream;

public class Brad60 {

	public static void main(String[] args) {
		String data="資策會\n12315";
		byte[] b=data.getBytes();
		try {
		FileOutputStream fout=new FileOutputStream("dir1/file2");
		fout.write(b);		
		fout.flush();
		fout.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
