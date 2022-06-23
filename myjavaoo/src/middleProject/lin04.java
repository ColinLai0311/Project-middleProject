package middleProject;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.cj.util.Util;

public class lin04  {
	private JFrame jframe;
	private JTextField jf;
	private String message;
	public static PreparedStatement pstmt;
	
	public lin04() {
		
		jframe=new JFrame();
		jframe.setLayout(new BorderLayout());
		jf=new HintTextField("網址");
		jframe.add(jf,BorderLayout.CENTER);
		JButton getText=new JButton("輸入連結");
		
		getText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 message = String.format("jf='%s'",
			            jf.getText());
				 JOptionPane.showMessageDialog(jframe, message);
				 	gedo();
			}
		});
		
		
		
		jframe.add(getText, BorderLayout.SOUTH);
//		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.setVisible(true);		
	    jframe.pack();

		
		
	}
		
	public void gedo() {
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/iii", prop);
			
			// 3. SQL statement
			pstmt = conn.prepareStatement(
					"INSERT INTO foods (name,addr,tel) " +
					"VALUES (?,?,?)");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		// 1. 抓 json 回來
		fetchJSON();
		// 2. parse json
		// 3. insert into
		System.out.println("OK");
	}
	
	private  void fetchJSON() {
		message = String.format(jf.getText());
		try {
			URL url=new URL(message);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			
			BufferedReader reader=new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line; StringBuffer sb=new StringBuffer();
			while ( (line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			conn.disconnect();
			parseJSON(sb.toString());
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	private static void parseJSON(String json) {
		try {
			JSONArray root = new JSONArray(json);
			for (int i=0; i<root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				String name = row.getString("Name");
				String addr = row.getString("Address");
				String tel = row.getString("Tel");
				
				insertData(name, addr, tel);
				
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	private static void insertData(String name, String addr, String tel) {
		try {
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setString(3, tel);
			
			// 4. execute SQL statement
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	

}

class HintTextField extends JTextField implements FocusListener{
	private final String hint;
	  private boolean showingHint;
	public HintTextField(final String hint) {
		 super(hint);
		    this.hint = hint;
		    this.showingHint = true;
		    super.addFocusListener(this);
	}
	@Override
	public void focusGained(FocusEvent e) {
		 if(this.getText().isEmpty()) {
		      super.setText("");
		      showingHint = false;
		 }
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		 if(this.getText().isEmpty()) {
		      super.setText(hint);
		      showingHint = true;		
	}
}

	  @Override
	  public String getText() {
	    return showingHint ? "" : super.getText();
	    
	  }
}
