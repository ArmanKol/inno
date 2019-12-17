package inno;

import java.util.concurrent.TimeUnit;

public class MultiThreading implements Runnable{
	private Item item;
	
	public MultiThreading(Item item) {
		this.item = item;
		System.out.println(item.toString());
	}
	
	public void run() {
	    while(Integer.parseInt(item.getState()) > 5) {
	        try {
		        System.out.println(Thread.currentThread().getId());
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        
	        if (Thread.interrupted()) {
	            return;
	        }
	    }
	}

}
