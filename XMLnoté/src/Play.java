import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.JDOMException;
import org.json.JSONException;
import org.xml.sax.SAXException;


/**
 * @author LEDROIT
 *
 */
public class Play {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, JDOMException, JSONException {
		BestScores bestScoresEasy = new BestScores(BestScores.E_ORDER_BY.ASC, 5);
		MysteryNumber easy = new MysteryNumber(10);
		BestScores bestScoresMedium = new BestScores(BestScores.E_ORDER_BY.ASC, 5);
		MysteryNumber medium = new MysteryNumber(100);
		BestScores bestScoresHard = new BestScores(BestScores.E_ORDER_BY.ASC, 5);
		MysteryNumber hard = new MysteryNumber(1000);
		int score = -1;
		boolean bEnd = false;
		String name;
		String saveChoice = "";
		while (bEnd == false) {
			System.out.println("\n\nMenu :\n");
			System.out.println("e-easy");
			System.out.println("m-medium");
			System.out.println("h-hard");
			System.out.println("q-Quitter");
			System.out.print("\nVotre choix : ");
			String sChoice = Lire.S();


			switch (sChoice) {
				case "q": // Choix 'q' : Fin
					bEnd = true;
					break;
				case "e":
					bestScoresEasy.write();
					while (!saveChoice.equals("x" ) && !saveChoice.equals("j")){
						System.out.println("\n\nMethode de sauvegarde :\n");
						System.out.println("x-xml");
						System.out.println("j-json");
						saveChoice = Lire.S();
					}
					if (saveChoice.equals("x")){
						if (BestScores.file_exists("./src/fichier/xmlEasy.xml")){
							bestScoresEasy.load_xml("./src/fichier/xmlEasy.xml");
						}
						score = easy.play();
						if (bestScoresEasy.is_scoring(score)){
							System.out.println("Who are you ?");
							name = Lire.S();
							bestScoresEasy.add_score(score,name);
							bestScoresEasy.save_xml("./src/fichier/xmlEasy.xml");
						}
						else {
							System.out.println("votre score ne fait pas parti des meilleurs scores");
						}
					}
					if (saveChoice.equals("j")){
						if (BestScores.file_exists("./src/fichier/jsonEasy.json")){
							bestScoresEasy.load_json("./src/fichier/jsonEasy.json");
						}
						score = easy.play();
						if (bestScoresEasy.is_scoring(score)){
							System.out.println("Who are you ?");
							name = Lire.S();
							bestScoresEasy.add_score(score,name);
							bestScoresEasy.save_json("./src/fichier/jsonEasy.json");
						}
						else {
							System.out.println("votre score ne fait pas parti des meilleurs scores");
						}
					}
					saveChoice = "";
					break;
				case "m":
					bestScoresMedium.write();
					while (!saveChoice.equals("x" ) && !saveChoice.equals("j")) {
						System.out.println("\n\nMethode de sauvegarde :\n");
						System.out.println("x-xml");
						System.out.println("j-json");
						saveChoice = Lire.S();
					}
					if (saveChoice.equals("x")){
						if (BestScores.file_exists("./src/fichier/xmlMedium.xml")){
							bestScoresEasy.load_xml("./src/fichier/xmlMedium.xml");
						}
						score = medium.play();
						if (bestScoresMedium.is_scoring(score)){
							System.out.println("Who are you ?");
							name = Lire.S();
							bestScoresMedium.add_score(score,name);
							bestScoresMedium.save_xml("./src/fichier/xmlMedium.xml");
						}
						else {
							System.out.println("votre score ne fait pas parti des meilleurs scores");
						}
					}
					if (saveChoice.equals("j")){
						if (BestScores.file_exists("./src/fichier/jsonMedium.json")){
							bestScoresEasy.load_json("./src/fichier/jsonMedium.json");
						}
						score = medium.play();
						if (bestScoresMedium.is_scoring(score)){
							System.out.println("Who are you ?");
							name = Lire.S();
							bestScoresMedium.add_score(score,name);
							bestScoresMedium.save_json("./src/fichier/jsonMedium.json");
						}
						else {
							System.out.println("votre score ne fait pas parti des meilleurs scores");
						}
					}
					saveChoice = "";
					break;
				case "h":
					bestScoresHard.write();
					while (!saveChoice.equals("x") && !saveChoice.equals("j")) {
						System.out.println("\n\nMethode de sauvegarde :\n");
						System.out.println("x-xml");
						System.out.println("j-json");
						saveChoice = Lire.S();
					}
					if (saveChoice.equals("x")){
						if (BestScores.file_exists("./src/fichier/xmlHard.xml")){
							bestScoresEasy.load_xml("./src/fichier/xmlHard.xml");
						}
						score = hard.play();
						if (bestScoresHard.is_scoring(score)){
							System.out.println("Who are you ?");
							name = Lire.S();
							bestScoresHard.add_score(score,name);
							bestScoresHard.save_xml("./src/fichier/xmlHard.xml");
						}
						else {
							System.out.println("votre score ne fait pas parti des meilleurs scores");
						}
					}
					if (saveChoice.equals("j")){
						if (BestScores.file_exists("./src/fichier/jsonHard.json")){
							bestScoresEasy.load_json("./src/fichier/jsonHard.json");
						}
						score = hard.play();
						if (bestScoresHard.is_scoring(score)){
							System.out.println("Who are you ?");
							name = Lire.S();
							bestScoresHard.add_score(score,name);
							bestScoresHard.save_json("./src/fichier/jsonHard.json");
						}
						else {
							System.out.println("votre score ne fait pas parti des meilleurs scores");
						}
					}
					saveChoice = "";
					break;
				default:
					System.out.println("Saisie incorrecte !!!");
					break;
			}
			sChoice = "";
		}
		System.out.println("Bye !");
	}
}