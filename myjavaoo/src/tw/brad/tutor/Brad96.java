package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class Brad96 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/iii",prop)){
			String sql1="update member set money=money-? where id=?";
			String sql2="update member set money=money+? where id=?";
			
			conn.setAutoCommit(false);
			PreparedStatement pstmt1=conn.prepareStatement(sql1);
			pstmt1.setInt(1, 10);
			pstmt1.setInt(2, 2);
			int n1=pstmt1.executeUpdate();
			
			PreparedStatement pstmt2=conn.prepareStatement(sql2);
			pstmt2.setInt(1, 10);
			pstmt2.setInt(2, 1);
		
			int n2=pstmt2.executeUpdate();

			if(n1>0&&n2>0) {
				conn.commit();
				System.out.println("ok");
			}else {
				System.out.println("xx");
			}
			
	}catch(Exception e) {
		System.out.println(e.toString());
	}

}
}