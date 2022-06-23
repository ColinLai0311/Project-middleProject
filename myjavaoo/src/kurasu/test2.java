package kurasu;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import kurasu.lin03.MyModel; 
  
public class test2 extends JFrame{ 
	private JFrame jframe;
	private JTable table;
	private MyModel mymodel;
	private String[] header= {"編號","名稱","地址","電話"};
    
   public test2(){ 
      
    JFrame frame = new JFrame("Frame With Panel"); 
    Container contentPane = frame.getContentPane(); 
    contentPane.setBackground(Color.CYAN); // 将JFrame实例背景设置为蓝绿色 
    JPanel panel = new JPanel(); // 创建一个JPanel的实例 
    MyModel mymodel=new MyModel();
    JTable table=new JTable(mymodel);
    JScrollPane jsp=new JScrollPane(table);
    panel.add(jsp);
    
//    panel.setBackground(Color.yellow); // 将JPanel的实例背景设置为黄色 
//    JButton button = new JButton("Press me"); 
//    panel.add(button); // 将JButton实例添加到JPanel中 
  
    contentPane.add(panel, BorderLayout.CENTER); // 将JPanel实例添加到JFrame的南侧 
    frame.setSize(640, 480); 
    frame.setVisible(true); 
    repaint();
  } 
   public static void main(String[] args) {
	  new test2();
   }
   public class MyModel extends DefaultTableModel{
		private ResultSet rs;
		private int rowCount;
		public MyModel() {
			getdata() ;
		}
		public void getdata() {
			Properties prop=new Properties();
			prop.put("user", "root");prop.put("password","");
			
			
			String sql="select*from foods";
			try (Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/iii", prop)){
				
			PreparedStatement pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
			rs=pstmt.executeQuery();
				
				rowCount=rs.getRow();
				
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			
		}
		
		
		
		@Override
		public int getColumnCount() {
			return 4;
		}
		
		@Override
		public String getColumnName(int column) {
			return header[column];
		}
		@Override
		public int getRowCount() {
			return rowCount;
		}
		
		@Override
		public Object getValueAt(int row, int column) {
			String ret;
			try {
			rs.absolute(row+1);
			ret=rs.getString(column+1);
			}catch(Exception e) {
				ret="xxx";
			}
			return ret;
		}
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}
}