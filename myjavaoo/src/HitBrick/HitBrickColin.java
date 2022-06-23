package HitBrick;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HitBrickColin extends JFrame implements KeyListener{
	private JLabel label;
	private final int Max_X=300,Max_Y=500;//X Y 座標最大值
	private boolean xUp,yUp,bouncing;
	private int x,y,xDx,yDy;
	private int Rx,Ry;//板子座標;
	private boolean renew;
	private BallThread greenBallThread;
	private Ball ball;
	private Brick brick[]=new Brick[18];
	
	
	
	public HitBrickColin() {
		super("打磚塊");
		Container pane=getContentPane();//設置空白面板容器
		label=new JLabel("按空白建開始");
		label.setHorizontalAlignment(JLabel.CENTER);//水平
		label.setVerticalAlignment(JLabel.BOTTOM);//垂直
		pane.add(label);
		xUp=true;//橫坐標可移
		yUp=false;//縱座標不可移
		xDx=1;
		yDy=1;
		x=150;
		y=450;//球座標
		Rx=120;
		Ry=460;//板子座標
		renew=true;
		bouncing=false;
		addKeyListener(this);
		brick[0]=new Brick(0, 60, 50, 20);
		brick[1]=new Brick(50, 60, 50, 20);
		brick[2]=new Brick(100, 60, 50, 20);
		brick[3]=new Brick(150, 60, 50, 20);
		brick[4]=new Brick(200, 60, 50, 20);
		brick[5]=new Brick(250, 60, 50, 20);
		brick[6]=new Brick(0, 90, 50, 20);
		brick[7]=new Brick(50, 110, 50, 20);
		brick[8]=new Brick(100, 130, 50, 20);
		brick[9]=new Brick(150, 130, 50, 20);
		brick[10]=new Brick(200, 110, 50, 20);
		brick[11]=new Brick(250, 90, 50, 20);
		brick[12]=new Brick(0, 160, 50, 20);
		brick[13]=new Brick(50, 160, 50, 20);
		brick[14]=new Brick(100, 160, 50, 20);
		brick[15]=new Brick(150, 160, 50, 20);
		brick[16]=new Brick(200, 160, 50, 20);
		brick[17]=new Brick(250, 160, 50, 20);

		
		
		ball=new Ball(150, 450, 10, 10);
		setSize(Max_X, Max_Y);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==e.VK_SPACE) {
			if(renew) {
				greenBallThread=new BallThread(this);
				bouncing=true;
				greenBallThread.start();
				label.setVisible(false);
				
			}
			renew=false;
		}
		if(e.getKeyCode()==e.VK_LEFT) {
			Rx-=20;
			if(bouncing) {
				if(Rx<0) {
					Rx=0;
				}
			}else if(Rx<0) {
				Rx=0;
			}else {
				x=x-20;
				ball.ball_x=x;
			}
		}repaint();
		
		if(e.getKeyCode()==e.VK_RIGHT) {
			Rx+=20;
			if(bouncing) {
				if(Rx+80>300) {
					Rx=220;
				}
			}else {
				if(Rx+80>300) {
					Rx=220;
				}else {
					x=x+20;
					ball.ball_x=x;
				}
			}
		}repaint();
	}
	public void keyReleased(KeyEvent e) {
		
	}
	public void keyTyped(KeyEvent e) {
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		ball.rect.setLocation(x, y);
		if(bouncing) {
			for(int i=0;i<=17;i++) {
				if(brick[i].visible==true) {
					switch(i) {
					case 0:g.setColor(Color.blue);break;
					case 1:g.setColor(Color.cyan);break;
					case 2:g.setColor(Color.gray);break;
					case 3:g.setColor(Color.green);break;
					case 4:g.setColor(Color.BLACK);break;
					case 5:g.setColor(Color.yellow);break;
					case 6:g.setColor(Color.darkGray);break;
					case 7:g.setColor(Color.orange);break;
					case 8:g.setColor(Color.pink);break;
					case 9:g.setColor(Color.red);break;
					case 10:g.setColor(Color.orange);break;
					case 11:g.setColor(Color.red);break;
					case 12:g.setColor(Color.darkGray);break;
					case 13:g.setColor(Color.yellow);break;
					case 14:g.setColor(Color.green);break;
					case 15:g.setColor(Color.pink);break;
					case 16:g.setColor(Color.cyan);break;
					case 17:g.setColor(Color.blue);break;
					
					}
					g.fill3DRect(brick[i].brick_x, brick[i].brick_y, brick[i].brick_width, brick[i].brick_height, true);
				}
			}
				g.setColor(Color.red);
				g.fillOval(x, y, 10, 10);
				g.setColor(Color.blue);
				g.fillRect(Rx, Ry, 80, 20);

			} else {
				for(int i=0;i<=17;i++) {
					switch(i) {
					case 0:g.setColor(Color.blue);break;
					case 1:g.setColor(Color.cyan);break;
					case 2:g.setColor(Color.gray);break;
					case 3:g.setColor(Color.green);break;
					case 4:g.setColor(Color.BLACK);break;
					case 5:g.setColor(Color.yellow);break;
					case 6:g.setColor(Color.darkGray);break;
					case 7:g.setColor(Color.orange);break;
					case 8:g.setColor(Color.pink);break;
					case 9:g.setColor(Color.red);break;
					case 10:g.setColor(Color.orange);break;
					case 11:g.setColor(Color.red);break;
					case 12:g.setColor(Color.darkGray);break;
					case 13:g.setColor(Color.yellow);break;
					case 14:g.setColor(Color.green);break;
					case 15:g.setColor(Color.pink);break;
					case 16:g.setColor(Color.cyan);break;
					case 17:g.setColor(Color.blue);break;
					
					}
					g.fill3DRect(brick[i].brick_x, brick[i].brick_y, brick[i].brick_width, brick[i].brick_height, true);
				}
				g.setColor(Color.red);
				g.fillOval(x, y, 10, 10);
				g.setColor(Color.blue);
				g.fillRect(Rx, Ry, 80, 20);
			}
		}
	public void move() {
		while(true) {
			try {
				Thread.currentThread().sleep(25);
			}catch(Exception e){
				System.out.println(e.toString());
			}
			for(int i=0;i<=17;i++) {
				if(ball.rect.intersects(brick[i].rect)&&brick[i].visible) {
					brick[i].visible=false;
					yUp=!yUp;
				}
			}
			if(x+5>Rx&&x+5<Rx+80&&y+10>=Ry) {
				yUp=false;
				xDx=(int)(Math.random()*5+2);
				yDy=(int)(Math.random()*5+2);
			}
			if(xUp==true) {
				x+=xDx;
			}else {
				x-=xDx;
			}
			if(yUp==true) {
				y+=yDy;
			}else {
				y-=yDy;
			}
			if(y<=0) {
				y=0;
				ball.ball_y=y;
				yUp=true;
				xDx=(int)(Math.random()*5+2);
				yDy=(int)(Math.random()*5+2);
			}else if(y>=Max_Y-15) {
				yDy=(int)(Math.random()*5+2);
				yUp=false;
				break;
			}
			if(x<=0) {
				x=0;
				ball.ball_x=x;
				xUp=true;
				xDx=(int)(Math.random()*5+2);
				yDy=(int)(Math.random()*5+2);
			}else if(x>=Max_X-10) {
				x=Max_X-10;
				ball.ball_x=x;
				xDx=(int)(Math.random()*5+2);
				yDy=(int)(Math.random()*5+2);
				xUp=false;
				
			}
			ball.rect.setLocation(ball.ball_x, ball.ball_y);
			repaint();
			int i;
			for(i=0;i<=17&&brick[i].visible==false;i++) {
				
			}
			if(i==18) {
				break;
			}
		}
		renew=true;
		bouncing=false;
		for(int i=0;i<=17;i++) {
			brick[i].visible=true;
		}
		xUp=true;
		yUp=false;
		xDx=1;
		yDy=1;
		x=150;
		y=450;
		Rx=120;
		Ry=460;
		repaint();
		repaint();
		label.setVisible(true);
	}
	
	
	class BallThread extends Thread{
		private HitBrickColin m;
		BallThread(HitBrickColin a){
			m=a;
		}
		public void run() {
			m.move();
			m.repaint();
		}
	}
	class Brick{
		Rectangle rect=null;
		int brick_x,brick_y;
		int brick_width,brick_height;
		boolean visible;
		public Brick(int x,int y,int w,int h) {
			brick_x=x;
			brick_y=y;
			brick_width=w;
			brick_height=h;
			visible=true;
			rect=new Rectangle(x,y,w,h);
		}
	}
	
	
	class Ball{
		Rectangle rect=null;
		int ball_x,ball_y;
		int ball_width,ball_height;
		public Ball(int x,int y,int w,int h) {
			ball_x=x;
			ball_y=y;
			ball_width=w;
			ball_height=h;
			rect=new Rectangle(x,y,w,h);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		HitBrickColin mar=new HitBrickColin();
	}

}
