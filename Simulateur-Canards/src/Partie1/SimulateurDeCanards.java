package Partie1;

public class SimulateurDeCanards {

	public static void main(String[] args) {
		SimulateurDeCanards simulateur = new SimulateurDeCanards();
		simulateur.simuler();
	}
	public void simuler() {
		Cancaneur colvert = new Colvert();
		Cancaneur mandarin = new Mandarin();
		Cancaneur appelant = new Appelant();
		Cancaneur canardEnPlastique = new CanardEnPlastique();
		System.out.println("\nSimulateur de canards");
		simuler(colvert);
		simuler(mandarin);
		simuler(appelant);
		simuler(canardEnPlastique);
	}
	public void simuler(Cancaneur canard) {
		canard.cancaner();
	}

}
