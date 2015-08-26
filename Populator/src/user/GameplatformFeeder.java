package user;

public class GameplatformFeeder  extends SuperFeeder {
	
	@Override
	protected void create() {
		
		String idplateform, idgame ;
		
		idplateform = ""+SuperFeeder.randomBetween(1, 3);
		idgame =  ""+SuperFeeder.randomBetween(859, 1703);
		
		
		
		String sql = "insert into gameplatform(idplatform, idgame) values('"+idplateform+"','"+idgame+"')";
		
		dbrecieve.updateRequest(sql);
		

	}
	
	public static void main(String[] args) {
		
		(new GameplatformFeeder()).feed(1000);

	}

}
