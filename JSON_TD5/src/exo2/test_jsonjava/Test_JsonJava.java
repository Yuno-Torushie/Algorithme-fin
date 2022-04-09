package exo2.test_jsonjava;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


public class Test_JsonJava {

	static public void once() throws IOException, JSONException {
		
		System.out.println("======= JSON-Java (org.json) / once=======");

		// Serialize once
		Glass glass = new Glass("Yellow");
		glass.drink();
		FileWriter f = new FileWriter("src\\exo2\\data\\jsonjava_once.json");
		//f.write(new JSONObject(glass).toString(4));
		f.flush();
		f.close();
		
		// Read once, not direct mapping
		//JSONTokener tokener = new JSONTokener(new FileReader("src\\exo2\\data\\jsonjava_once.json"));
		//JSONObject o = new JSONObject(tokener);
		//glass = new Glass(o.getString("color"), o.getInt("counter"));
		//glass.drink();
	}

	static public void array() throws IOException, JSONException {
		
		System.out.println("======= JSON-Java (org.json) / array =======");

		// Serialize collection
		Glass[] glasses = new Glass[] { new Glass("Pink"), new Glass("White") };
		for (Glass glass : glasses){glass.drink();}
		FileWriter f = new FileWriter("src\\exo2\\data\\jsonjava_array.json");
		//f.write(new JSONArray(glasses).toString(4));
		f.flush();
		f.close();

		// Read collection, not direct mapping
		//JSONTokener tokener = new org.json.JSONTokener(new FileReader("src\\exo2\\data\\jsonjava_array.json"));
		//JSONArray a1 = new JSONArray(tokener);
		//glasses = new Glass[a1.length()];
		//for (int i = 0 ; i < a1.length(); i++) {
		//	JSONObject o = a1.getJSONObject(i);
		//	glasses[i] = new Glass(o.getString("color"), o.getInt("counter"));
	    //}
		//for (Glass glass : glasses){glass.drink();}
	}

}
