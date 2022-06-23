package kurasu;



import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class test1 extends JFrame{
public static final String DRIVER = "com.mysql.jdbc.Driver"; 
public static final String URL = "jdbc:mysql://localhost/iii";   
public static final String USERNAME = "root";  
public static final String PASSWORD = "";
		public test1() throws SQLException, ClassNotFoundException {
			
			
			
			
			
					 String[] optionsToChoose = {"cust", "foods", "member", "member2", "pp"};
				
				     String  getFavFruit = (String) JOptionPane.showInputDialog(
				               null,
				               "What fruit do you like the most?",
				               "Choose Fruit",
				               JOptionPane.QUESTION_MESSAGE,
				               null,
				               optionsToChoose,
				               optionsToChoose[0]);
					
					
				Connection conn = null; //每一個Connection物件表示一個數據庫連線物件
				Statement stat = null;
				Class.forName(DRIVER);//載入驅動程式
				conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
				stat = conn.createStatement();//找到藉口
				String sql = "select*from "+getFavFruit;//查詢語句
				ResultSet rs=stat.executeQuery(sql);//查詢
				//將查詢出的結果輸出
		while (rs.next()) {
				//String deptno=rs.getString("deptno");
				//String dname=rs.getString("dname");
				//String loc=rs.getString("loc");
				//
				//下列三行語句與上面三行語句作用相同，僅需一個就行
				
				String c1=rs.getString(1);
				String c2=rs.getString(2);
				String c3=rs.getString(3);
				String c4=rs.getString(4);

				System.out.println("1:\t"+c1+"\t,2:\t"+c2+"\t,3:\t"+c3+"\t,4:\t"+c4);
				}
				rs.close();
				stat.close();
				conn.close();
				}
 public static void main(String[] args) {
	 try {
		new  test1();
	} catch (Exception e) {
		System.out.println(e.toString());
	} 
 }
}
