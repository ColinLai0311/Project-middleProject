package kurasu;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.print.attribute.standard.SheetCollate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import kurasu.lin03.MyModel;
import tw.brad.mytest.MyClock;
import tw.brad.tutor.Brad99;
import tw.brad.mytest.sagasu;
public class lin01  extends JFrame{
	public JButton clock,bg,cc,insertTable,delectTable,sagasu1,sagasu2;
	private lin02 lin02;
	private lin03 lin03;
	private JTextArea log2,logClear;
	private JTable table;

	


	
	public lin01(){
		
		setLayout(new BorderLayout());
		JPanel top=new JPanel(new FlowLayout());
		
		JPanel migi=new JPanel();
		table=new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JScrollPane jsp=new JScrollPane(migi);
	
		
		insertTable=new JButton("新增Table");
		clock=new JButton("輸入資料");
		bg=new JButton("查看資料");
		cc=new JButton("輸入網址");
		delectTable=new JButton("刪除內容");
		sagasu1=new JButton("地區");
		
		
		migi.setBackground(Color.ORANGE);			
		

		
	
		
		top.add(insertTable);top.add(clock);top.add(cc);top.add(bg);top.add(sagasu1);top.add(delectTable);
		
		
		add(top,BorderLayout.NORTH);	
		add(jsp,BorderLayout.CENTER);
	
		
		
	
		
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		clock.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new lin02();
				
			}
		});
		bg.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
			new Brad99();				
			}
		});
		cc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new lin04();
			}
		});
		insertTable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new lin05();
			}
		});
		delectTable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new lin06();
			}
		});
		sagasu1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sagasu sagasu = new sagasu();
						
				JTextArea log2=sagasu.getlog();
				

				migi.add(log2);
				
			
				
			}
		});
		
	
}
	
	

}
