package inno;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Item items = new Item();
		
		while(true) {
			for(Item item : items.getAllItems("EnergyConsumption", true)) {
				if(Integer.parseInt(item.getState()) < 5) {
					System.out.println("AAAAAAAAA");
				}else {
					System.out.println(item.getName() + ":" + item.getState());
				}
				
			}
			TimeUnit.SECONDS.sleep(5);
		}

		//Gui gui = new Gui();
		
	}

}
