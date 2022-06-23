package tw.brad.tutor;

import java.util.HashSet;
import java.util.TreeSet;

public class Brad69 {
	public static void main(String[] args) {
		TreeSet<Integer> lottery=new TreeSet<>();//排序
		while(lottery.size()<6) {
			lottery.add((int)(Math.random()*49+1));

		}
		System.out.println(lottery);
		System.out.println("----------");
		for(Integer obj:lottery) {
			System.out.print(obj+" ");
		}
		System.out.println("----------");
		
	}

}
