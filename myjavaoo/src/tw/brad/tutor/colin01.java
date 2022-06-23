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

public class colin01 {

	public static void main(String[] args) {

		
		try {

			
			Properties prop=new Properties();
			prop.put("user", "root");
			prop.put("password", "");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/iii",prop);
			
			String account="hitomi";
			String passwd="123456";
			String realname="瞳";
			
			PreparedStatement pstmt= conn.prepareStatement("INSERT INTO member2(account,passwd,realname)"+"VALUES(?,?,?)");
			pstmt.setString(1, account);
			pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
			pstmt.setString(3, realname);

			
//4.execute sql statement	
			pstmt.executeUpdate();
			
			
			conn.close();
			System.out.println("ok");
		} catch (SQLException e) {
			System.out.println(e.toString());

		}
		

	}

}
