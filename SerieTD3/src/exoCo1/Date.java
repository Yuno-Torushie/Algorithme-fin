package exoCo1;

public class Date {
	private static final int ANNEE_MIN = 1582;
	private int jour;
	private int mois;
	private int annee;
	
	//TODO;.................
	
	public Date(int jour, int mois, int annee) throws DateException {
		if (annee < ANNEE_MIN) {
			throw new DateException("Annee incorrecte");
		}
		this.annee = annee;
		if (mois > 12 || mois <1) {
			throw new DateException("Mois incorrect");
		}
		this.mois = mois;
		if (jour < 1 || (jour > 31) || (jour > 30 /*&& mois == (4 || 6 || 9 || 11)*/) || (jour > 28 && mois == 2)) {
			throw new DateException("Jour incorrect");
		}
		this.jour = jour;
	}
	
	public void demain() {
		jour++;
					}
				
	private boolean bissextile() {
		return (annee % 4 == 0 || annee % 400 == 0); //TODO:........;
	}
	
	public int getJour() {
		return jour;
	}

	public int getMois() {
		return mois;
	}

	public int getAnnee() {
		return annee;
	}

	@Override
	public String toString() {
		String smois = "";
		//TODO.....
		return jour +"/"+ mois +"/"+ annee;
	}
}
