package user;

import de.svenjacobs.loremipsum.LoremIpsum;

public class GameFeeder extends SuperFeeder {

	@Override
	protected void create() {
		
		String name, description ;
		
		LoremIpsum lorem = new LoremIpsum();
		
		name = SuperFeeder.randomAdjective()+" "+SuperFeeder.randomNown() ;
		description = lorem.getParagraphs(1);
				
		String sql = "insert into games(name, description) values('"+name+"','"+description+"')";
		
		dbrecieve.updateRequest(sql);

	}
	
public static void main(String[] args) {
		
		(new GameFeeder()).feed(845);

	}

}
