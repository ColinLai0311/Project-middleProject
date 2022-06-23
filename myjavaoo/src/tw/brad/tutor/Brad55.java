package tw.brad.tutor;

import java.lang.instrument.IllegalClassFormatException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public class Brad55 {
	public static void main(String[] args)  {

	}

}
class Brad551{
	void m1() throws ExecutionException , GeneralSecurityException{};
}
class Brad552 extends Brad551{
	void m1() throws ExecutionException{};//不能拋出比爸爸大 例外小於等於爸爸 存取修飾字大於等於爸爸
}
class Brad553 extends Brad552{
	void m1()  {};
}