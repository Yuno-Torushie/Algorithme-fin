
/** L'interface <code>GrapheValue</code> fournit un cadre pour l'impl&eacute;mentation
 * en Java des graphes valu&eacute;s orient&eacute;s. Pour des raisons de commodit&eacute;,
 * les sommets d'un graphe sont repr&eacute;sent&eacute;s 
 * par des <code>Integer</code>. La valuation est d&eacute;finie pour toute paire de sommets
 * du graphe : l'absence d'arc entre deux sommets correspond &agrave; une valuation &eacute;gale &agrave; 
 * la constante pr&eacute;d&eacute;finie <it>INFINI</it>.
 * 
 * @author Gr&eacute;goire Montcouquiol
 */
public interface GrapheValue extends Graphe {

	/** Valuation correspond &agrave; l'absence d'arc entre deux sommets.
	 */
	public static final int INFINI = Integer.MAX_VALUE;

    /**Ajoute un arc de valuation donn&eacute;e au graphe.
     * @param dpt le num&eacute;ro du sommet d'origine de l'arc
     * @param arr le num&eacute;ro du sommet d'arriv&eacute;e de l'arc
     * @param valuation la valuation de l'arc
     */	
	public void ajoutArc(Integer dpt, Integer arr, int valuation);
	
    /**Change la valuation d'un arc du graphe.
     * @param dpt le num&eacute;ro du sommet d'origine de l'arc
     * @param arr le num&eacute;ro du sommet d'arriv&eacute;e de l'arc
     * @param valuation la nouvelle valuation de l'arc
     */	
	public void changeValuation(Integer dpt, Integer arr, int valuation);
	
	/** Donne la valuation de l'arc entre deux sommets 
	 * @param dpt le num&eacute;ro du sommet d'origine de l'arc
	 * @param arr le num&eacute;ro du sommet d'arriv&eacute;e de l'arc
	 * @return la valuation de l'arc, ou INFINI si l'arc n'existe pas.
	 */
	public int valuationArc(Integer dpt, Integer arr);
	
	
	/** Calcule la matrice de valuation du graphe.
	 * Le coefficient (i,j) est &eacute;gal &agrave; la valuation de l'arc entre
	 * le i-&egrave;me et le j-i&egrave;me sommet, ou INFINI si l'arc n'existe pas.
	 * @return la matrice de valuation du graphe.
	 */
	public int[][] matriceValuation();
	
}
