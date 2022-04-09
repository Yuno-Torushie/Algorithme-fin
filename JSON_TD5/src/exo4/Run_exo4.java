package exo4;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Run_exo4 {

	public static void main(String[] args) throws IOException {

		nyc_restaurants();
		nasa();

	}

	public static void nyc_restaurants() throws IOException {

		int nbFrench = 0, nbFrenchManhattan = 0, nbChinese = 0, nbChineseManhattan = 0 ;

		// map to GSON objects
		JsonElement root = JsonParser.parseReader(new FileReader("src/exo4/data/nyc_restaurants_prettyprint.json"));

		// Get items
		JsonArray items = root.getAsJsonArray();
		
		// Retrieve restaurants and count
		for (JsonElement item : items) {
			
			JsonObject restaurant = item.getAsJsonObject();
			System.out.println(restaurant);

		}
		
		System.out.println("==== French cuisine = " + nbFrench);
		System.out.println("==== French cuisine in Manhattan = " + nbFrenchManhattan);
		System.out.println("==== Chinese cuisine = " + nbChinese);
		System.out.println("==== Chinese cuisine in Manhattan = " + nbChineseManhattan);
		
	}

	public static void nasa() throws IOException {

		// RESULT
		List<String> hrefs = new ArrayList<>();

		// make the GET request
		String uri = "https://images-api.nasa.gov/search?q=planets"; // &media_type=audio,video,image
		URLConnection request = new URL(uri).openConnection();
		request.connect();
		InputStreamReader inputStreamReader = new InputStreamReader((InputStream) request.getContent());

		// map to GSON objects
		JsonElement root = null;
		root = JsonParser.parseReader(inputStreamReader);
		// root = JsonParser.parseReader(new FileReader("src/exo4/data/rest_clouds.json"));

		// Get items

		for (String href : hrefs) {
			System.out.println(href);
		}
		System.out.println("======= END : " + hrefs.size() + " =======");

	}


}
