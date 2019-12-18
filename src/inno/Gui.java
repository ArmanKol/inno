package inno;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Dit is de gui class. Dit creëert een gui
 */
public class Gui {
	private final Item item = new Item(); // item.getAllItems() gebruikt in createLabels
	private final JFrame mainFrame = new JFrame(); // Maakt de GUI scherm aan
	private final GridLayout layout = new GridLayout(0,2); //Een layout van 2 columnen en oneindig rijen
	public Gui() {
		this.mainFrame.setLayout(this.layout);
		
		createLabels();
		
		this.mainFrame.setSize(800,800);
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setVisible(true);
	}
	
	/*
	 * Deze methode maakt voor elke item dat in openhab geconfigureerd is een label aan. De label bestaat uit de item naam en de knoppen ON en OFF.
	 */
	private void createLabels() {
		JLabel itemName, itemState;

		for(Item item : item.getAllItems("EnergyConsumption", true)) {
			itemName = new JLabel(item.getName());
			itemState = new JLabel(item.getState());
			
			
			this.mainFrame.add(itemName);
			this.mainFrame.add(itemState);
		}
	}
}
