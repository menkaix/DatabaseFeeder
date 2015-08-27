package user;

import java.util.StringTokenizer;
import java.util.Vector;

public class GameActivator extends SuperFeeder{
	
	

	@Override
	protected void create() {
		 String sql = "update games set availability=1 where idgame="+randomGame() +";" ;
		 
		 dbrecieve.updateRequest(sql);
		
	}
	
	public static void main(String[] args) {
		
		(new GameActivator()).feed(500);

	}

}
