package util;

import java.util.*;

public class Interaction
{
    private static Set<Character> keys;
    private static Scanner entree;
    
    static {
        Interaction.keys = new HashSet<Character>();
        Interaction.entree = new Scanner(System.in);
    }
    
    public static String lireString() {
        return Interaction.entree.nextLine();
    }
    
    public static void resetKeys() {
        Interaction.keys = new HashSet<Character>();
    }
    
    public static void acceptKey(final char c) {
        Interaction.keys.add(new Character(c));
    }
    
    public static char readAction() {
        boolean out = false;
        char c;
        do {
            Console.affiche(" => ");
            c = Interaction.entree.next(".*").charAt(0);
            for (final Character car : Interaction.keys) {
                if (Character.toUpperCase(car) == Character.toUpperCase(c)) {
                    out = true;
                }
            }
        } while (!out);
        Interaction.entree.nextLine();
        return c;
    }
    
    public static void pause(final int sec) {
        try {
            Thread.sleep(sec * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static int randomPrct() {
        return (int)(Math.random() * 100.0);
    }
}