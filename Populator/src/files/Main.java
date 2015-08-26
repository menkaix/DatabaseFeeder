package files;

import core.threads.SpiderPool;


public class Main {

	public static void main(String[] args) {
		
		
		System.out.println("Hello world");
		SpiderPool.getInstance().execute(new DictionnaryFileSpider("dic"));
		SpiderPool.getInstance().start();
		
	}

}
