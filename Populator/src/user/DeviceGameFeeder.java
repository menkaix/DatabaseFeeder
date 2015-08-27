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
	
	


}
