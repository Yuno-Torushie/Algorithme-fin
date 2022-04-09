package util;

public class Console
{
    public static void info(final String s) {
        System.out.println("\t" + s);
    }
    
    public static void affiche(final String s) {
        System.out.println(s);
        Interaction.pause(1);
    }
    
    public static void afficheln(final String s) {
        affiche("\n" + s);
    }
}