package exo4;

public class JeuDeCombat {
	//combatants du jeu
	public Humain martin;
	public SuperHero jean;
	public SuperHero tatiana;
	
	//pouvoirs
	public Pouvoir pouvoirFreez;
	public Pouvoir pouvoirFeu;
	public Pouvoir pouvoirPoing;
	public Pouvoir pouvoirHypnose;
	
	public JeuDeCombat() {
		//initialisation des attributs
		pouvoirFreez = new Pouvoir("Freez","congelé les adversaire", 4);
		pouvoirFeu = new Pouvoir("Feu","brule les adversaire", 4);
		pouvoirPoing = new Pouvoir("Poing","degomme les adversaire", 2);
		pouvoirHypnose = new Pouvoir("Hypnose","endore les adversaire", 1);
	
		Pouvoir[] pouvoirsDeTornade= {pouvoirFeu,pouvoirFreez,pouvoirPoing};
		Pouvoir[] pouvoirsDeFantask= {pouvoirFeu,pouvoirHypnose};
		
		martin = new Humain("Strom","Martin",10);
		jean = new SuperHero("Dupont","Jean",2,"Tornade",pouvoirsDeTornade);
		tatiana= new SuperHero("Larvin","Tatiana",3,"Fantask",pouvoirsDeFantask);
		
		//combats
		martin.sebattre(tatiana);
		jean.sebattre(tatiana);
	}
	
}
