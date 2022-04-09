package exo1;

public class Livre {

	//Constantes
	private static final String EDITEUR_DEFAUT = "NC";
	private static final int NB_PAGES_NON_RENSEIGNE = -1;
	
	//Attributs de CLASSE
	private static int numLivres = 0;
	
	//Attributs d'objets
	private String titre;
	private String auteur;
	private String editeur;
	private int nbPages;
	private int numero;
	
	//Constructeur
	public Livre(String titre, String auteur) {
		this(titre, auteur, EDITEUR_DEFAUT, NB_PAGES_NON_RENSEIGNE);
	}

	public Livre(String titre, String auteur, String editeur, int nbPages) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.nbPages = nbPages;
		numero = ++numLivres;
	}

	//Getters/Setters
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	//Redefinitions
	
	@Override
	public String toString() {
		
		//TODO arranger l'affichage 
		return "Livre [titre=" + titre + ", auteur=" + auteur + ", editeur=" + editeur + ", nbPages=" + nbPages + ", numero=" + numero + "]";
	}
}
