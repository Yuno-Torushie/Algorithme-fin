package Partie4;

public class FabriqueDeCanards extends FabriqueDeCanardsAbstraite{

	@Override
	public Cancaneur creerColvert() {
		return(new Colvert());
	}

	@Override
	public Cancaneur creerMandarin() {
		return(new Mandarin());
	}

}
