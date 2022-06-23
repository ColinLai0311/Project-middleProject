package tw.brad.tutor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Brad36 extends JFrame{
	private JTextField x,y;
	private JButton equ;
	private JLabel result;
	
	public Brad36() {
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		x=new JTextField(4);
		y=new JTextField(4);
		JLabel addSign=new JLabel("+");//區域變數
		 equ=new JButton("=");//區域變數
		result=new JLabel();
		
		add(x);add(addSign);add(y);add(equ);add(result);
		
		equ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doAdd();
				
			}
		});
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	private void doAdd() {
		String strX=x.getText();
		String strY=y.getText();
		int intX=Integer.parseInt(strX);
		int intY=Integer.parseInt(strY);
		int intResult=intX+intY;
		result.setText(""+intResult);

	}

	public static void main(String[] args) {
		new Brad36();
		
	}

}
