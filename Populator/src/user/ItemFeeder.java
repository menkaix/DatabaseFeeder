package user;

import de.svenjacobs.loremipsum.LoremIpsum;

public class ItemFeeder  extends SuperFeeder {

	
	@Override
	protected void create() {
		
		String name, description ;
		
		LoremIpsum lorem = new LoremIpsum();
		
		name = SuperFeeder.randomAdjective()+" "+SuperFeeder.randomNown() ;
		description = lorem.getParagraphs(1);
				
		String sql = "insert into items(itemname, description) values('"+name+"','"+description+"')";
		
		dbrecieve.updateRequest(sql);

	}
	
public static void main(String[] args) {
		
		(new ItemFeeder()).feed(100);

	}
	
}
