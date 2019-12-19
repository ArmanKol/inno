package inno;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Item items = new Item();
		//Gui gui = new Gui();
		GuiConfig guiConfig = new GuiConfig();
		Config config = new Config();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
		
		while(true) {
			LocalDateTime now = LocalDateTime.now();
			for(Item item : items.getAllItems("EnergyConsumption", true)) {
				if(dtf.format(now).equals(config.getInschakelen())) {
					item.changeState("livingroomTV_1_Relay", "ON");
				}
				if(Float.parseFloat(item.getState()) == 1) {
					
				}else if(Float.parseFloat(item.getState()) < 5) {
					//System.out.println(item.getName() + ":::" + item.getState());
					item.changeState("livingroomTV_1_Relay", "OFF");
				}
				else {
					//System.out.println(item.getName() + ":" + item.getState());
					System.out.println(dtf.format(now));  
				}
				
			}
			TimeUnit.SECONDS.sleep(5);
		}
		
	}

}
