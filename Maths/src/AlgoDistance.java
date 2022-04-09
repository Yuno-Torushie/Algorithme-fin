import java.util.Arrays;

/** La classe <code>AlgoDistance</code> contient deux m&eacute;thodes statiques
 * permettant d'effectuer des caculs de distances et de plus courts chemins sur un graphe
 * valu&eacute;. Les r&eacute;sultats (distances et tableaux des p&egrave;res) sont 
 * affich&eacute;s dans la console.  
 */
public class AlgoDistance {

	/** Calcule les distances dans un graphe valu&eacute; en utilisant l'algorithme
	 * de Dijkstra. Les r&eacute;sultats (distances et tableaux des p&egrave;res) sont 
	 * affich&eacute;s dans la console.  
	 * 
	 * @param g le graphe valu&eacute;
	 * @param sommet le sommet du graphe &agrave; partir duquel on calcule les distances
	 *
	 * @throws IllegalArgumentException si le graphe comporte des arcs de valuation n&eacute;gative.
	 */
	public static void dijkstra(GrapheValue g, Integer sommet) {
		int j = 0;
		
		int nbSommets = g.nbSommets();
		int[] lambda = new int[nbSommets];
		Integer[] pi = new Integer[nbSommets];
		
		for(int i = 0; i < nbSommets; i++) {
			lambda[i] = GrapheValue.INFINI;
			pi[i] = null;
		}
		lambda[sommet - 1] = 0;	
		
		while(j <= g.nbSommets()) {
			for(int i = 0; i < nbSommets; i++) {
				if(g.testArc(i,j) && lambda[j - 1] > lambda[i - 1] + g.valuationArc(i,j)) {
					lambda[j - 1] = lambda[i-1] + g.valuationArc(i, j);
						pi[j - 1] = i;
				}
			}
		}
		
		affiche(lambda,pi);
	}
	
	/** Calcule les distances dans un graphe valu&eacute; en utilisant l'algorithme
	 * de Bellman-Ford. Les r&eacute;sultats (distances et tableaux des p&egrave;res) sont 
	 * affich&eacute;s dans la console.  
	 * 
	 * @param g le graphe valu&eacute;
	 * @param sommet le sommet du graphe &agrave; partir duquel on calcule les distances
	 *
	 * @throws IllegalArgumentException si le graphe comporte des circuits absorbants.
	 */	
	public static void bellmanFord(GrapheValue g, Integer sommet){
		int nbSommets = g.nbSommets();
		int[] lambda = new int[nbSommets];
		Integer[] pi = new Integer[nbSommets];
		
		for(int i = 0; i < nbSommets; i++) {
			lambda[i] = GrapheValue.INFINI;
			pi[i] = null;
		}
		lambda[sommet - 1] = 0;
		for(int k = 1; k <= g.nbSommets(); k++) {
			for(int i = 1; i <= g.nbSommets(); i++) {
				for(int j = 1; j <= g.nbSommets(); j++) {
					if(g.testArc(i,j) && lambda[j - 1] > lambda[i - 1] + g.valuationArc(i,j)) {
						lambda[j - 1] = lambda[i-1] + g.valuationArc(i, j);
							pi[j - 1] = i;
					}
				}
			}
			
			loop: for(int i = 1; i <= g.nbSommets(); i++) {
				for(int j = 1; j <= g.nbSommets(); j ++) {
					if(g.testArc(i,j) && lambda[j - 1] > lambda[i - 1] + g.valuationArc(i,j)) {
						break loop;
					}
				}
			}
		}
		affiche(lambda, pi);
		
	}
	
	
	/** Affiche dans la console, sous forme d'un tableau, le contenu des deux arguments.
	 */
	private static void affiche(int[] distance, Integer[] peres) 
	{
		int n = distance.length;
		//recherche du plus long element
		int tailleMax = String.valueOf(n).length();
		for (int i=0; i<n; i++)
		{
			if (distance[i]!=GrapheValue.INFINI && 
					tailleMax < String.valueOf(distance[i]).length())
				tailleMax = String.valueOf(distance[i]).length();
			if (peres[i]!=null && 
					tailleMax < String.valueOf(peres[i]).length())	
				tailleMax = String.valueOf(peres[i]).length();
		}			
			
		//affichage
		String ligne = "sommets  ";
		for (int i=0; i<n; i++)
			ligne+=blanc(tailleMax+1-String.valueOf(i+1).length())+(i+1);
		System.out.println(ligne);
		ligne = "peres    ";
		for (int i=0; i<n; i++)
			if (peres[i]==null)
				ligne+=blanc(tailleMax)+"-";
			else
				ligne+=blanc(tailleMax+1-String.valueOf(peres[i]).length())+peres[i];
		System.out.println(ligne);
		ligne = "distances";
		for (int i=0; i<n; i++)
			if (distance[i]==GrapheValue.INFINI)
				ligne+=blanc(tailleMax)+"-";
			else
				ligne+=blanc(tailleMax+1-String.valueOf(distance[i]).length())+distance[i];
		System.out.println(ligne);
		
		System.out.println("");
	}
		
	/**construit une chaine comportant nb espaces*/
	private static String blanc(int nb)
	{
		String res="";
		for (int i=0; i<nb; i++)
			res+=" ";
		return res; 
	}

}
