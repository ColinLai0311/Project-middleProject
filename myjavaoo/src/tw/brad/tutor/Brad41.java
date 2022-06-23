package tw.brad.tutor;


import tw.brad.mytest.TWId;

public class Brad41 {

	public static void main(String[] args) {
//		String id="a523456789";
//		System.out.println(id.charAt(0));
//		System.out.println(65<=id.charAt(0));
		
		
		
	
			TWId id1=new TWId();
			System.out.println(id1.getId());
			TWId id2=new TWId(true);
			System.out.println(id2.getId());
			TWId id3=new TWId(2);
			System.out.println(id3.getId());
			TWId id4=new TWId(2,false);
			System.out.println(id4.getId());
			
			TWId id5=new TWId.createTWId("Y120239845");
			TWId id6=new TWId.createTWId("Y120255522");
			System.out.println(id5);
			System.out.println(id6);

			
	}	

}
