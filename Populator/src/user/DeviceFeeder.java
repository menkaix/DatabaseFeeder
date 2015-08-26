package user;

import java.util.StringTokenizer;
import java.util.Vector;

public class DeviceFeeder extends SuperFeeder{
	
	@Override
	protected void create() {
		
		String idplateform, iduser,osversion,cpu,gpu,ram,  uid ;
		
		idplateform = ""+SuperFeeder.randomBetween(1, 3);
		iduser = ""+ randomPlayer();
		osversion = SuperFeeder.randomBetween(1,9)+"."+SuperFeeder.randomBetween(1,100);
		cpu = SuperFeeder.randomWords();
		gpu = SuperFeeder.randomWords();
		ram = SuperFeeder.randomBetween(1024, 16384)+"";
		uid = "op"+SuperFeeder.randomBetween(1000000, 9999999);
		
		
		
		String sql = "insert into devices(idplatform, idplayer, osversion, cpu,ram,gpu,uid) values('"+idplateform+"','"+iduser+"','"+osversion+"','"+cpu+"','"+ram+"','"+gpu+"','"+uid+"')";
		
		dbrecieve.updateRequest(sql);
		

	}
	
	public static void main(String[] args) {
		
		(new DeviceFeeder()).feed(20);

	}
	
	private String randomPlayer(){
		String str = dbrecieve.requestString("#;", "players", "1 =1 limit 1000", "idplayer");
		
		StringTokenizer stk = new StringTokenizer(str, ";");
		
		Vector<String> vec = new Vector<String>();
		
		while(stk.hasMoreElements()){
			vec.add(stk.nextToken());
		}
		
		return vec.get(SuperFeeder.randomBetween(1, vec.size()));
		
	}

}
