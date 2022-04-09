package Partie4;

public class SimulateurDeCanards {

	public static void main(String[] args) {
		SimulateurDeCanards simulateur = new SimulateurDeCanards();
		FabriqueDeCanards fabriqueDeCanards = new FabriqueDeCanards();
		simulateur.simuler(fabriqueDeCanards);
	}
	
	public void simuler(FabriqueDeCanardsAbstraite fabriqueDeCanards) {
		Cancaneur colvert = fabriqueDeCanards.creerColvert();
		Cancaneur mandarin = fabriqueDeCanards.creerMandarin();
		
		System.out.println("\nSimulateur de canards");

		simuler(colvert);
		simuler(mandarin);

		System.out.println("Nous avons compté "+CompteurDeCouacs.getCouacs()+" couacs");
	}
	public void simuler(Cancaneur canard) {
		canard.cancaner();
	}

}
