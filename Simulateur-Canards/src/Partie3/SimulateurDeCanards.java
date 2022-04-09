package Partie3;

public class SimulateurDeCanards {

	public static void main(String[] args) {
		SimulateurDeCanards simulateur = new SimulateurDeCanards();
		simulateur.simuler();
	}
	public void simuler() {
		Cancaneur colvert = new CompteurDeCouacs(new Colvert());
		Cancaneur mandarin = new CompteurDeCouacs(new Mandarin());
		Cancaneur appelant = new CompteurDeCouacs(new Appelant());
		Cancaneur canardEnPlastique = new CompteurDeCouacs(new CanardEnPlastique());
		Cancaneur canardOie = new CompteurDeCouacs(new AdaptateurDOie(new Oie()));
		System.out.println("\nSimulateur de canards");
		simuler(colvert);
		simuler(mandarin);
		simuler(appelant);
		simuler(canardEnPlastique);
		simuler(canardOie);
		System.out.println("Nous avons compté "+CompteurDeCouacs.getCouacs()+" couacs");
	}
	public void simuler(Cancaneur canard) {
		canard.cancaner();
	}

}
