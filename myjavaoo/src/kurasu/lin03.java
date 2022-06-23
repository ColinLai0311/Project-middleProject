package kurasu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class lin03  extends JPanel{
	private JFrame jframe;
	private JTable table;
	private MyModel mymodel;
	private String[] header= {"編號","名稱","地址","電話"};
	
	public lin03() {
		
		jframe=new JFrame();
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		JPanel jp=new JPanel();
		jframe.getContentPane().add(jp);
//		jframe.getContentPane().add(BorderLayout.CENTER,label);
		jframe.setLayout(new BorderLayout());
		mymodel=new MyModel();
		table=new JTable(mymodel);
		JScrollPane jsp=new JScrollPane(table);//捲軸面板
		jframe.add(jsp,BorderLayout.CENTER);
		
		jframe.setSize(640,480);
		jframe.setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public class MyModel extends DefaultTableModel{
		private ResultSet rs;
		private int rowCount;
		public MyModel() {
			getdata() ;
		}
		public void getdata() {
			Properties prop=new Properties();
			prop.put("user", "root");prop.put("password","root");
			
			
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
