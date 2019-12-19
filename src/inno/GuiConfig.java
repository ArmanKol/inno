package inno;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.simple.JSONObject;

/*
 * Dit is de gui class. Dit creëert een gui
 */
public class GuiConfig {
	public final JFrame mainFrame = new JFrame(); // Maakt de GUI scherm aan
	private final GridLayout layout = new GridLayout(0,1); //Een layout van 2 columnen en oneindig rijen
	private JPanel panel = new JPanel();
	
	public GuiConfig() {
		this.mainFrame.setLayout(this.layout);
		
		createContent();
		
		this.mainFrame.setSize(800,800);
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.pack();
        this.mainFrame.setLocationByPlatform(true);
		this.mainFrame.setVisible(true);
	}
	
	
	
	/*
	 * 
	 */
	public void createContent() {
		JLabel text = new JLabel("Op welke tijdstip wil je de stopcontacten inschakelen? example: '06:00'");
		JTextField inschakelen = new JTextField(5);
		
		JLabel text2 = new JLabel("Op welke tijdstip wil je de stopcontacten uitschakelen? example: '02:00'");
		JTextField uitschakelen = new JTextField(5);
		JButton buttonWrite  = new JButton("Opslaan"); 
		
		this.panel.add(text);
		this.panel.add(inschakelen);
		this.panel.add(text2);
		this.panel.add(uitschakelen);
		this.panel.add(buttonWrite);
		
		this.mainFrame.add(panel);
		
		buttonWrite.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent event){
				try (FileWriter file = new FileWriter("config.json")) {
					JSONObject json = new JSONObject();
					
					json.put("inschakelen", inschakelen.getText());
					json.put("uitschakelen", uitschakelen.getText());
					
					file.write(json.toJSONString());
				}catch(IOException ioe) {
					ioe.printStackTrace();
				}
				System.out.println(inschakelen.getText());
				System.out.println(uitschakelen.getText());
	        }  
	    });
		
	}
	
}
