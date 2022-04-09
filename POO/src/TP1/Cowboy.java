package TP1;

public class Cowboy extends Humain{
	
	public static int popularite = 0;
	public static String adjectif = "vaillant";
	static String boissonFavorite = "whisky";
	
	public Cowboy (String adjectifs) {
		adjectif = adjectifs;
	}
	
	public Cowboy (String Nom, String boissonFavorite, String adjectifs) {
		super(Nom, boissonFavorite);
		adjectif = adjectifs;
	}
	
	public liberer(Dame) {
		if (nbDamesEnlevees =! 0) {
			while (nbDamesEnlevees=! 0) {
				libre = true;
				popularite++;
				nbDamesEnleves--;
			}
		}
	}
	
	public void tirer(Brigand) {
		System.out.println("Le "+adjectif+Nom+"tire sur "+Nom+".  PAN  !\n"+"Prend  ça,  rascal  !");
		enPrison = true;
	}

}
