package tw.brad.tutor;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad83 {

	public static void main(String[] args) {
		
			try {
				File source=new File("dir1/ball2.jpg");
				byte[] buf=new byte[(int)source.length()];
				FileInputStream fin=new FileInputStream(source);
				fin.read(buf);
				
				Socket socket=new Socket(InetAddress.getByName("10.0.104.154"),7777);
				
				BufferedOutputStream bo=new BufferedOutputStream(
						socket.getOutputStream());
				bo.write(buf);
				bo.flush();				
				bo.close();
				
				socket.close();
				System.out.println("ok");
			}catch (Exception e) {
				System.out.println(e.toString());
			}
		
		
	}

}
