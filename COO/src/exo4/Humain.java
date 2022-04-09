package exo4;

public class Humain {
	public String nom;
	public String prenom;
	public int pointsdeVie; // de 0 à 100
	public int forceFrappe; // entre 1 et 10
	
	public Humain(String pnom, String pprenom, int pforceFrappe) {
		//initialisation des attributs
		nom = pnom;
		prenom = pprenom;
		pointsdeVie = 100;
		forceFrappe = pforceFrappe;
	}
	
	void sebattre(Humain adversaire) {
		//si notre force de frappe  et plus grande qye celle de l'adversaire alors on lui inflige des dégats, sinon c'est l'inverse
		if(forceFrappe > adversaire.forceFrappe) {
			adversaire.pointsdeVie = adversaire.pointsdeVie - forceFrappe;
		}
		else {
			pointsdeVie = pointsdeVie - adversaire.forceFrappe;
		}
	}

}

