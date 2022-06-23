package tw.brad.tutor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.brad.mytest.Student;

public class Brad951 {

	public static void main(String[] args) {
		Properties prop=new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		String sql="SELECT *FROM member WHERE id=?";
		try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/iii",prop)){
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			
		ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				InputStream in= rs.getBinaryStream("student");
				ObjectInputStream oin=new ObjectInputStream(in);
				Object obj=oin.readObject();
				oin.close();
				
				if(obj instanceof Student) {
					System.out.println("i am");
					Student s1=(Student) obj;
					
					
				}
				
			}else {
				System.out.println("xx");
			}
			
		}catch(Exception e) {
			
		}
	}

}
