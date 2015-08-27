package user;

import java.util.StringTokenizer;
import java.util.Vector;

import tools.development.Logger;
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
		
		String word = null ;
		
		int i =0 ;
		
		do{
			
			int loginID = (int)(Math.random() * 600000 + 1);
			
			word = dbsource.requestString("#", "words", "id="+loginID, "name") ;
			
		}while((word.trim().length()<=0)) ;
		
		return word ;
		
	}
	
	public static int randomBetween(int a, int b){
		return (int)(Math.random() * b + a);		
	}

	public static String randomAdjective(){
		
		String word = null  ;
		
		do{
			int adjID = (int)(Math.random() * 75000 + 1);
			word = dbsource.requestString("#", "adjectives", "idadjectives="+adjID, "value") ;
		}while(!(word.trim().length()>0)) ;
		
		return word ;
		
	}
	
	public static String randomNown(){
		
		String word = null ;
		
		do{
			int adjID = (int)(Math.random() * 32900 + 1);
			word = dbsource.requestString("#", "nowns", "idnowns="+adjID, "value") ;
		}while(!(word.trim().length()>0)) ;
		
		return word ;
		
	}
	
	public static String randomPlayer(){
		String str = dbrecieve.requestString("#;", "players", "", "idplayer");
		
		StringTokenizer stk = new StringTokenizer(str, ";");
		
		Vector<String> vec = new Vector<String>();
		
		while(stk.hasMoreElements()){
			vec.add(stk.nextToken());
		}
		
		return vec.get(SuperFeeder.randomBetween(1, vec.size()-1));
		
	}
	
	public static String randomDevice(){
		String str = dbrecieve.requestString("#;", "devices", "", "iddevice");
		
		StringTokenizer stk = new StringTokenizer(str, ";");
		
		Vector<String> vec = new Vector<String>();
		
		while(stk.hasMoreElements()){
			vec.add(stk.nextToken());
		}
		
		return vec.get(SuperFeeder.randomBetween(1, vec.size()-1));
		
	}
	public static String randomGame(){
		String str = dbrecieve.requestString("#;", "games", "", "idgame");
		
		StringTokenizer stk = new StringTokenizer(str, ";");
		
		Vector<String> vec = new Vector<String>();
		
		while(stk.hasMoreElements()){
			vec.add(stk.nextToken());
		}
		
		return vec.get(SuperFeeder.randomBetween(1, vec.size()-1));
		
	}
	
	public static String randomMethod(){
		String str = dbrecieve.requestString("#;", "paiementmethod", "", "idpaiementmethod");
		
		StringTokenizer stk = new StringTokenizer(str, ";");
		
		Vector<String> vec = new Vector<String>();
		
		while(stk.hasMoreElements()){
			vec.add(stk.nextToken());
		}
		
		return vec.get(SuperFeeder.randomBetween(1, vec.size()-1));
		
	}
	

}
