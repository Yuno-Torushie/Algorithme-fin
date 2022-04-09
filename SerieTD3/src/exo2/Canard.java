package exo2;

public class Canard extends AnimalAvecPattes {
	
	//Constantes
	private static final int NB_PATTES_DEFAUT = 2;
	
	//Attributs de classe
	
	
	//Attributs d'objets


	//Constructeur
	public Canard(String race, double poids) {
		super(race, poids, NB_PATTES_DEFAUT);
	}


	
	//Getters/Setters


	//Redéfinitions

	@Override
	public String toString() {
		return (super.toString()+", Nombre de pattes "+NB_PATTES_DEFAUT);
	}
	
	public void crier() {	
	}
}
