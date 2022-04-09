package games;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.util.IteratorIterable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.xml.sax.InputSource;

public class BestScores {

	 // Nb scores max
	private int max_scores;
	 // Nb scores max par défaut
	public static int DEFAULT_MAX_SCORES = 10 ;
	// Les scores
	static Score[] scores;
	// Nb scores courant
	int nb_scores = 0;
	// Ordre des scores : croissant, décroissant
	private E_ORDER_BY order_by;
	private InputSource filename;
	public static enum E_ORDER_BY{
		ASC, DESC
	}
	
	// Constructeur par défaut, sans argument
	public BestScores() {
		super();
	}

	// Constructeur
	//    order_by : ordre des scores : croissant, décroissant
	public BestScores(E_ORDER_BY order_by){
		this(order_by, BestScores.DEFAULT_MAX_SCORES);
	}
	
	// Constructeur
	//    order_by : ordre des scores : croissant, décroissant
	//    max_scores : nb scores max
	public BestScores(E_ORDER_BY order_by, int max_scores){
		super();
		this.order_by = order_by;
		this.max_scores = max_scores;
		this.scores = new Score[this.max_scores];
		this.nb_scores = 0;
	}
	
	// Compare deux scores A et B
	private boolean is_better(int valueA, int valueB){
		if (this.order_by == BestScores.E_ORDER_BY.ASC && valueA < valueB){
			return true;
		}
		if (this.order_by == BestScores.E_ORDER_BY.DESC && valueA > valueB){
			return true ;
		}
		return false;
	}
	
	// Position du score dans la liste
	//      score : valeur du score
	private int get_position(int new_score){
		for (int i=0; i < this.nb_scores; i++){
			Score score = this.scores[i];
			if (this.is_better(new_score, score.value)){
				return i;
			}
		}
		return this.nb_scores;
	}
	
	// Définit si un score fait partie des meilleurs scores
	//      score : valeur du score
	public boolean is_scoring(int new_score){
		return this.nb_scores < this.max_scores || this.is_better(new_score, this.scores[this.nb_scores-1].value) ;
	}
	
	// Ajout d'un score
	//    value : combien ?
	//    who : qui ?
	//    when : quand ?
	public void add_score(int value, String who, String when){
		int pos = this.get_position(value);
		for (int i=this.max_scores-1; i>pos; i--){
			this.scores[i] = this.scores[i-1];
		}
		if (pos < this.max_scores){
			this.scores[pos] = new Score(value, who, when);
			if (this.nb_scores < this.max_scores)
				this.nb_scores ++;
		}
	}
	
	// Ajout d'un score
	//    value : combien ?
	//    who : qui ?
	public void add_score(int value, String who){
		this.add_score(value, who, new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
	}

	// Ajout d'un score à partir d'un objet Score
	//     filename : nom du fichier
	public void add_score(Score score){
		this.add_score(score.value, score.who, score.when);
	}
	
	// Conversion String pour affichage
	public String toString(){
		String s = "";
		for (int i=0; i<this.nb_scores; i++){
			Score score = this.scores[i];
			s += (i+1) + " - " + score.value + ", " + score.who + ", " + score.when + "\n";
		}
		return s;
	}
	
	// Affichage des scores sur console
	public void write(){
		for (int i=0; i<this.nb_scores; i++){
			Score score = this.scores[i];
			System.out.println((i+1) + " - " + score.value + ", " + score.who + ", " + score.when);
		}
	}


	// Chargement des scores depuis un fichier XML
	//     filename : nom du fichier
	public void load_xml(String filename) throws IOException, JDOMException {
		// 1. Creation d'un parser SAX
				SAXBuilder saxBuilder = new SAXBuilder();

		// 1. Creation d'un document JDOM
		Document document = saxBuilder.build(filename);
				
		IteratorIterable<?> processDescendants = document.getDescendants(new ElementFilter("score"));
		int i = 0;
		while (processDescendants.hasNext()) {
			org.jdom2.Element elt = (org.jdom2.Element) processDescendants.next();
			Score score = new Score(Integer.parseInt(elt.getChild("valeur").getTextTrim()),elt.getChild("nom").getTextTrim(),elt.getChild("date").getTextTrim());
			this.scores[i] = score;
			i++;
		}
	}
	
	// Sauvegarde des scores dans un fichier XML
	//     filename : nom du fichier
	public void save_xml(String filename) throws IOException{
		Element ss = new Element("scores");
		Document doc = new Document(ss);

		for (int i = 0; i< scores.length;i++) {

			if (scores[i] != null){
				Element s = new Element("score");
				s.addContent(new Element("valeur").setText(scores[i].value+""));
				s.addContent(new Element("nom").setText(scores[i].who));
				s.addContent(new Element("date").setText(scores[i].when));
				doc.getRootElement().addContent(s);
			}
		}
		new XMLOutputter().output(doc, System.out);

		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(doc, new FileWriter(filename));
	}


	// Chargement des scores depuis un fichier JSON
	//     filename : nom du fichier
	public void load_json(String filename) throws FileNotFoundException, JSONException {
		if (file_exists(filename)){
			Gson g = new Gson();
			Score[] scoresJson = g.fromJson(new FileReader(filename), Score[].class);
			for (Score score: scoresJson) {
				if (score != null){
					add_score(score);
				}
			}
		}else {
			System.out.println("Le fichier n'existe pas");
		}
	}



	// Sauvegarde des scores dans un fichier XML
	//     filename : nom du fichier
	public void save_json(String filename) throws IOException {
		FileWriter f = new FileWriter(filename);
		Gson g = new Gson();
		g.toJson(scores, f);
		f.flush();
		f.close();
	}
	
	// Teste l'existence d'un fichier
	// filename : nom du fichier
	static public Boolean file_exists(String filename) {
		File f = new File(filename);
		if (f.exists() && !f.isDirectory() && f.length() > 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {
		/* Unit tests */
		
		// Init d'un BestScores de 5 scores, dans l'ordre croissant
		BestScores best_scores = new BestScores(BestScores.E_ORDER_BY.ASC, 5);
		// Ajout de scores
		best_scores.add_score(21, "C");
		best_scores.add_score(14, "D");
		best_scores.add_score(33, "E");
		best_scores.add_score(37, "F");

		// Affichage(s)
		best_scores.write();
		System.out.println(best_scores);
		
		// Sauvegarde XML 
		try {
			best_scores.save_xml("data/file.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Chargement XML 
		try {
			best_scores.load_xml("data/file.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		best_scores.write();

		// Sauvegarde JSON 
		try {
			best_scores.save_json(".data/filejson.json");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		best_scores.add_score(5, "M");
		best_scores.write();
		// Chargement JSON
		best_scores.load_json("data/filejson.json");
		best_scores.write();

	}

}