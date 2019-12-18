package inno;

public class MultiThreading implements Runnable{
	private Item item;
	
	public MultiThreading(Item item) {
		this.item = item;
	}
	
	public void run() {
    	if(Integer.parseInt(item.getState()) < 5) {
    		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    	}else {
    		System.out.println(item.getName() + ":" + item.getState());
    	}

	} 

}
