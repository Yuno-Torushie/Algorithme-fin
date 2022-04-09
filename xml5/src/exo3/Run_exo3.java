package exo3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class Run_exo3 {

	public static void main(String[] args) throws IOException, JSONException {

		Coffee[] coffees ;
		
		// JSON-Java (org.json) 
		System.out.println("======= JSON-Java (org.json) / array =======");
		JSONTokener tokener = new org.json.JSONTokener(new FileReader("src/exo3/data/exo3_coffees.json"));
		JSONArray a1 = new JSONArray(tokener);
		coffees = new Coffee[a1.length()];
		for (int i = 0 ; i < a1.length(); i++) {
			JSONObject o = a1.getJSONObject(i);
			coffees[i] = new Coffee(o.getString("id"), o.getString("name"), o.getDouble("price"));
	    }
		for (Coffee coffee : coffees){System.out.println(coffee);}

		// Gson
		System.out.println("======= Gson / array =======");
		Gson g = new Gson();
		coffees = g.fromJson(new FileReader("src\\exo3\\data\\exo3_coffees.json"), Coffee[].class);
		for (Coffee coffee : coffees){System.out.println(coffee);}

		// Jackson
		System.out.println("======= Jackson / array =======");
	    ObjectMapper mapper = new ObjectMapper();
		
		// Read as array
		coffees = mapper.readValue(new File("src\\exo3\\data\\exo3_coffees.json"), Coffee[].class);
		for (Coffee coffee : coffees){System.out.println(coffee);}
		
		// Read as List
		List<Coffee> l_coffees = new ArrayList<>();
		l_coffees = mapper.readValue(new File("src\\exo3\\data\\exo3_coffees.json"), new TypeReference<List<Coffee>>(){});
		for (Coffee coffee : l_coffees){System.out.println(coffee);}

		System.out.println("======= END =======");
		
	}

}
