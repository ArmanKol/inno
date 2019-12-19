package inno;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Config {
	private String inschakelen;
	private String uitschakelen;
	
	public Config() 
	{
		readJson();
	}
	
	public void readJson() 
	{
		JsonParser jsonParser = new JsonParser();
		try (Reader reader = new FileReader("config.json")){
			
			JsonObject json = (JsonObject) jsonParser.parse(reader);
			inschakelen = json.getAsJsonPrimitive("inschakelen").toString();
			uitschakelen = json.getAsJsonPrimitive("uitschakelen").toString();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public String getInschakelen() {
		return this.inschakelen;
	}
	
	public String getUitschakelen() {
		return this.uitschakelen;
	}
}
