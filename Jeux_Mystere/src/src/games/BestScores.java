package src.games;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BestScores {

	 // Nb scores max
	private int max_scores;
	 // Nb scores max par défaut
	public static int DEFAULT_MAX_SCORES = 10 ;
	// Les scores
	Score[] scores;
	// Nb scores courant
	int nb_scores = 0;
	// Ordre des scores : croissant, décroissant
	private E_ORDER_BY order_by;

	List<Score> scoreList;

	private static final String FILEPATH = "enorme.lol";



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
			if(score != null)
				System.out.println((i+1) + " - " + score.value + ", " + score.who + ", " + score.when);
		}

	}


	// Chargement des scores depuis un fichier XML
	//     filename : nom du fichier
	public void load_xml(String filename) throws ParserConfigurationException {
		scoreList = new ArrayList<>();

		if(!file_exists(filename)) return;


		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder loader = factory.newDocumentBuilder();
		try {
			Document document = loader.parse(filename);

			DocumentTraversal traversal = (DocumentTraversal) document;

			NodeIterator iterator = traversal.createNodeIterator(
					document.getDocumentElement(), NodeFilter.SHOW_TEXT, null, true
			);

			Score scoreElement = null;

			for (Node i = iterator.nextNode(); i != null;i = iterator.nextNode()) {
				//on check si scoreELement est null

				//si il est null on en créer un nouveau
				if(scoreElement == null){
					scoreElement = new Score();
				}

				//sinon on check si il est complet alors on le met a null et on  créer un nouveau
				if(scoreElement !=null){
					if(scoreElement.value != 0 && scoreElement.when != null && scoreElement.who != null){
						//on a recup tout les élément du score élément actuel
						scoreList.add(scoreElement);
						scoreElement = new Score();
					}
				}

				//sinon on lui ajoute se qui manque

				String text = i.getTextContent().trim();


				if(!text.isEmpty()){
					if(i.getParentNode().getNodeName().equals("nom")){
						scoreElement.who = text;
					}
					if(i.getParentNode().getNodeName().equals("value")){
						scoreElement.value = Integer.parseInt(text);
					}
					if(i.getParentNode().getNodeName().equals("when")){
						scoreElement.when = text;
					}


				}
			}

			if(scoreElement != null){
				scoreList.add(scoreElement);

			}
			nb_scores = scoreList.size() - 1;

			this.scores = new Score[64];

			System.out.println("scoreList = " + scoreList.size());
			for (int j = 0; j <scoreList.size(); j++) {
				if(scoreList.get(j) != null){
					this.scores[j] = scoreList.get(j);

				}
			}
			System.out.println("nb_scores = " + nb_scores);
			

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}




	}
	
	// Sauvegarde des scores dans un fichier XML
	//     filename : nom du fichier
	//     comment : commentaire
	public void save_xml(String filename, String comment) throws ParserConfigurationException {
		//todo complete sa

		try {
			if(file_exists(filename))
				new File(filename).createNewFile(); // créer un nouveau fichier si il n'existe pas
		} catch (IOException e) {
			e.printStackTrace();
		}


		//on crée un Document builder

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();

		//on crée le document

		Document document = documentBuilder.newDocument();
		Element racine = document.createElement("Scores");
		document.appendChild(racine);

		//boucle on parcour tout les joueur
		for (Score score: scores
			 ) {
			if(score != null)
			racine.appendChild(createUser(document, score.who, score.value + "", score.when));

		}


		//on crée un domSerializer avec le document
		DomSerializer domSerializer = new DomSerializer(document);


		//on écrit dans le fichier

		try {
			domSerializer.serialize(filename);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}
	
	// Chargement des scores depuis un fichier JSON
	//     filename : nom du fichier
	public static BestScores load_json(String filename) throws Exception{

		JSONTokener tokener = new org.json.JSONTokener(new FileReader(filename));
		JSONArray a1 = new JSONArray(tokener);
		Score  scoresse[] = new Score[a1.length()];
		for (int i = 0 ; i < a1.length(); i++) {
			if(!a1.isNull(i)){
				JSONObject o = a1.getJSONObject(i);

				if(!o.isNull("who") || !o.isNull("when")){

					scoresse[i] = new Score(o.getInt("value"), o.getString("who"), o.getString("when"));

				}
			}
		}
		BestScores bestScores = new BestScores();


		bestScores.scores = scoresse;
		bestScores.nb_scores = scoresse.length - 1;

		return bestScores;
	}
	
	// Sauvegarde des scores dans un fichier XML
	//     filename : nom du fichier
	public void save_json(String filename){
		// Serialize once
		FileWriter f = null;
		try {
			f = new FileWriter(filename);

			f.write(new JSONArray(scores).toString(4));
			f.flush();
			f.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	// Teste l'existence d'un fichier
	// filename : nom du fichier
	static public Boolean file_exists(String filename) {
		File f = new File(filename);
		if (f.exists() && !f.isDirectory())
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {
		/* Unit tests */
		
		// Init d'un BestScores de 5 scores, dans l'ordre croissant
		BestScores best_scores = new BestScores(BestScores.E_ORDER_BY.ASC, 5);
		// Ajout d'un score
		best_scores.add_score(12, "A");
		// Ajout d'un score
		best_scores.add_score(15, "B");
		// Teste si un score peut rentrer dans les meilleurs scores
		System.out.println(best_scores.is_scoring(16));
		System.out.println(best_scores.is_scoring(14));
		System.out.println(best_scores.is_scoring(11));
		// Ajout de scores
		best_scores.add_score(21, "C");
		best_scores.add_score(14, "D");
		best_scores.add_score(33, "E");
		best_scores.add_score(37, "F");
		best_scores.add_score(30, "G");
		best_scores.add_score(7, "H");
		best_scores.add_score(21, "I");
		best_scores.add_score(33, "J");
		best_scores.add_score(5, "K");
		// Teste si un score peut rentrer dans les meilleurs scores
		System.out.println(best_scores.is_scoring(100));
		System.out.println(best_scores.is_scoring(11));
		// Affichage(s)
		best_scores.write();
		System.out.println(best_scores);
		
		// Sauvegarde XML (non implémenté)
		try {
			best_scores.save_xml("data/scores.xml", "unittest comment");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Chargement XML (non implémenté)
		try {
			best_scores.load_xml("data/scores.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		best_scores.write();

		// Sauvegarde JSON (non implémenté)
		try {
			best_scores.save_json("data/scores1.json");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		best_scores.add_score(5, "M");
		best_scores.write();

		// Chargement JSON (non implémenté)
		best_scores = BestScores.load_json("data/scores1.json");
		System.out.println("best score de json");
		best_scores.write();

	}

	private static Node createUser(Document doc, String nom, String value, String when) {

		Element user = doc.createElement("joueur");

		user.appendChild(createUserElement(doc, "nom", nom));
		user.appendChild(createUserElement(doc, "value", value));
		user.appendChild(createUserElement(doc, "when", when));

		return user;
	}

	private static Node createUserElement(Document doc, String name,
										  String value) {

		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));

		return node;
	}

}
