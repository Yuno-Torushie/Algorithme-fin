package src.games;


import javax.xml.parsers.ParserConfigurationException;


public class Play {

	//declaration des variable

		//xml
	private  static final String XMLFINALNAMEDIF1 = "data/scores.xml";
	private  static final String XMLFINALNAMEDIF2 = "data/scores2.xml";
	private  static final String XMLFINALNAMEDIF3 = "data/scores3.xml";
		//json
	private  static final String JSONFINALNAMEDIF1 = "data/scores1.json";
	private  static final String JSONFINALNAMEDIF2 = "data/scores2.json";
	private  static final String JSONFINALNAMEDIF3 = "data/scores3.json";




	private static String nom;
	private static ModeEnregistrement modeEnregistrement;
	private static Difficulte difficulte;

	public static void main(String[] args) {



		// Nombre mystère - jeux et meilleurs scores
		MysteryNumber mystery_level1 = new MysteryNumber(10);
		MysteryNumber mystery_level2 = new MysteryNumber(100);
		MysteryNumber mystery_level3 = new MysteryNumber(1000);
		BestScores mystery_level1_sc = new BestScores(BestScores.E_ORDER_BY.ASC, 10);
		BestScores mystery_level2_sc = new BestScores(BestScores.E_ORDER_BY.ASC, 100);
		BestScores mystery_level3_sc = new BestScores(BestScores.E_ORDER_BY.ASC, 1000);

		//on demande le nom du joueur
		System.out.println("Quelles est ton nom ?");
		nom =  Lire.S();

		//on demande le mode d'enregistrement
		do {
			int i = 1;
			System.out.println("quelle mode d'enregistrement souhaite tu");
			for (ModeEnregistrement modeEnregistrement: ModeEnregistrement.values()
				 ) {
				System.out.println(i +" - " + modeEnregistrement.toString());
				i++;
			}
			int choi = Lire.i();
			if(choi >= 1 && choi <= ModeEnregistrement.values().length){
				choi--;
				modeEnregistrement = ModeEnregistrement.values()[choi];
				System.out.println("tu as choisi le mode " + modeEnregistrement.toString());
				break;
			}
			System.out.println("erreur");
		}while(true);


		//on charge les précédent score

		try {
			if(modeEnregistrement == ModeEnregistrement.XML){

				mystery_level1_sc.load_xml(XMLFINALNAMEDIF1);
				mystery_level2_sc.load_xml(XMLFINALNAMEDIF2);
				mystery_level3_sc.load_xml(XMLFINALNAMEDIF3);

			}
			if(modeEnregistrement == ModeEnregistrement.JSON){
				mystery_level1_sc = mystery_level1_sc.load_json(JSONFINALNAMEDIF1);
				mystery_level2_sc = mystery_level2_sc.load_json(JSONFINALNAMEDIF2);
				mystery_level3_sc = mystery_level3_sc.load_json(JSONFINALNAMEDIF3);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}


		boolean bEnd = false;
		while (!bEnd) {

			System.out.println("\n\nMenu :\n");
			System.out.println("d-Niveau 1 Débutant");
			System.out.println("n-Niveau 2 normal");
			System.out.println("e-Niveau 3 expert");
			System.out.println("m-voir meilleur score");
			System.out.println("q-Quitter");
			System.out.print("Votre choix : ");

			// Récupération saisie utilisateur
			char sChoice = Lire.c();

			// Analyse saisie utilisateur
			switch (sChoice) {
				case 'd': // choix facile
					play(mystery_level1, mystery_level1_sc, Difficulte.FACILE);
					break;
				case 'n': // choix normal
					play(mystery_level2, mystery_level2_sc, Difficulte.NORMAL);
					break;
					case 'e': // choix difficile
						play(mystery_level3, mystery_level3_sc, Difficulte.DIFFICILE);
						break;
				case 'm':
					System.out.println("affichage des score de difficulté facile");
					mystery_level1_sc.write();
					System.out.println("affichage des score de difficulté normal");
					mystery_level2_sc.write();
					System.out.println("affichage des score de difficulté difficile");
					mystery_level3_sc.write();
					break;
			case 'q': // Choix 'q' : Fin
				bEnd = true;
				break;
			default:
				System.out.println("Saisie incorrecte !!!");
				break;
			}
			if (!bEnd) {
				System.out.println("<Enter> pour revenir au menu principal");
				Lire.c();
			}
		}
		System.out.println("Bye !");
	}


	private static void play(MysteryNumber mysteryNumber, BestScores bestScores,Difficulte difficulte){
		int score = mysteryNumber.play();
		//si le score fait partit des meilleur score
		if(bestScores.is_scoring(score)){

			// demander qui est le joueur
			System.out.println("wow ton score fait partit des meilleur score ");


			// ajouter le score du joueur

			bestScores.add_score(score, nom);

			//on fait une sauvegarde dans les fichier

			String filename = getFileName(difficulte);

			try {
				switch (modeEnregistrement){
					case XML:
						bestScores.save_xml(filename, "lol");
						break;
					case JSON:
						bestScores.save_json(filename);
						break;
				}
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}


		} //sinon il ne fait pas partit des meilleur score
	}

	private static String getFileName(Difficulte difficulte){
		if(modeEnregistrement == ModeEnregistrement.XML){

			switch (difficulte){
				case FACILE:
					return XMLFINALNAMEDIF1;
				case NORMAL:
					return XMLFINALNAMEDIF2;
				case DIFFICILE:
					return XMLFINALNAMEDIF3;
			}
		}else{
			switch (difficulte){
				case FACILE:
					return JSONFINALNAMEDIF1;
				case NORMAL:
					return JSONFINALNAMEDIF2;
				case DIFFICILE:
					return JSONFINALNAMEDIF3;
			}
		}
		return null;
	}


}
