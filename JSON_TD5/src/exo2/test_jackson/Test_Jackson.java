package exo2.test_jackson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Test_Jackson {
	
	static public void once() throws IOException {
		
		System.out.println("======= Jackson / once =======");

		// Serialize once
		Glass glass = new Glass("Orange");
		glass.drink();
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT, true);
	    //mapper.enable(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
	    mapper.disable(com.fasterxml.jackson.core.JsonGenerator.Feature.AUTO_CLOSE_TARGET);
	    mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		mapper.writeValue(new File("src\\exo2\\data\\jackson_once.json"), glass);
		
		// Read once
		glass = mapper.readValue(new File("src\\exo2\\data\\jackson_once.json"), Glass.class);
		glass.drink();
	}

	static public void array() throws IOException {
		
		System.out.println("======= Jackson / array =======");


		// Serialize collection
		Glass[] glasses = new Glass[] { new Glass("Brown"), new Glass("Purple") };
		for (Glass glass : glasses){glass.drink();}
	    ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("src\\exo2\\data\\jackson_array.json"), glasses);

		// Read collection
		
		// Read as array
		glasses = mapper.readValue(new File("src\\exo2\\data\\jackson_array.json"), Glass[].class);
		for (Glass glass : glasses){glass.drink();}
		
		// Read as List
		List<Glass> l_glasses = new ArrayList<>();
		//l_glasses = mapper.readValue(new File("src\\exo2\\data\\jackson_array.json"), new TypeReference<List<Glass>>(){});
		//for (Glass glass : l_glasses){glass.drink();}


	}

}
