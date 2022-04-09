package exo2;

public class AnimalSansPatte extends Animal {
	
	//Attributs
	private double longueur;

	//Constructeur
	public AnimalSansPatte(String race, double longueur, double poids) {
		super(race, poids);
		this.longueur = longueur;
	}
	
	//Getters/Setters
	public double getLongueur() {
		return longueur;
	}

	//Redéfinitions
	@Override
	public String toString() {
		return (super.toString()+", "+longueur+" cm" );
	}
}
