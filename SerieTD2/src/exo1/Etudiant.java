package exo1;

public class Etudiant extends Personne {

	private int numero;
	
	public Etudiant(String nom, int numero) {
		super(nom);
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public String getNom() {
		return "(ETU) " + super.getNom();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		
		if(!super.equals(obj)) return false; // si pas egale en tant que 'Personne' alors faux
		
		//si les 2 objets sont déjà égaux en tant que 'Personne' on voit plus loin en tant que 'etudiant'
		
		if(!(obj instanceof Etudiant)) return false;
		
		Etudiant other = (Etudiant) obj;
		
		if(numero != other.numero) return false;
		
		return true;
	}
}
