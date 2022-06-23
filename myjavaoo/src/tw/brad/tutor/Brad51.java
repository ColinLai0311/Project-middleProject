package tw.brad.tutor;

import javax.xml.datatype.DatatypeConfigurationException;

public class Brad51 {

	public static void main(String[] args) {
		//test1();
		test2();

	}
	static void test1() throws DatatypeConfigurationException{
		//throw new RuntimeException();
		throw new DatatypeConfigurationException();
	}
	static void test2() throws  RuntimeException{
		throw new RuntimeException();
	}
}
