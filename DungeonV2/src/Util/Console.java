package Util;

public class Console {

	public static void info(final String s) {
	    System.out.println("\t" + s + "\n");
	}
	
	public static void affiche(final String s) {
	    System.out.println(s);
        Interaction.latency(1);
	}
	
	public static void afficheln(final String s) {
	    affiche("\n" + s);
	}
}
