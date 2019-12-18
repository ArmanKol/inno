package inno;

public class Main {

	public static void main(String[] args) {
		Item items = new Item();
		
		for(Item item : items.getAllItems("EnergyConsumption", true)) {
			Thread mt = new Thread(new MultiThreading(item, item.getName()));
			mt.start();
		}

		//Gui gui = new Gui();
		
	}

}
