package TD4_Complexité;

public class Poupée_Récursive {
	
	public static int PoupéeRec(int poids, int nbr){

		if(poids<=100){
			while(nbr != 0){
				poids = poids + poids*2;
				nbr= nbr - 1;
			}
			return PoupéeRec(poids, nbr);
		}
		else return PoupéeRec(poids/2, nbr+1);	
	}
}
