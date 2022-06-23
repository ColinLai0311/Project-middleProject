package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Brad65 {

	public static void main(String[] args) {
		try {
//			FileInputStream fin=new FileInputStream("dir1/masuku.csv");
//			FileReader reader=new FileReader("dir1/masuku.csv"); 1
//			InputStreamReader ir=new InputStreamReader(fin,StandardCharsets.UTF_8);
//			BufferedReader br=new BufferedReader(ir);2
			
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("dir1/masuku.csv")));
			
			String line;
			while((line=br.readLine())!=null) {
				String[] data=line.split(",");
				System.out.println("\t>>"+data[1]+"\t成人:"+data[4]+"\t小孩:"+data[5]);
			}
			br.close();
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
