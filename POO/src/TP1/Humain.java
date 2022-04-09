package TP1;

public class Humain {
	
	private String Nom;
	private static String boissonFavorite = "l'eau";
	
	
	public Humain(String nom) {
		super();
		Nom = nom;
	}
	
	public Humain(String nom, String boisson) {
		super();
		Nom = nom;
		boissonFavorite = boisson;
	}
	
	public void parler(String nom) {
		Nom = nom;
		System.out.println("("+Nom+") -");
		if (Barman) {
			reutrn "Coco";
		}
	}
	
	public void sePresenter() {
		System.out.println("Bonjour, je m'appelle "+quelEstTonNom()+" et j'adore boire de "+boissonFavorite+".");
		if(Dame) {
			
		}
		if(Brigand) {
			System.out.println("J'ai l'air "+look+" et j'ai déjà kidnappé "+nbDamesenlevees+" dames\n");
			System.out.println("Ma tête est mise à prix "+recompense+" $ !\n");
		}
		if(Sherif) {
			System.out.println("J'ai déjà coffrer "+nbBrigandcoffre+" Brigands !\n");
		}
		if(Barman) {
			System.out.println("Je tiens un bar du nom de "+nomBar+" !");
		}
		else {
			
		}
	}
	
	public void boire() {
		System.out.println("Ah ! Un bon verre de "+boissonFavorite+" ! GLOUPS !");
	}
	
	public String quelEstTonNom() {
		if(Dame) {
			return ("Miss "+Nom);
		}
		if(Brigand) {
			return (Nom+" le "+look);
		}
		if(Sherif) {
			return("Sherif "+Nom);
		}
		else {
			return Nom;
		}
	}

	public String getBoissonFavorite() {
		return boissonFavorite;
	}
	
	
	


}
