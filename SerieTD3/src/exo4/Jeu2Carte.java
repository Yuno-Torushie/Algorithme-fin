package exo4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Jeu2Carte {
	
	private List<Carte> Jeu2Carte;
	
	public Jeu2Carte() {
		super();
		//j'ajoute les 52 cartes
		Jeu2Carte = new LinkedList<>();
		
		for(Couleur couleur: Couleur.values()) {
			for(Valeur valeur: Valeur.values()) {
				Jeu2Carte.add(new Carte(couleur,valeur));
			}
		}
		
	}
	
	public String toString() {
		String res= "Voici les " + Jeu2Carte.size() + " cartes contenues dans le jeu \n";
		for (Carte carte: Jeu2Carte) {
			res += " - "+ carte + "\n";
		}
		return	res;
	}

	public void brasser() {
		Collections.shuffle(Jeu2Carte);
	}
	
	public Carte distribuerCarte() throws PlusDeCarteException{
	if(Jeu2Carte.isEmpty()) {
		throw new PlusDeCarteException();
	}
		return Jeu2Carte.remove(Jeu2Carte.size()-1);
	}
	
	

}
