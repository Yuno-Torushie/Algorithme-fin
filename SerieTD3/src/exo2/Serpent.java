package exo2;

public class Serpent extends AnimalSansPatte{
	
	//Constantes
	public static final boolean VENIMEUX = true;
	public static final boolean PAS_VENIMEUX = false;
	
	//Attributs de classe
	
	
	//Attributs d'objets
	public boolean venimeux;


	//Constructeur
	public Serpent(String race, double poids, double longueur, boolean venimeux) {
		super(race, poids, longueur);
		this.venimeux = venimeux;
	}

	//Getters/Setters
	public boolean isVenimeux() {
		return venimeux;
	}

	//Redéfinitions
	
	@Override
	public String toString() {
		return (super.toString()+", venimeux "+venimeux);
	}
	
	public void crier() {
		
	}
}
