package inno;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		try {
			Item item = new Item("livingroomCoffieMachine_1_Energy");
			
			while(Integer.parseInt(item.getState()) > 5) {
				item = new Item("livingroomCoffieMachine_1_Energy");
				TimeUnit.SECONDS.sleep(10);
				System.out.println(item.getState());
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
