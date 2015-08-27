package user;

public class PlayerMethodFeeder extends SuperFeeder {
	
	@Override
	protected void create() {
		
		String idmethod, idplayer ;
		
		idplayer = ""+randomPlayer() ;
		idmethod =  "" +randomMethod();
		
		
		
		String sql = "insert into playermethod(idplayer,idmethod) values('"+idplayer+"','"+idmethod+"')";
		
		dbrecieve.updateRequest(sql);
		

	}
	
	public static void main(String[] args) {
		
		(new PlayerMethodFeeder()).feed(10000);

	}
	
	


}