package TP1;

public class Brigand extends Humain {

	public String look;
	public static int nbDamesEnlevees = 0;
	public static int recompense= 100;
	public static boolean enPrison = false;
	static String boissonFavorite = "tord-boyaux";
	
	public Brigand(String looks) {
		look = looks;
	}
	
	public Brigand(String nom, String boisson, String looks) {
		super(nom, boisson);
		look = looks;
	}
	
	public void kidnapper(Dame) {
		System.out.println("Ah ah  !  "+Dame.quelEstTonNom+",  tu  es  mienne  desormais  !");
		nbDamesenlevees++;
		libre = false;
		recompense = recompense + 100;
	}
	public void estEmprisonnerpar(Cowboy) {
		System.out.println("Damned, je suis fait ! "+Cowboy.quelestTonNom+", tu m’as eu !");
		recompense = 0;
	}

	public int setRecompense() {
		return recompense;
	}

}
