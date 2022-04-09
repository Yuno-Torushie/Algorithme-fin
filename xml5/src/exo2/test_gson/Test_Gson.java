package exo2.test_gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;


public class Test_Gson {
	
	static public void once() throws IOException {
		
		System.out.println("======= Gson / once =======");

		Gson g = new Gson();
		
		// Serialize once
		Glass glass = new Glass("Green");
		glass.drink();
		FileWriter f = new FileWriter("src\\exo2\\data\\gson_once.json");
		g.toJson(glass, f);
		f.flush();
		f.close();
		
		// Read once
		glass = g.fromJson(new FileReader("src\\exo2\\data\\gson_once.json"), Glass.class);
		glass.drink();
	}

	static public void array() throws IOException {
		
		System.out.println("======= Gson / array =======");

		Gson g = new Gson();

		// Serialize collection
		Glass[] glasses = new Glass[] { new Glass("Red"), new Glass("Blue") };
		for (Glass glass : glasses){glass.drink();}
		FileWriter f = new FileWriter("src\\exo2\\data\\gson_array.json");
		g.toJson(glasses, f);
		f.flush();
		f.close();

		// Read collection
		glasses = g.fromJson(new FileReader("src\\exo2\\data\\gson_array.json"), Glass[].class);
		for (Glass glass : glasses){glass.drink();}

	}

}
