package games;

import java.io.IOException;

import org.jdom2.JDOMException;

public class Play {

	public static void main(String[] args) throws IOException, JDOMException {

		// Nombre mystere - jeux et meilleurs scores
		MysteryNumber facile = new MysteryNumber(10);
		BestScores facileSc = new BestScores(BestScores.E_ORDER_BY.ASC);

		MysteryNumber normal = new MysteryNumber(100);
		BestScores normalSc = new BestScores(BestScores.E_ORDER_BY.ASC, 10);

		MysteryNumber difficile = new MysteryNumber(1000);
		BestScores difficileSc = new BestScores(BestScores.E_ORDER_BY.ASC, 10);

		BestScores meilleurSc = new BestScores(BestScores.E_ORDER_BY.ASC);

		Score score = new Score();

		boolean bEnd = false;
		while (!bEnd) {

			System.out.println("Mode de jeu : \n"
					+ "(f) facile - 10 chiffres \n"
					+ "(n) normal - 100 chiffres \n"
					+ "(d) difficile - 1000 chiffres \n");
			System.out.println("\n Consulter les scores : \n"
					+ "(1) Scoreboard du niveau facile \n"
					+ "(2) Scoreboard du niveau normal \n"
					+ "(3) Scoreboard du niveau difficile");
			System.out.println("\n Quitter : q");

			// Récupération saisie utilisateur
			char sChoice = Lire.c();

			// Analyse saisie utilisateur
			switch (sChoice) {

			case 'f':
				System.out.println("Votre nom :");
				score.who = Lire.S();

				score.value = facile.play();

				if (BestScores.file_exists("data/file.xml")) {
					facileSc.load_xml("data/file.xml");
				}
				facileSc.save_xml("data/file.xml");
				break;

			case 'n':
				System.out.println("Votre nom :");
				score.who = Lire.S();

				score.value = normal.play();

				if (BestScores.file_exists("data/file.xml")) {
					normalSc.load_xml("data/file.xml");
				}
				normalSc.save_xml("data/file.xml");
				break;

			case 'd':
				System.out.println("Votre nom :");
				score.who = Lire.S();

				score.value = normal.play();

				if (BestScores.file_exists("data/file.xml")) {
					difficileSc.load_xml("data/file.xml");
				}
				difficileSc.save_xml("data/file.xml");
				break;

			case '1':
				System.out.println("Résultat du niveau facile\n");
				facileSc.load_xml("data/file.xml");
				facileSc.write();
				break;

			case '2':
				System.out.println("Résultat du niveau normal\n");
				normalSc.load_xml("data/file.xml");
				facileSc.write();
				break;


			case '3':
				System.out.println("Résultat du niveau difficile\n");
				difficileSc.load_xml("data/file.xml");
				difficileSc.write();
				break;

			case 'q': // Choix 'q' : Fin
				bEnd = true;
				break;

			default:
				System.out.println("Saisie incorrecte !!!");
				break;
			}
		}
		System.out.println("Bye !");
	}
}
