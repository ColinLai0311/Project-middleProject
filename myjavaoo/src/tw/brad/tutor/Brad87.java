package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Brad87 {

	public static void main(String[] args) {
// 1.load driver=>x
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
//2. create connection
		
		try {
			Connection conn= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/iii?user=root&password");
			
//3.sql statement
			Statement stnt=conn.createStatement();
			
//4.execute sql statement	
			int n=stnt.executeUpdate("INSERT INTO cust(id,name,tel,birthdaty)"+"VALUES('brad','123','1999-01-02'),"+"('BRAD02','123','1999-03-11')");
			System.out.println(n);
			
			conn.close();
			System.out.println("ok");
		} catch (SQLException e) {
			System.out.println(e.toString());

		}
		

	}

}
