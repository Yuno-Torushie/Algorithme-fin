package tp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class main {
	
	//Mise en place des variables.
	static Scanner scanner = new Scanner(System.in);
    static String Texte;
    static String TexteModel�;
    static Deque<String> File = new ArrayDeque<>();
    static Deque<String> Pile = new ArrayDeque<>();
    static String Charact�re;
    static String CharPile;
    static String CharFile;
    static int n = 0;
	
    public static void main(String[] args) {
    	
       //On demande d'entr� un mot ou un phrase
		System.out.println("Entrez une un mot ou un phrase, sans caract�re sp�ciaux");
		System.out.println("-------------------------------------------------------");
		Texte = scanner.nextLine();
		
		/*
		//On affiche le r�sultat.
		System.out.println(Texte);
		*/
		
		//On supprime les espaces de d�but et de fin et on met tout en minuscule.
		TexteModel� = Texte.replaceAll("\\s", "");
		TexteModel� = TexteModel�.toLowerCase();
		
		/*
		//On affiche le r�sultat.
    	System.out.println(TexteModel�);
    	*/
    	
    	//On parcourt la chaine de caract�res et on met chaque caract�re � la fois dans une pile et dans une file.
    	for(int i=0; i<TexteModel�.length();i++) {
    		Charact�re = TexteModel�.substring(i,i+1);
    		Pile.addFirst(Charact�re);
    		File.offerLast(Charact�re);
    	}
    	
    	/*
    	//Pour v�rifier que tout se rempli correctement.
    	System.out.println(Pile);
    	System.out.println(File);
    	*/
    	
    	//V�rification 
    	for(int i=0; i<TexteModel�.length();i++) {
    		CharPile= Pile.remove();
    		CharFile= File.remove();
    		if(CharPile != CharFile) n ++;
    		//System.out.println(CharPile+"_"+CharFile+"-> "+n);
    	}
    	//Petit probl�me j'ai l'impression qu'il souvegarde la lettre avec son emplacement, ce qui fait que k != k est possible.
    	
    	//Affiche si le texte est un palindrome ou pas
		System.out.println("-------------------------------------------------------");
		if(n > 0)System.out.println("Le texte saisie n'est pas un palindrome");
		else System.out.println("Le texte saisie est un palindrome");
    }
}

