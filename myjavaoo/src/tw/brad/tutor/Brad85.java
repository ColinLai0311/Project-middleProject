package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Brad85 {

	public static void main(String[] args) {
		String target="https://linux.vbird.org/";
		try {
			
			URL url=new URL("https://pdfmyurl.com/?url="+target);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			
			FileOutputStream fout=new FileOutputStream("dir1/ppp.pdf");
			
			BufferedInputStream bin=
					new BufferedInputStream(conn.getInputStream());
			byte[] b=new byte[4096]; int len;
			while((len=bin.read(b))!=-1) {
				fout.write(b,0,len);
			}
			
			bin.close();	
			fout.flush();
			fout.close();
			
			
			conn.disconnect();
			
		}catch(Exception e) {
			
		}
	}

}
