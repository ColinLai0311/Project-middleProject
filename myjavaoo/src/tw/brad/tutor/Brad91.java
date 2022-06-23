package tw.brad.tutor;

import tw.brad.mytest.BCrypt;

public class Brad91 {

	public static void main(String[] args) {
		String pass="123456";
		String hashpw= BCrypt.hashpw(pass, BCrypt.gensalt());
		System.out.println(hashpw);
		if(BCrypt.checkpw("123456", hashpw)) {
			System.out.println("ok");
		}else {
			System.out.println("xx");
		}
	}

}
