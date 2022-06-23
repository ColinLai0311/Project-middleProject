package middleProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.swing.JOptionPane;

public class lin05 {
	 public lin05() {
			String getText = JOptionPane.showInputDialog("新增table");
			String column1 = JOptionPane.showInputDialog("新增欄位1");
			String column2 = JOptionPane.showInputDialog("新增欄位2");
			String column3 = JOptionPane.showInputDialog("新增欄位3");


			String url = "jdbc:mysql://localhost:3306/iii";
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			String sql="create table "+getText+"( id INT AUTO_INCREMENT primary key NOT NULL, "
					
					+     column1+ " char(100),"
					+     column2+ " char(100),"
					+     column3+ " char(100)"
					+")";
			try(Connection conn=DriverManager.getConnection(url,prop)){
				PreparedStatement pre=conn.prepareStatement(sql);
				pre.executeUpdate();
				pre.close();
				System.out.println("ok");
			}catch(Exception e) {
				System.out.println(e.toString());
			}
	 }	 
		
}

