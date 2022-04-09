package exo_2;

import exo_2.etude.Etudiant;

public class GererLesEtudiants {

	public static void main(String[] args) {
		
		Etudiant etudiant1 = new Etudiant();
		// ne compile plus d�s qu'on ajoute un constructeur explicite
		//compile a nouveau lorsque l'on ajoute un constructeur explicite SANS param�tre
		//System.out.println(etudiant1); // appel implicite � toString
		
		System.out.println(etudiant1.getNbAbsences());
		
		//etudiant1.affichageInformation();
		etudiant1.ajouterAbsence();
		etudiant1.affichageInformation();

		
		Etudiant etudiant2 = new Etudiant("Dubois","Jean");
		Etudiant etudiant3 = new Etudiant("Durand","Guillaume","INFO");
		etudiant2.affichageInformation();
		etudiant3.affichageInformation();
		
		Etudiant etudiant4 = new Etudiant("Dubois","Jean");
		
		System.out.println(etudiant2.egaleA(etudiant4)?"Ils sont �gaux":"Ils ne sont pas �gaux");
	}

}
