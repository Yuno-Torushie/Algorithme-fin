package exo2;

import java.util.ArrayList;
import java.util.List;

public class LesAnimaux {
	
	//Constantes
		
	
	//Attributs de classe
	private List<Animal> lesAnimaux;
	
	//Attributs d'objets


	//Constructeur
	public LesAnimaux() {
		super();
		lesAnimaux = new ArrayList<>();
	}
	
	public void ajouter(Animal unAnimal) {
		lesAnimaux.add(unAnimal);
	}
	
	//Getters/Setters


	//Redéfinitions

	@Override
	public String toString() {
		String res ="Voici les animaux de la liste :\n";
		
		for (Animal unAnimal: lesAnimaux) {
			res += "-t" + unAnimal +"\n";
		}
		
		return res;
	}
	
	public void cacophonie() {
		System.out.println("Tous les animaux se mettent a crier");
		
		for(Animal unAnimal : lesAnimaux) {
			unAnimal.crier();
		}
	}

	/*public void afficheNBPattes(int nbPattes) {
		System.out.println("Voici les animaux possédant "+nbPattes+" pattes : \n");
		for(Animal unAnimal : lesAnimaux) {
			System.out.println(unAnimal);
			if(unAnimal instanceof AnimalAvecPattes {
				AnimalAvecPattes unAnimalAvecPattes = (AnimalAvecPattes) unAnimal;}
			if(unAnimalAvecPattes unAnimal) {
				System.out.println(unAnimal);}
		}			
	}*/
}
