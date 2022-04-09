package Util;

import java.util.*;

public class Interaction {


    private static Set<Character> keys = new HashSet<Character>();
    private static Scanner entree = new Scanner(System.in);
    
    public static String lireString() {
        return Interaction.entree.nextLine();
    }
    
    public static char readAction() {
        boolean out = false;
        char c;
        do {
            Console.affiche(" => ");
            c = Interaction.entree.next(".*").charAt(0);
            for (Character car : Interaction.keys) {
                if (Character.toUpperCase(car) == Character.toUpperCase(c)) {
                    out = true;
                }
            }
        } while (!out);
        Interaction.entree.nextLine();
        return c;
    }
    
    public static void resetKeys() {
        Interaction.keys = new HashSet<Character>();
    }
    
    public static void acceptKey(final char c) {
        Interaction.keys.add(Character.valueOf(c));
    }
    
    public static int randomPrct() {
        return (int)(Math.random() * 100.0);
    }
    
    public static void latency(int sec) {
        try {
            Thread.sleep(sec * 250);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}