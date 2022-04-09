package exo2;

public abstract class AnimalAvecPattes extends Animal{
	
	//Attributs
	private int nbPattes;


	//Constructeur
	public AnimalAvecPattes(String race, double poids, int nbPattes) {
		super(race, poids);
		this.nbPattes = nbPattes;
	}

	//Getters/Setters
	public int getNbPattes() {
		return nbPattes;
	}

	public void setNbPattes(int nbPattes) {
		this.nbPattes = nbPattes;
	}

	//Redéfinitions
	@Override
	public String toString() {
		return (super.toString()+", "+nbPattes+" pattes" );
	}	

}
