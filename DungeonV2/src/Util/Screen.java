package Util;

public class Screen {
	
	public void solution () {
		Console.affiche("Pour perdre au jeu très rapidement il suffit d'aller qu'au Nord.");
		Console.affiche("Pour faire TOUTE les salle du jeu, vous pouvez faire, Nord, Ouest, Sud, Nord, Ouest, Ouest, Est, Est, Est, Est, Sud, Est,");
		Console.affiche("Ouest, Nord, Ouest, Nord, Est, Est, Sud, Nord, Ouest, Ouest, Ouest, Ouest, Ouest, Est, Est, Puis que Nord. ");
		Console.affiche("Pour Ouvrir un coffre le plus rapidement possible: Nord, Ouest, Sud et Ouvrir le Coffre");
		Console.affiche("Pour Combattre un Monstre le plus rapidement possible: Nord, Ouest, Ouest puis Combattre ou Fuir");
		Console.affiche("Pour finir le jeu le plus rapidement: Nord, Ouest, Sud, Nord, Est, Nord, Ouest, Ouest, Ouest, Est, Est, Est, Puis que Nord.");
	}
	
	public void welcomeMessage() {
        Console.affiche("Bienvenue dans le Donjon");
        Console.affiche("Votre but est de sauvé la fameuse et magnifique Princesse Yuno qui à été emprisonée par le terrible méchant et diabolique Torushie.\n");
        }
		  
	public void goodEnding() {
        Console.afficheln("Félicitations ! Vous avez Libérés la princesse.\nVous pouvez désaprésent en faire ce que vous voulez.");
        Console.afficheln("FIN !");
    }
	
	public void badEnding() {
        Console.afficheln("Game Over ! Vous êtes un vrai cancre.");
    }
	  
	public void fight() {
        Console.info("\n Il y a un Monstre dans la salle.");
        Console.info("(F) Fuir ? (20% chance)");
        Console.info("(C) Combattre ?");
	}
	
	public void choix() {
        Console.info("\nQue choisissez-vous de faire ?");
	}
	
	public void goNorth() {
        Console.info("(N) Pour aller au NORD");
	}
	
	public void goSouth() {
        Console.info("(S) Pour aller au SUD");
	}
	
	public void goWest() {
        Console.info("(O) Pour aller à l'OUEST");
	}
	
	public void goEast() {
        Console.info("(E) Pour aller à l'EST");
	}
	
	public void free() {
        Console.info("(L) Pour libéré la Princesse.");
	}
	
	public void openChest() {
        Console.info("(P) Pour ouvrir le Coffre.");
	}

}
