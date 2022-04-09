package test;


import java.util.Scanner;


public class Test {
	
    static Scanner scanner = new Scanner(System.in);
    static int nbr = 0;

	public static void main(String[] args) {

		System.out.println("Donner une nombre");
		nbr = scanner.nextInt();
		
		System.out.println("le nombre est : "+nbr);
		
		for(int i=0;i<nbr;i++) {
			System.out.println("coucou");
		}
		
		
				
	}

}
