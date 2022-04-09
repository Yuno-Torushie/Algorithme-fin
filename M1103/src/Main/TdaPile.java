package Main;

import Pile.Pile;
import Pile.PileParTableau;

public class TdaPile {

	public static void main(String[] args) {

		Pile a = new PileParTableau();
		for(int i=0; i<5; i++) {
			a.empiler(Math.random()*99);
		}
		for(int i=0; i<5; i++) {
			System.out.println("objet dépiler : "+a.depiler());
		}

		
	}

}
