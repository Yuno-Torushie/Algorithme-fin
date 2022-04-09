package Partie2;

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
		Cancaneur canardOie = new AdaptateurDOie(new Oie());
		System.out.println("\nSimulateur de canards");
		simuler(colvert);
		simuler(mandarin);
		simuler(appelant);
		simuler(canardEnPlastique);
		simuler(canardOie);
	}
	public void simuler(Cancaneur canard) {
		canard.cancaner();
	}

}
