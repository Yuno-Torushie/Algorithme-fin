package exo_2.etude;

public class Etudiant {
	
	//atributs de classe
	private static final String ANNEE = "2017";
	private static int cptEtud = 0;
	
	
	//attributs d'objets
	private String numero;
	private String nom;
	private String prenom;
	private String departement;
	private int nbAbsences;
	
	//Constructeurs
	public Etudiant() {
		this("NC","NC");
		nbAbsences = 0;
	}
	
	public Etudiant(String nom, String prenom) {
		this(nom,prenom, "NC");
	}

	public Etudiant(String nom, String prenom, String departement) {
		super();
		this.numero = ANNEE +"-" + (++cptEtud);
		this.nom = nom;
		this.prenom = prenom;
		this.departement = departement;
		nbAbsences = 0;
	}
	
	//autres méthodes

	public boolean egaleA(Etudiant autreEtudiant) {
		if (!getNom().equals(autreEtudiant.getNom()))
			return false;
		if (!getPrenom().equals(autreEtudiant.getPrenom()))
			return false;	
		if (!getDepartement().equals(autreEtudiant.getDepartement()))
			return false;
		if (getNbAbsences() != autreEtudiant.getNbAbsences())
			return false;
		return true;
	}
	
	public void affichageInformation() {
		System.out.println(this);
	}
	
	public void modifierNom(String nouveauNom) {
		nom = nouveauNom;
	}
	
	public void ajouterAbsence() {
		nbAbsences++;
	}
	
	public void enleverAbsence() {
		nbAbsences--;
	}
	
	public String toString() {
		return ("("+numero+")"+nom+" "+prenom+" dpt "+departement+" ["+nbAbsences+" abs.]");
	}
	
	//accessoires
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public int getNbAbsences() {
		return nbAbsences;
	}

	public void setNbAbsences(int nbAbsences) {
		this.nbAbsences = nbAbsences;
	}


}
