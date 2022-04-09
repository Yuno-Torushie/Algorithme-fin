package exo2;

import java.io.IOException;

import org.json.JSONException;

import exo2.test_gson.Test_Gson;
import exo2.test_jackson.Test_Jackson;
import exo2.test_jsonjava.Test_JsonJava;

public class Run_exo2 {

	public static void main(String[] args) throws IOException, JSONException {

		// JSON-Java (org.json) 
		Test_JsonJava.once();
		Test_JsonJava.array();

		// Gson
		Test_Gson.once();
		Test_Gson.array();

		// Jackson
		Test_Jackson.once();
		Test_Jackson.array();

		System.out.println("======= END =======");
		
	}

}
