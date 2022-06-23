package tw.brad.tutor;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Brad101 {
	public static SimpleDateFormat f1=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static SimpleDateFormat f2=new SimpleDateFormat("MMM dd yyyy HH:mm:ss");

	public static void main(String[] args) {
		Date today=new Date();
		String df1=f1.format(today);
		System.out.println(df1);
		String df2=f2.format(today);
		System.out.println(df2);

		
		LocalDate now=LocalDate.now();
		System.out.println(now);
		LocalDate birthday=LocalDate.of(1999, 3, 11);
		System.out.println(birthday.getDayOfMonth());
		System.out.println(birthday.isLeapYear());
		System.out.println(birthday.isBefore(now));
		LocalDate plus3d= birthday.plusMonths(3);
		System.out.println(plus3d);
		System.out.println(now.getYear()-birthday.getYear());
		LocalDate fr= now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		System.out.println(fr);

		LocalDate an=LocalDate.of(1999, 3, 11);
		Period p=Period.between(an, now);
		System.out.println(p.getYears()+"年"+ p.getMonths()+"月"+p.getDays()+"天");
		
		long days=ChronoUnit.DAYS.between(birthday, now);
		System.out.println(days+"days");
	}

}
