package tw.brad.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Brad79 {

	public static void main(String[] args) {
		byte[] buf=new byte[4096];
		
		try {
			DatagramSocket socket=new DatagramSocket(8888);
			DatagramPacket packet=new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			socket.close();
			System.out.println("receive ok");
			
			String who=packet.getAddress().getHostAddress();
			byte[] rec=packet.getData();
			int len=packet.getLength();
			System.out.println(who+":"+new String(rec,0,len));
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
