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

import tw.brad.mytest.BCrypt;

public class colin2 {

	public static void main(String[] args) {

		
		try {

			
			Properties prop=new Properties();
			prop.put("user", "root");
			prop.put("password", "");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/iii",prop);
			
			String account="hitomi";
			String passwd="";
			
			PreparedStatement pstmt= conn.prepareStatement("SELECT  count(*) count FROM member2 WHERE account=?");
			pstmt.setString(1, account);
			
//4.execute sql statement	
			ResultSet rs= pstmt.executeQuery();
			rs.next();
			int count= rs.getInt("count");
			System.out.println(count);
			conn.close();
			System.out.println("ok");
		} catch (SQLException e) {
			System.out.println(e.toString());

		}
		

	}

}
