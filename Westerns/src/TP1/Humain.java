package TP1;

public class Humain {
	
	private static final String BOISSON_HUMAIN_DEFAUT = "l'eau";
	private String nom;
	private String boisson_favorite;	
	
	public Humain(String nom) {
		this(nom, BOISSON_HUMAIN_DEFAUT);
	}
	
	public Humain(String nom, String boisson) {
		this.nom=nom;
        this.boisson_favorite=boisson;
	}
	
	public void parler(String texte) {
		System.out.println("("+this.nom+") - "+texte+"\n");
	}
	
	public void sePresenter() {
		parler("Bonjour, je m'appelle "+nom+" et ma boisson favorite est "+boisson_favorite+".");
	}
	
	public void boire() {
		parler("Ah ! Un bon verre de "+boisson_favorite+" ! GLOUPS !");
	}
	
	public String quelEstTonNom() {
		return nom;
	}

	public String getBoissonFavorite() {
		return boisson_favorite;
	}
	
	
	


}
