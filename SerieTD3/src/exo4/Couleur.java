package exo4;

public enum Couleur {

	PIQUE, COEUR, CARREAU, TREFLE;
	
	@Override
	public String toString() {
		switch(this) {
		case PIQUE: return "Pique";
		case COEUR: return "Coeur";
		case CARREAU: return "Carreau";
		case TREFLE: return "Trefle";
		default: return "y'a un pb !";
		}
	}
}
