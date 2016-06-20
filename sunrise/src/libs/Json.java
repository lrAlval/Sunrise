package libs;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json  {
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	Gson gson =  new GsonBuilder().setPrettyPrinting().create();
	
	
	public void put(String key,Object value){
		JSONROOT.put(key, value);
	}
	
	
	public String toJson(){
		return gson.toJson(JSONROOT);
	}
	
}
