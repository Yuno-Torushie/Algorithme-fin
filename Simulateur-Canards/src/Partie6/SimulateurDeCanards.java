package Partie6;

public class SimulateurDeCanards {

	public static void main(String[] args) {
		SimulateurDeCanards simulateur = new SimulateurDeCanards();
		FabriqueDeCanards fabriqueDeCanards = new FabriqueDeCanards();
		simulateur.simuler(fabriqueDeCanards);
	}
	
	public void simuler(FabriqueDeCanardsAbstraite fabriqueDeCanards) {
		Cancaneur colvert = fabriqueDeCanards.creerColvert();
//		Cancaneur mandarin = fabriqueDeCanards.creerMandarin();
		Cancaneur appelant = fabriqueDeCanards.creerAppelant();
//		System.out.println("\nSimulateur de canards");
//		simuler(colvert);
//		simuler(mandarin);
//		System.out.println("Nous avons compté "+CompteurDeCouacs.getCouacs()+" couacs");
		
//		Troupe troupeDeCanards = new Troupe();
//		troupeDeCanards.add(mandarin);
//		troupeDeCanards.add(appelant);
//		
//		Troupe troupeDeColverts = new Troupe();
//		Cancaneur colvert2 = new Colvert();
//		Cancaneur colvert3 = new Colvert();
//		troupeDeColverts.add(colvert2);
//		troupeDeColverts.add(colvert3);
		
//		troupeDeCanards.add(troupeDeColverts);
//		System.out.println("\nSimulateur de canards : Toute la troupe");
//		simuler(troupeDeCanards);
//		System.out.println("\nSimulateur de canards : Troupe de colverts");
//		simuler(troupeDeColverts);
		
		Cancanologue leCancanologue = new Cancanologue();
		colvert.enregistrerObservateur(leCancanologue);
		simuler(colvert);
		
	}
	
	public void simuler(Cancaneur canard) {
		canard.cancaner();
	}

}
