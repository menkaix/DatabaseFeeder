package user;

import core.database.DataAccess;


public abstract class SuperFeeder {
	
	static DataAccess dbrecieve = new DataAccess("172.28.60.72", "root", "123456", "operatordb");
	static DataAccess dbsource = new DataAccess("172.28.60.74", "root", "mendrika", "testBig");
	
	protected abstract void create();
	
	public void feed(int num){
				
		System.out.println("Hello world"); 
		
		
		
		for(int i= 0 ; i<num ; i++){
			create();
		}
		
	}
	
	
	
	public static String randomWords(){
		int loginID = (int)(Math.random() * 600000 + 1);
		String word = dbsource.requestString("#", "words", "id="+loginID, "name") ;
		
		return word ;
		
	}
	
	public static String randomAdjective(){
		int adjID = (int)(Math.random() * 75000 + 1);
		String word = dbsource.requestString("#", "adjectives", "idadjectives="+adjID, "value") ;
		
		return word ;
		
	}
	
	public static String randomNown(){
		int adjID = (int)(Math.random() * 32900 + 1);
		String word = dbsource.requestString("#", "nowns", "idnowns="+adjID, "value") ;
		
		return word ;
		
	}
	
	public static int randomBetween(int a, int b){
		return (int)(Math.random() * b + a);		
	}
	
	
	

}
