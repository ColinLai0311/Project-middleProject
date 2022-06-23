package middleProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class lin02 {
	private static  String getFavFruit;
	static  String sqlCheckRepeat ;
	static String sqlAppend ;
	static PreparedStatement stmtAppend, stmtCheckRepeat;
	
	public lin02() {
		 String[] optionsToChoose = {"apple", "foods", "member", "book", "yahoo","ning","nina","colin","pig"};

	        getFavFruit = (String) JOptionPane.showInputDialog(
	                null,
	                "選擇table",
	                "Choose Table",
	                JOptionPane.QUESTION_MESSAGE,
	                null,
	                optionsToChoose,
	                optionsToChoose[0]);
	        	
		String account = JOptionPane.showInputDialog("Account");
		String passwd = JOptionPane.showInputDialog("Password");
		String realname = JOptionPane.showInputDialog("Realname");
		
		String url = "jdbc:mysql://localhost:3306/iii";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		sqlAppend = "INSERT INTO "+ getFavFruit +"(account,passwd,realname) VALUES (?,?,?)";
		sqlCheckRepeat = "SELECT count(*) as nums FROM "+getFavFruit+" WHERE account = ?";
		try (Connection conn = DriverManager.getConnection(url, prop)) {
			stmtCheckRepeat = conn.prepareStatement(sqlCheckRepeat);
			stmtAppend = conn.prepareStatement(sqlAppend);
			
			if (!isDataRepeat(account)) {
				if (appendData(account, passwd, realname)) {
					
					
					JOptionPane.showMessageDialog(null, "資料新增成功");
				}else {
					JOptionPane.showMessageDialog(null, "資料新增錯誤");
				}
			}else {
				JOptionPane.showMessageDialog(null, "資料重複錯誤");
			}
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}
	static boolean isDataRepeat(String account) throws SQLException {
		stmtCheckRepeat.setString(1, account);
		ResultSet rs = stmtCheckRepeat.executeQuery();
		rs.next();
		return rs.getInt("nums") != 0;
	}
	
	static boolean appendData(String account, String passwd, String realname) throws SQLException {
		stmtAppend.setString(1, account);
		stmtAppend.setString(2, passwd);
		stmtAppend.setString(3, realname);
		int rowCount = stmtAppend.executeUpdate();
		return rowCount != 0;
	}
	public static void main(String[] args) {
		new lin02();
	}
	
	}
