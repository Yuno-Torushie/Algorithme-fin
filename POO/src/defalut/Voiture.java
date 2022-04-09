package defalut;

public class Voiture {
	
	private final int NB_ROUES = 4;
	private static int nbVoitures = 0;
	private String marque;
	
	public Voiture (String uneMarque) {
	
		marque = uneMarque;
		nbVoitures++;
	
	}
	
	public void chgMarque (String marque) {
		this.marque = marque;
	}

	public static int combienDeVoitures() {
		return nbVoitures;
	}
}
