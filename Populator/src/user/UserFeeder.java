package user;

public class UserFeeder extends SuperFeeder {

	@Override
	protected void create() {
		
		String login, pass, name, email ;
		
		login = SuperFeeder.randomWords() ;
		pass = SuperFeeder.randomWords() ;
		name = SuperFeeder.randomWords() ; 
		email = SuperFeeder.randomWords()+"@"+ SuperFeeder.randomWords()+".com";
		
		String sql = "insert into players(username, PASS, NAME, EMAIL) values('"+login+"','"+pass+"','"+name+"','"+email+"')";
		
		dbrecieve.updateRequest(sql);
		

	}

	public static void main(String[] args) {
		
		(new UserFeeder()).feed(1000);

	}

}
