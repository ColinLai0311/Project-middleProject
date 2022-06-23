package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Brad89 {

	public static void main(String[] args) {

		
		try {
//			Connection conn= DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/iii","root","");
			
			Properties prop=new Properties();
			prop.put("user", "root");
			prop.put("passeord", "");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/iii",prop);
			
//3.sql statement
//			Statement stnt=conn.createStatement();
			
			PreparedStatement pstmt= conn.prepareStatement("UPDATE foods SET name=?,tel=? where id=?");
			pstmt.setString(1, "小坑");
			pstmt.setString(2, "321");
			pstmt.setInt(3, 133);
			
//			PreparedStatement pstmt= conn.prepareStatement("DELETE FROM foods where id=?");
//			pstmt.setInt(1, 133);
			//
			
//4.execute sql statement	
			pstmt.executeUpdate();
			
			conn.close();
			System.out.println("ok");
		} catch (SQLException e) {
			System.out.println(e.toString());

		}
		

	}

}
