package Partie5;

public class FabriqueDeCanards extends FabriqueDeCanardsAbstraite{

	@Override
	public Cancaneur creerColvert() {
		return(new Colvert());
	}

	@Override
	public Cancaneur creerMandarin() {
		return(new Mandarin());
	}

	@Override
	public Cancaneur creerAppelant() {
		return(new Appelant());
	}

	@Override
	public Cancaneur creerCanardsEnPlastique() {
		return(new CanardEnPlastique());
	}

}
