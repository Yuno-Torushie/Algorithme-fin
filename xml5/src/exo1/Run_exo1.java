package exo1;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Run_exo1 {

	public static void main(String[] args) throws IOException, JSONException {

		// Init Cafe collection
		Coffee[] coffees = new Coffee[] { new Coffee("001", "Robusta", 3.15),
		                              	  new Coffee("002", "Noir Désir", 2.21),
		                              	  new Coffee("003", "Java", 5.15)};
		
		// JSON-Java (org.json)
		System.out.println("======= JSON-Java =======");
		System.out.println(new JSONArray(coffees).toString(4));
		
		// Gson
		System.out.println("======= Gson =======");
		//Gson g = new Gson();
		Gson g = new GsonBuilder().setPrettyPrinting().create();
		System.out.println(g.toJson(coffees));
		
		// Jackson
		System.out.println("======= Jackson =======");
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT, true);
	    mapper.disable(com.fasterxml.jackson.core.JsonGenerator.Feature.AUTO_CLOSE_TARGET);
		mapper.writeValue(System.out, coffees);
		System.out.println("");
		
		System.out.println("======= END =======");
		
	}

}
