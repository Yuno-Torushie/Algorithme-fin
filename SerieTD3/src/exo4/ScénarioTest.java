package exo4;

public class ScénarioTest {

	private static final int NB_DE_CARTE_A_DISTRIBUER = 5;

	public static void main(String[] args) {
		
		Jeu2Carte leJeu = new Jeu2Carte();
		//System.out.println(leJeu);
		
		leJeu.brasser();
		//System.out.println(leJeu);
		
		MainJoueur mainJoueur1 = new MainJoueur("Joueur 1");
		MainJoueur mainJoueur2 = new MainJoueur("Joueur 2");
		
		for( int i=0; i<NB_DE_CARTE_A_DISTRIBUER; i++) {
			try {			
				mainJoueur1.recevoirCarte(leJeu.distribuerCarte());
				mainJoueur2.recevoirCarte(leJeu.distribuerCarte());
			} catch (PlusDeCarteException e) {
				System.err.println("Il n'y a plus de carte à distribuer !");
			}

		}
		System.out.println(mainJoueur1);
		System.out.println(mainJoueur2);
		
		System.out.println("La main de "
				+ mainJoueur1.getNom()
				+ " contient au moins une paire de : "
				+ mainJoueur1.getValeurPremierePairePresnete());
		
		System.out.println("La main de "
				+ mainJoueur2.getNom()
				+ " contient au moins une paire de : "
				+ mainJoueur2.getValeurPremierePairePresnete());
	}

}
