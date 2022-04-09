package Partie4;

public class FabriqueDeComptage extends FabriqueDeCanardsAbstraite{

	@Override
	public Cancaneur creerColvert() {
		return new CompteurDeCouacs(new Colvert());
	}

	@Override
	public Cancaneur creerMandarin() {
		return new CompteurDeCouacs(new Mandarin());
	}

}
