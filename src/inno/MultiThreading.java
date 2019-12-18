package inno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

public class MultiThreading implements Runnable{
	private Item item;
	private String itemName;
	
	public MultiThreading(Item item, String itemName) {
		this.item = item;
		this.itemName = itemName;
	}
	
	//Integer.parseInt(item.getState()) < 5
	
	public void run() {
	    while(true) {
	    	BufferedReader bufferedReader;
			String inputLine;
	    	try {
	        	item.setConnection(item.initURLConnection(itemName, "GET", true));
    			
    			bufferedReader = new BufferedReader(
    					  new InputStreamReader(item.getConnection().getInputStream()));
    			final StringBuffer content = new StringBuffer();
    			
    			while ((inputLine = bufferedReader.readLine()) != null) {
    				content.append(inputLine);
    			}
    			bufferedReader.close();
    			
    			//Parse to json
    			final JSONObject json = new JSONObject(content.toString());
    			item.setState(json.getString("state"));

	        	if(Integer.parseInt(item.getState()) < 5) {
	        		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	        		Thread.sleep(5000);
	        	}else {
	        		System.out.println(item.getName() + ":" + item.getState());
					Thread.sleep(5000);
	        	}

			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException io) {
				io.printStackTrace();
			}
	        
	    }
	}

}
