package Pile;

public class PileParTableau implements Pile {
	private int sommet;
	private int TAILLEMAX = 100;
	private Object [] tableau;
	
	//Constructeurs
	public PileParTableau() {
		sommet = -1;
		tableau = new Object[TAILLEMAX];
	}

	@Override
	public boolean pileVide() {
		// TODO Auto-generated method stub
		if (sommet  < 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean pilePleine() {
		// TODO Auto-generated method stub
		if (sommet ==(TAILLEMAX-1)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int longueur() {
		// TODO Auto-generated method stub
		return sommet+1;
	}

	@Override
	public Object sommet() {
		// TODO Auto-generated method stub
		int i=TAILLEMAX-1;
		while(i != 0) {
			i=i-1;
			return(tableau[i+1]);
		}
		return null;
	}

	@Override
	public void empiler(Object element) {
		// TODO Auto-generated method stub
		if (pilePleine()==false) {
			tableau[sommet+1]=element;
			sommet = sommet +1;
		}
	}

	@Override
	public Object depiler() {
		// TODO Auto-generated method stub
		Object element;
			if (pileVide()==true) {
				return "La pile est vide";
			}
			else {
				element = tableau[sommet];
				sommet = sommet -1;
				return element;
			}
	}

}
