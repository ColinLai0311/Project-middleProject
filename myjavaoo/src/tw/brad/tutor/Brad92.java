package tw.brad.tutor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.brad.mytest.BCrypt;
import tw.brad.mytest.Bike;

public class Brad92 {

	public static void main(String[] args) {
		// 2. Create Connection
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/iii", prop);
//			Bike b1 = new Bike();
//			ByteArrayOutputStream bao = new ByteArrayOutputStream();
//			ObjectOutputStream oout = new ObjectOutputStream(bao);
//			oout.writeObject(b1);
//			
//			ObjectInputStream oin = new ObjectInputStream(
//					new ByteArrayInputStream(bao.toByteArray()));
			
//			FileInputStream fin = new FileInputStream("dir1/ball2.png");
			String account = "bbcc";
			String passwd = "123456";
			String realname = "賴韋霖";
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO member2 (account,passwd,realname)"
					+ " VALUES (?,?,?)");
			pstmt.setString(1, account);
			pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
			pstmt.setString(3, realname);
//			pstmt.setBinaryStream(4, fin);
			
			// 4. execute SQL statement
			pstmt.executeUpdate();
			
//			PreparedStatement pstmt2 = conn.prepareStatement(
//					"SELECT * FROM member WHERE id = 9");
//			ResultSet rs = pstmt2.executeQuery();
//			if (rs.next()) {
//				InputStream ii = rs.getBinaryStream("obj");
//				ObjectInputStream tt = new ObjectInputStream(ii);
////				Object obj = tt.readObject();
////				Bike b2 = (Bike)obj;
//			}else {
//				System.out.println("XX");
//			}
			
			conn.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}