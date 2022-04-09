package TD4_Complexité;

import java.util.Random;
import java.util.Scanner;



public class NombreSecret {
	
	static int secret=1;
	
	public static void main(String[] args) {
		Random r=new Random();	
		secret=r.nextInt(100);
		Scanner scanner = new Scanner(System.in);
		
		int x = 0;
		
		while(x!=secret) {
			System.out.println("Entrez un nombre");
			x = scanner.nextInt();
			if(x==secret){
				System.out.println("Bravo vous avez trouvé le nombre secret.");
			}
			
			else if(x<secret) {
				System.out.println("Trop petit");
				System.out.println("------------------------------------");
			}
			else if(x>secret) {
				System.out.println("Trop grand");
				System.out.println("------------------------------------");
			}
		}
		

	}

}
