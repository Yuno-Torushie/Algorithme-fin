package TD3_Complexité;

public class ProduitPositif {
	
	public static int produit(int x, int y) {
		if (x==0 || y == 0) return 0;
		
		for(int k=0; k<x; k++) for(int j=0; j<y; j++) {
			// les 2 boucles for sont pour savoir si x et y sont positifs, car si ils ne le sont pas ça ne passe pas dans la boucle.
			for(int i=0; i<y;i++) {
				x=x-1;
				if (x==0) {
					return produit(y,x);
				}
			}
			if (y == 0) {}
			else return (x + produit(x, y - 1)); 
			
		}				
		return(0);
	}
}
