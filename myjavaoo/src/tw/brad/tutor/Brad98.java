package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.brad.mytest.BCrypt;



public class Brad98 {

	public static void main(String[] args) {
		Properties prop=new Properties();
		prop.put("user", "root");prop.put("password","");
		
		
		String sql="select*from member2";
		try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/iii", prop)){
			
			PreparedStatement pstmt=conn.prepareStatement(sql,
					ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=pstmt.executeQuery();
			
			rs.next();
			System.out.println(rs.getString("account"));
			//修改
			rs.updateString("account", "new colin");
			rs.updateString("realname", "賴韋霖2");

			rs.updateRow();
			System.out.println(rs.getString("account"));
			System.out.println("-----------------------------");
			rs.next();rs.next();
			System.out.println(rs.getString("account"));
			rs.deleteRow();
			System.out.println(rs.getString("account"));
			
			
			
			rs.moveToInsertRow();
			rs.updateString("account", "hitomi");
			rs.updateString("passwd", BCrypt.hashpw("123456", BCrypt.gensalt()));
			rs.updateString("realname", "hitomi");
			rs.insertRow();
			System.out.println(rs.getString("account"));


			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
