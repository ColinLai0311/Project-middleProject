package tw.brad.mytest;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class MyClock extends JLabel{
	private Timer timer;
	public MyClock() {
		timer=new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				Calendar now=Calendar.getInstance();
				int hh=now.get(Calendar.HOUR_OF_DAY);
				int mm=now.get(Calendar.MINUTE);
				int ss=now.get(Calendar.SECOND);

				
				setText(String.format("%02d:%02d:%02d", hh,mm,ss));

			}
		}, 0,1*1000);//每隔一秒更新一次
		
	}
	//內部類別方便存取外部類別屬性
	private class MyTask extends TimerTask{
		@Override
		public void run() {
			
		}
	}
	
	
	
}
