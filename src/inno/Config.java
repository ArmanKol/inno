package inno;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Config {
	private String inschakelen;
	private String uitschakelen;
	
	public Config() 
	{
		readJson();
	}
	
	public void readJson() 
	{
		JSONParser jsonParser = new JSONParser();
		try (Reader reader = new FileReader("config.json")){
			JSONObject json = (JSONObject) jsonParser.parse(reader);
			inschakelen = (String) json.get("inschakelen");
			uitschakelen = (String) json.get("uitschakelen");
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}catch(ParseException pe) {
			pe.printStackTrace();
		}
	}
	
	public String getInschakelen() {
		return this.inschakelen;
	}
	
	public String getUitschakelen() {
		return this.uitschakelen;
	}
}
