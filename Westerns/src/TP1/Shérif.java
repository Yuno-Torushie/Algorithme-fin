package TP1;

public class Shérif extends Cowboy{
	
	private static String ADJECTIF_SHERIF_DEFAUT = "honnête";
	private int nbBrigandcoffre = 0;
	
	public Shérif(String nom) {
		super(nom);
	}
	
	public void coffrer(Brigand b) {
		System.out.println("Au nom de la loi, je vous arrête !");
	}

	public void rechercher(Brigand b) {
		System.out.println(this.quelEstTonNom()+" a placardé une affiche dans toute la ville");
		System.out.println("OYEZ OYEZ BRAVE GENS !! "+b.recompense+" $ à qui arrêtera "+b.quelEstTonNom()+" mort ou vif !!");
	}
	
	public void sePresenter() {
		parler("J'ai déjà coffrer "+nbBrigandcoffre+" Brigands !");
	}
	
}
