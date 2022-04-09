package optiChainesProd.optimisateur;

import java.util.ArrayList;
import java.util.LinkedList;

import optiChainesProd.atelier.Atelier;

public class OptimisateurAtelierCorrec implements OptimisateurAtelier{	
	@Override
	public ResultatOptimisation optimiserAtelier(Atelier atelier) {
		//LES Indices de chaines précédentes dans un tableau 2 dim. de taille 2x(longueurChaine-1)
		//A la chaine 0,Au poste d'indice 4, si je suis dans le melleurs cheemin, j'étais à la 
		//chaine d'indice 1, au poste précédent : tab[0,4] = 1
		final int[][] idxChainePrec = new int[2][atelier.getLongueurChaines() - 1];
		//TEMPS OPTIMAUX AU POSTE 
		// f_0(0) == e0 + a_0,0
		long tempsOptiC0 = atelier.getChaine(0).getTempsEntree()
				+ atelier.getChaine(0).getPoste(0).getTempsTraitement();
		// f_1(0) == e1 + a_0,1
		long tempsOptiC1 = atelier.getChaine(1).getTempsEntree()
				+ atelier.getChaine(1).getPoste(0).getTempsTraitement();
		//TEMPS OPTIMAUX DES POSTE 1 à longueurChaine -1
		for (int j =1; j<atelier.getLongueurChaines()-1; j++) {
			// f_0(j) == min( f_0(j-1), f_1(j-1) + tc_1, j-1 ) + a_0,j
			long nouvTempsOptiC0;
			if (tempsOptiC0 < tempsOptiC1 + atelier.getTempsChangement(1, 0, j-1)) {
				nouvTempsOptiC0 = tempsOptiC0 + atelier.getChaine(0).getPoste(j).getTempsTraitement();
				idxChainePrec[0][j-1] = 0;
			} else {
				nouvTempsOptiC0 = tempsOptiC1 + atelier.getTempsChangement(1, 0, j-1) 
					+ atelier.getChaine(0).getPoste(j).getTempsTraitement();
				idxChainePrec[0][j-1] = 1;
			}
			
			// f_1(j) == min( f_1(j-1), f_0(j-1) + tc_0, j-1 ) + a_1,j
			if (tempsOptiC1 < tempsOptiC0 + atelier.getTempsChangement(0, 1, j-1)) {
				tempsOptiC1 = tempsOptiC1 + atelier.getChaine(1).getPoste(j).getTempsTraitement();
				idxChainePrec[1][j-1] = 1;
			} else {
				tempsOptiC1 = tempsOptiC0 + atelier.getTempsChangement(0, 1, j-1) 
					+ atelier.getChaine(1).getPoste(j).getTempsTraitement();
				idxChainePrec[1][j-1] = 1;
			}
			tempsOptiC0 = nouvTempsOptiC0;
		}
		//ICI
		//tempsOptiC0: le temps MINI pour arriver à l'issue du dernier poste de la chaine 0
		//tempsOptiC1: le temps MINI pour arriver à l'issue du dernier poste de la chaine 1
		//f* = min( f_0(n-1) + x0, f_1(n-1) + x1 )
		long tempOpti; // meilleur temps total
		int idxMeilleureChaine; // indice courrant de la mailleure chaine au poste j (on commence par la fin)
		if (tempsOptiC0 + atelier.getChaine(0).getTempsSortie() < tempsOptiC1 + atelier.getChaine(1).getTempsSortie()) {
			//ici le chemin optimal finit par la chaine 0
			tempOpti = tempsOptiC0 + atelier.getChaine(0).getTempsSortie();
			idxMeilleureChaine = 0;
		} else {
			//ici le chemin optimal finit par la chaine 1
			tempOpti = tempsOptiC1 + atelier.getChaine(1).getTempsSortie();
			idxMeilleureChaine = 1;
		}
		LinkedList<Integer> idxMeilleurParcours = new LinkedList<>();
        idxMeilleurParcours.addFirst(idxMeilleureChaine);
        for(int j = atelier.getLongueurChaines() - 2; j >= 0; j--) {
            idxMeilleureChaine = idxChainePrec[idxMeilleureChaine][j];
            idxMeilleurParcours.addFirst(idxMeilleureChaine);
        }
		return new ResultatOptimisation(new ArrayList<Integer>(), tempOpti);
	}

}	
