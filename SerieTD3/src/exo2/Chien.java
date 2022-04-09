package exo2;

public class Chien extends AnimalAvecPattes {
	
	//Constantes
	private static final int NB_PATTES_DEFAUT = 4;
	
	//Attributs de classe
	
	
	//Attributs d'objets
	private int categorie;
	
	//Constructeur
	public Chien(String race, double poids, int categorie) {
		super(race, poids, NB_PATTES_DEFAUT);
		this.categorie = categorie;
	}
	
	//Getters/Setters
	public int getCategorie() {
		return categorie;
	}

	//Redéfinitions
	
	@Override
	public String toString() {
		return (super.toString()+", categorie"+categorie);
	}

	public void crier() {	
	}
}
