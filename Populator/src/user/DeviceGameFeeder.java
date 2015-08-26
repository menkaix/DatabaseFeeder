package user;

import java.util.StringTokenizer;
import java.util.Vector;

public class DeviceGameFeeder extends SuperFeeder {
	
	@Override
	protected void create() {
		
		String iddevice, idgame ;
		
		iddevice = ""+randomDevice();
		idgame =  ""+randomGame();
		
		
		
		String sql = "insert into devicegame(idgame,iddevice) values('"+idgame+"','"+iddevice+"')";
		
		dbrecieve.updateRequest(sql);
		

	}
	
	public static void main(String[] args) {
		
		(new DeviceGameFeeder()).feed(100);

	}
	
	private String randomDevice(){
		String str = dbrecieve.requestString("#;", "devices", "", "iddevice");
		
		StringTokenizer stk = new StringTokenizer(str, ";");
		
		Vector<String> vec = new Vector<String>();
		
		while(stk.hasMoreElements()){
			vec.add(stk.nextToken());
		}
		
		return vec.get(SuperFeeder.randomBetween(1, vec.size()-1));
		
	}
	private String randomGame(){
		String str = dbrecieve.requestString("#;", "games", "1 =1 limit 1000", "idgame");
		
		StringTokenizer stk = new StringTokenizer(str, ";");
		
		Vector<String> vec = new Vector<String>();
		
		while(stk.hasMoreElements()){
			vec.add(stk.nextToken());
		}
		
		return vec.get(SuperFeeder.randomBetween(1, vec.size()-1));
		
	}


}
