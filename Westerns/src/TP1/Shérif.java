package TP1;

public class Sh�rif extends Cowboy{
	
	private static String ADJECTIF_SHERIF_DEFAUT = "honn�te";
	private int nbBrigandcoffre = 0;
	
	public Sh�rif(String nom) {
		super(nom);
	}
	
	public void coffrer(Brigand b) {
		System.out.println("Au nom de la loi, je vous arr�te !");
	}

	public void rechercher(Brigand b) {
		System.out.println(this.quelEstTonNom()+" a placard� une affiche dans toute la ville");
		System.out.println("OYEZ OYEZ BRAVE GENS !! "+b.recompense+" $ � qui arr�tera "+b.quelEstTonNom()+" mort ou vif !!");
	}
	
	public void sePresenter() {
		parler("J'ai d�j� coffrer "+nbBrigandcoffre+" Brigands !");
	}
	
}
