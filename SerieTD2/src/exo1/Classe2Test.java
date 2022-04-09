package exo1;

public class Classe2Test {

	public static void main(String[] args) {
		
		Personne unePersonne = new Personne("Anonyme");
				
		Etudiant unEtudiant = new Etudiant("Anonyme",42);
		//unEtudiant.SetNumero(7);
		//System.out.println(unEtudiant);
	
		//Etudiant unAutreEtudiant = null;
		//if(unEtudiant instanceof Etudiant) {unAutreEtudiant = (Etudiant) unEtudiant;}
		//System.out.println(unAutreEtudiant);
	
		Personne uneAutrePersonne = new Personne("Anonyme");
		//unAutreEtudiant = (Etudiant) uneAutrePersonne; //down casting explicite non protégé par instanceof
	
		System.out.println(unePersonne.equals(uneAutrePersonne)?"egales":"différentes");
	
		Etudiant unAutreEtudiant = new Etudiant("Anonyme", 15);
		System.out.println(unAutreEtudiant.equals(unEtudiant)?"egales":"différentes");
		unAutreEtudiant.setNumero(42);
		System.out.println(unAutreEtudiant.equals(unEtudiant)?"egales":"différentes");
	}

}
