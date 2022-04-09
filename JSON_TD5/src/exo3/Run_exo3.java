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
		
		System.out.println("======= Gson =======");
		Gson g = new Gson();
		coffees = g.fromJson(new FileReader("src\\exo3\\data\\exo3_coffees.json"), Coffee[].class);
		for (Coffee coffee : coffees) {System.out.println(coffee);}
		
		System.out.println("======= Jackson =======");
	    ObjectMapper mapper = new ObjectMapper();
		coffees = mapper.readValue(new FileReader("src\\exo3\\data\\exo3_coffees.json"), Coffee[].class);
		for (Coffee coffee : coffees) {System.out.println(coffee);}
		
		System.out.println("======= JSON-Java =======");
		System.out.println(new JSONArray(coffees).toString());
		
		System.out.println("======= END =======");
	}

}
