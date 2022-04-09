package exo4;

public class Carte {
	
	private Couleur couleur;
	private	Valeur valeur;
	
	public Carte(Couleur couleur, Valeur valeur) {
		super();
		this.couleur = couleur;
		this.valeur = valeur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public Valeur getValeur() {
		return valeur;
	}

	@Override
	public String toString() {
		return "" + valeur.toString() +" de " + couleur;
	}
	
	

	
}
