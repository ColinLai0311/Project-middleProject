package middleProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.swing.JOptionPane;

public class lin06 {
	public lin06() {
		 String[] optionsToChoose = {"apple", "book","foods", "member", "nina", "ning","yahoo","colin"};

	     String getFavFruit = (String) JOptionPane.showInputDialog(
	             null,
	             "選擇table",
	             "刪除內容",
	             JOptionPane.QUESTION_MESSAGE,
	             null,
	             optionsToChoose,
	             optionsToChoose[0]);
	     String url = "jdbc:mysql://localhost:3306/iii";
	     Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			String sqlDelect = "truncate TABLE "+ getFavFruit ;
			try (Connection conn = DriverManager.getConnection(url, prop)) {
				PreparedStatement stmt = conn.prepareStatement(sqlDelect);
			
				stmt.executeUpdate();
				
				System.out.println("ok");
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			
		}
	public static void main(String[] args) {
		new lin06();
	}
	
	}

