package tp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class main {
	
	//Mise en place des variables.
	static Scanner scanner = new Scanner(System.in);
    static String Texte;
    static String TexteModelé;
    static Deque<String> File = new ArrayDeque<>();
    static Deque<String> Pile = new ArrayDeque<>();
    static String Charactère;
    static String CharPile;
    static String CharFile;
    static int n = 0;
	
    public static void main(String[] args) {
    	
       //On demande d'entré un mot ou un phrase
		System.out.println("Entrez une un mot ou un phrase, sans caractère spéciaux");
		System.out.println("-------------------------------------------------------");
		Texte = scanner.nextLine();
		
		/*
		//On affiche le résultat.
		System.out.println(Texte);
		*/
		
		//On supprime les espaces de début et de fin et on met tout en minuscule.
		TexteModelé = Texte.replaceAll("\\s", "");
		TexteModelé = TexteModelé.toLowerCase();
		
		/*
		//On affiche le résultat.
    	System.out.println(TexteModelé);
    	*/
    	
    	//On parcourt la chaine de caractères et on met chaque caractère à la fois dans une pile et dans une file.
    	for(int i=0; i<TexteModelé.length();i++) {
    		Charactère = TexteModelé.substring(i,i+1);
    		Pile.addFirst(Charactère);
    		File.offerLast(Charactère);
    	}
    	
    	/*
    	//Pour vérifier que tout se rempli correctement.
    	System.out.println(Pile);
    	System.out.println(File);
    	*/
    	
    	//Vérification 
    	for(int i=0; i<TexteModelé.length();i++) {
    		CharPile= Pile.remove();
    		CharFile= File.remove();
    		if(CharPile != CharFile) n ++;
    		//System.out.println(CharPile+"_"+CharFile+"-> "+n);
    	}
    	//Petit problème j'ai l'impression qu'il souvegarde la lettre avec son emplacement, ce qui fait que k != k est possible.
    	
    	//Affiche si le texte est un palindrome ou pas
		System.out.println("-------------------------------------------------------");
		if(n > 0)System.out.println("Le texte saisie n'est pas un palindrome");
		else System.out.println("Le texte saisie est un palindrome");
    }
}

