package Partie3;

public class CompteurDeCouacs implements Cancaneur {
	private Cancaneur canards;
	private static int nombreDeCouacs;
	
	public CompteurDeCouacs(Cancaneur canards) {
		this.canards = canards;
	}
	
	public void cancaner() {
		canards.cancaner();
		nombreDeCouacs++;
	}
	
	public static int getCouacs() {
		return nombreDeCouacs;
	}

}
