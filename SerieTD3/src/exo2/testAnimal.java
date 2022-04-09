package exo2;

public class testAnimal {

	public static void main(String[] args) {
		
		LesAnimaux mesAnimaux = new LesAnimaux();
		
		Chien leChien = new Chien("Labrador",40.0,1);
		Canard leCanard = new Canard("Mulard", 4.);
		Serpent leSerpent = new Serpent("Viper",4.,120,true);
		
		leChien.setNbPattes(3);
		
		mesAnimaux.ajouter(leCanard);
		mesAnimaux.ajouter(leChien);
		mesAnimaux.ajouter(leSerpent);
		
		
		System.out.println(mesAnimaux);
		
		//mesAnimaux.cacophonie();
		
		//mesAnimaux.afficheNBPattes(3);
	}

}
