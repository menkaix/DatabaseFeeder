package user;

import java.util.StringTokenizer;
import java.util.Vector;

public class GameActivator extends SuperFeeder{
	
	private String randomGame(){
		String str = dbrecieve.requestString("#;", "games", "", "idgame");
		
		StringTokenizer stk = new StringTokenizer(str, ";");
		
		Vector<String> vec = new Vector<String>();
		
		while(stk.hasMoreElements()){
			vec.add(stk.nextToken());
		}
		
		return vec.get(SuperFeeder.randomBetween(1, vec.size()-1));
		
	}

	@Override
	protected void create() {
		 String sql = "update games set availability=1 where idgame="+randomGame() +";" ;
		 
		 dbrecieve.updateRequest(sql);
		
	}
	
	public static void main(String[] args) {
		
		(new GameActivator()).feed(500);

	}

}
