package tw.brad.tutor;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad81 {

	public static void main(String[] args) {
		
			try {
				Socket socket=new Socket(InetAddress.getByName("10.0.104.202"),7777);
				
				BufferedOutputStream bo=new BufferedOutputStream(
						socket.getOutputStream());
				bo.write("hello".getBytes());
				bo.close();
				
				socket.close();
				System.out.println("ok");
			}catch (Exception e) {
				System.out.println(e.toString());
			}
		
		
	}

}
