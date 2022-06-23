package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

public class Brad90 {

	public static void main(String[] args) {

		
		try {
//			Connection conn= DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/iii","root","");
			
			Properties prop=new Properties();
			prop.put("user", "root");
			prop.put("password", "");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/iii",prop);
			
//3.sql statement
//			Statement stnt=conn.createStatement();
			
			PreparedStatement pstmt= conn.prepareStatement("SELECT*FROM foods");

			
//4.execute sql statement	
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String id=rs.getString("id");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				String tel=rs.getString("tel");
				System.out.println(id+":"+name+":"+addr+":"+tel);
						

				
				
			}
			
			conn.close();
			System.out.println("ok");
		} catch (SQLException e) {
			System.out.println(e.toString());

		}
		

	}

}
