package inno;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Item items = new Item();
		//Gui gui = new Gui();
		
		while(true) {
			
			for(Item item : items.getAllItems("EnergyConsumption", true)) {
				if(Float.parseFloat(item.getState()) == 1) {
				}else if(Float.parseFloat(item.getState()) < 5) {
					//System.out.println(item.getName() + ":::" + item.getState());
					item.changeState(item.getName(), "1");
				}
				else {
					System.out.println(item.getName() + ":" + item.getState());
				}
				
			}
			TimeUnit.SECONDS.sleep(5);
		}
		
	}

}
