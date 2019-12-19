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
	public final JFrame mainFrame = new JFrame(); // Maakt de GUI scherm aan
	private final GridLayout layout = new GridLayout(0,2); //Een layout van 2 columnen en oneindig rijen
	
	public JLabel itemName = new JLabel();
	public JLabel itemState = new JLabel();
	
	public Gui() {
		this.mainFrame.setLayout(this.layout);
		
		//createLabels();
		
		this.mainFrame.setSize(800,800);
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setVisible(true);
	}
	
	
	
	/*
	 * Deze methode maakt voor elke item dat in openhab geconfigureerd is een label aan. Daarachter wordt de Energy weergegeven
	 */
	public void createLabels() {
		itemName.removeAll();
		itemState.removeAll();
		
		for(Item item : item.getAllItems("EnergyConsumption", true)) {
			itemName = new JLabel(item.getName());
			itemState = new JLabel(item.getState());
			
			this.mainFrame.add(itemName);
			this.mainFrame.add(itemState);
		}
	}
}
