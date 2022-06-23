package tw.brad.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class Brad94 {

	public static void main(String[] args) {
		Properties prop=new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		String sql="UPDATE member SET icon=?where id=?";
		
		
		try (Connection conn=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/iii",prop)) {
			PreparedStatement tstmt=conn.prepareStatement(sql);
			
			
			File file=new File("dir1/ball2.png");
			if(file.length()<=60*1000) {
				tstmt.setBlob(1, new FileInputStream(file));
				tstmt.setInt(2, 1);
				int n=tstmt.executeUpdate();
				if(n>0) {
					System.out.println("ok");
				}else {
					System.out.println("xx");
				}
			}else{
				System.out.println("file too big");
			}
		}catch(Exception e) {
			
		}

	}

}
