package exo4;

import java.util.HashSet;
import java.util.Set;

public class MainJoueur {

	private String nom;
	private Set<Carte> lesCartes;	
	
	public MainJoueur(String nom) {
		super();
		this.nom = nom;
		lesCartes = new HashSet<>();
	}

	public void recevoirCarte(Carte nouvelleCarte) {
		lesCartes.add(nouvelleCarte);
	}
	
	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		StringBuilder res= new StringBuilder("Cartes dans la main de "+ nom +" :\n");
		for (Carte carte: lesCartes) {
			res.append(" - "+ carte + "\n");
		}
		return	res.toString();
	}

	public Valeur getValeurPremierePairePresnete() {
		for(Carte uneCarte : lesCartes ) {
			for (Carte autreCarte : lesCartes) {
				if (uneCarte != autreCarte && uneCarte.getValeur().equals(autreCarte.getValeur())){
                    return autreCarte.getValeur();
                }
			}
		}
		return null;
	}

}
