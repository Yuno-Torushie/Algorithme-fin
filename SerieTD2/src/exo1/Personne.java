package exo1;

public class Personne {

	//attributs d'objets
	
	private String nom;
	
	//Constructeurs
	
	public Personne(String nom) {
		super();
		this.nom = nom;
	}

	//getters/setters
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return getNom();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) return true;
		
		if(obj == null) return false;
		
		if(!(obj instanceof Personne)) return false;
		
		Personne other = (Personne) obj;
		
		if(nom == null) {
			if (other.nom != null) return false;
		} 
		else if(nom != other.nom) return false;
		
		return true;
	}
}
