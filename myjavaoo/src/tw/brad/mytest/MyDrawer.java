package tw.brad.mytest;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;

public class MyDrawer extends JPanel{
	private LinkedList< LinkedList<HashMap<String, Integer>>> lines,recycle;
	
	public MyDrawer() {
		setBackground(Color.ORANGE);
		MyListener myl=new MyListener();
		addMouseListener(myl);
		addMouseMotionListener(myl);
		lines=new LinkedList<>();
		recycle=new LinkedList<>();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;
		
		g2d.setColor(Color.cyan);
		g2d.setStroke(new BasicStroke(6));
		
		for( LinkedList<HashMap<String, Integer>> line:lines) {
			for(int i=1;i<line.size();i++) {
				HashMap<String, Integer>p1=line.get(i-1);//0->1->2
				HashMap<String, Integer>p2=line.get(i);
				g2d.drawLine(p1.get("x"), p1.get("y"),p2.get("x") , p2.get("y"));

			}
		}
		
		
	}
	
	private class MyListener extends MouseAdapter{//內部類別 private存取修飾字
		@Override
		public void mousePressed(MouseEvent e) {
			//System.out.println("press"+e.getX()+"x"+e.getY());
			
			HashMap<String, Integer> point=new HashMap<String, Integer>();//*
			point.put("x", e.getX());point.put("y", e.getY());
			
			LinkedList<HashMap<String, Integer>>line=new LinkedList<>();			
			line.add(point);
			
			lines.add(line);
			repaint();//渲染
			
			recycle.clear();
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			//System.out.println("drag:"+e.getX()+"x"+e.getY());
			HashMap<String, Integer> point=new HashMap<String, Integer>();
			point.put("x", e.getX());point.put("y", e.getY());
			lines.getLast().add(point);
			repaint();//渲染

		}
	}
	
	
	public void clear() {
		lines.clear();
		repaint();
	}
	public void undo() {
		if(lines.size()>0) {
			recycle.add(lines.removeLast()) ;
			repaint();
		}
		
	}
	public void redo() {
		if(recycle.size()>0) {
			lines.add(recycle.removeLast());
			repaint();
		}
		 
	}
	
	public void saveObj(File saveFile)  throws Exception{

		ObjectOutputStream oout=new ObjectOutputStream(new FileOutputStream(saveFile));
		oout.writeObject(lines);
		oout.flush();
		oout.close();
	}
	
	public void loadLines(File loadFile) throws Exception{
		ObjectInputStream oin=new ObjectInputStream(new FileInputStream(loadFile));
		Object obj= oin.readObject();
		oin.close();
		lines=(LinkedList< LinkedList<HashMap<String, Integer>>>)obj;//強制轉型
		repaint();
	}
	
	public void saveV2() {
		
	}
	
	
	
}
