package defalut;

public class Surcharge {
	
	private static final String TEXTE_PAR_DEFAUT = "Ceci est un texte par d�fault";
	
	public void Affichage() {	
		System.out.println(TEXTE_PAR_DEFAUT);

	}
	
	public void Affichage(String Texte) {
		System.out.println(Texte);
	}
	
	public void Affichage(int nb, String Texte) {
		for (int i=0; i < nb; i++) {
			Affichage(Texte);
		}
	}
}
