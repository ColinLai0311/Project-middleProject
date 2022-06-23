package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import tw.brad.mytest.MyClock;
import tw.brad.mytest.MyDrawer;

public class MyPainter extends JFrame {
	private JButton clear,undo,redo,saveJpg,saveObj,loadObj;
	private MyDrawer myDrawer;
	private MyClock myclock;
	
	public MyPainter(){
		super("SIGN");
		setLayout(new BorderLayout());
		JPanel top=new JPanel(new FlowLayout());
		
		myclock=new MyClock();
		clear=new JButton("清除");
		undo=new JButton("上一步");
		redo=new JButton("復原");
		saveJpg=new JButton("存檔");
		saveObj=new JButton("存物件");
		loadObj=new JButton("載物件");
		top.add(myclock);
		top.add(clear);top.add(undo);top.add(redo);top.add(saveJpg);top.add(saveObj);top.add(loadObj);
		
		
		add(top,BorderLayout.NORTH);
		myDrawer=new MyDrawer();
		add(myDrawer,BorderLayout.CENTER);
		
		
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setListener();
	}
	
	
	private void setListener() {
		clear.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		undo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				undo();
			}
		});
		redo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				redo();
			}
		});
		saveJpg.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveJpg();
			}
		});
		saveObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveObj();
			}
		});
		loadObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadObj();
			}
		});
	}
	private void clear() {
		myDrawer.clear();
	}
	private void undo() {
		myDrawer.undo();
	}
	private void redo() {
		myDrawer.redo();
	}
	private void saveJpg() {
		BufferedImage img=new BufferedImage(myDrawer.getWidth(), myDrawer.getHeight(), BufferedImage.TYPE_INT_BGR);
		Graphics g=img.createGraphics();
		myDrawer.paint(g);
		
		try {
			ImageIO.write(img, "jpg", new File("dir1/brad.jpg"));
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	private void saveObj() {
		JFileChooser jfc=new JFileChooser();
	if(	jfc.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) {
		File file=jfc.getSelectedFile();
		try {
			myDrawer.saveObj(file);
			JOptionPane.showMessageDialog(null, "存檔成功");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "存檔失敗");

		}
	}
	}
	private void loadObj() {
		JFileChooser jfc=new JFileChooser();
		if(	jfc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			File file=jfc.getSelectedFile();
			try {
				myDrawer.loadLines(file);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "載入失敗");

			}
		}
	}
	
	
	public static void main(String[] args) {
		new MyPainter();
	}


	

}
