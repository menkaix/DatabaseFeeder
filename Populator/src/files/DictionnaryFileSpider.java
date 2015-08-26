package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import core.database.DataAccess;
import core.threads.FileSpider;
import core.threads.SpiderPool;
import core.threads.SuperSpider;

public class DictionnaryFileSpider extends SuperSpider {
	
	DataAccess dbh = new DataAccess();
	

	public DictionnaryFileSpider(String string) {
		super(string);
		
		
	}

	@Override
	public void eat() {
		
		//System.out.println("Spider["+Thread.activeCount()+"] "+"eating -> "+filePath);
		String sql1 = "insert into Files(path) values(\'"+filePath+"\');";
		dbh.updateRequest(sql1);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String s ;
			do{
				s = reader.readLine();
				if(!s.contains("'")){
					String sql = "insert into words(name) values(\'"+s+"\');";
					dbh.updateRequest(sql);
				}
				
			}while(s!=null);
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e2){
			System.err.println("tried to eat null File : "+filePath);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
	}

	@Override
	public void breed(File f) {
		
		SpiderPool.getInstance().execute(new DictionnaryFileSpider(f.getAbsolutePath())) ;
		
	}

}
