package exo2;

public abstract class Animal {
	
	//Attributs
	private String race;
	private double poids;
	
	//Constructeur
	public Animal(String race, double poids) {
		super();
		this.race = race;
		this.poids = poids;
	}
	
	//Getters/Setters
	public String getRace() {
		return race;
	}

	public double getPoids() {
		return poids;
	}

	//Redéfinitions
	@Override
	public String toString() {
		return (race+ ", "+poids+" kg" );
	}
	public void crier() {	
	}
}