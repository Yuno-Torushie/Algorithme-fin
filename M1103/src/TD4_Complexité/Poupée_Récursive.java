package TD4_Complexit�;

public class Poup�e_R�cursive {
	
	public static int Poup�eRec(int poids, int nbr){

		if(poids<=100){
			while(nbr != 0){
				poids = poids + poids*2;
				nbr= nbr - 1;
			}
			return Poup�eRec(poids, nbr);
		}
		else return Poup�eRec(poids/2, nbr+1);	
	}
}
