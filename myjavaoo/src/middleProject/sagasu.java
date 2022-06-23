package middleProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class sagasu extends JFrame{
	String getFavFruit ,getFavFruit2;
	private JTextArea log,logClear;
	
	public sagasu() {
		String[] optionsToChoose1 = {"台北", "高雄", "新北", "台中","南投","彰化","雲林","嘉義","台南","台東","花蓮","宜蘭","屏東"};
        log=new JTextArea();

     
        getFavFruit2 = (String) JOptionPane.showInputDialog(
                null,
                "選擇地區",
                "Choose Area",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsToChoose1,
                optionsToChoose1[0]);
                gedosagasu();
                System.out.println(log.getText());
               
	}
	public JTextArea getlog() {
		return log;
	}
//	public String getlog() {
//		return log.getText();
//	}
//	
	
	public String log() {
		return log.toString();
	}
	
	public  void gedosagasu() {
		String sql="select*from foods "+" where addr like'"+getFavFruit2+"%' ";
		try {
				Properties prop=new Properties();
				prop.put("user", "root");
				prop.put("password", "root");
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost/iii",prop);
				PreparedStatement pstmt =conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				while (rs.next()) {
				String c1=rs.getString("id");
				String c2=rs.getString("Name");
				String c3=rs.getString("Addr");
				String c4=rs.getString("Tel");
				System.out.println("1:\t"+c1+"\t,2:\t"+c2+"\t,3:\t"+c3+"\t,4:\t"+c4);
					
					log.setText(log.getText()+String.format("%s\t:%s\t:%s\t:%s\t\n",c1,c2,c3,c4) );
					System.out.println(log);
					

//					log.setText(String.format("%s\t:%s\t:%s\t:%s\t\n",c1,c2,c3,c4 ));
//					log.insert(c1,1);
//					log.insert(c2,2);
//					log.insert(c3,3);
//					log.insert(c4,4);
			    
		}
				
				
		}catch(Exception e) {
	System.out.println(e.toString(
			
			));
	
}
	}}		
		
	
	
	
	
	
	
	
	


