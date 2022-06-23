package tw.brad.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Brad78 {

	public static void main(String[] args) {
		byte[] buf="٩(๑òωó๑)۶(✿╹◡╹)(๑•́ ₃ •̀๑)/•ू(ᵒ̴̶̷ωᵒ̴̶̷*•ू(｡◕‿◕｡✿)".getBytes();
		try {
			DatagramSocket socket=new DatagramSocket();
			DatagramPacket packet=new DatagramPacket(buf,buf.length,InetAddress.getByName("10.0.104.202"),8888);
			socket.send(packet);
			socket.close();
			System.out.println("send ok");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
