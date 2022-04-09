/** L'interface <code>Graphe</code> fournit un cadre pour l'impl&eacute;mentation
 * en Java des graphes orient&eacute;s. Pour des raisons de commodit&eacute;,
 * les sommets d'un graphe sont repr&eacute;sent&eacute;s 
 * par des <code>Integer</code>.
 * 
 * @author Gr&eacute;goire Montcouquiol
 */
public interface Graphe {


	//Modification d'un graphe
	
    /**Ajoute un arc au graphe.
     * @param dpt le num&eacute;ro du sommet d'origine de l'arc
     * @param arr le num&eacute;ro du sommet d'arriv&eacute;e de l'arc
     */
    public void ajoutArc(Integer dpt, Integer arr);

    /**Ajoute un sommet au graphe. 
     * Le sommet est num&eacute;rot&eacute; automatiquement.
     * @return le num&eacute;ro du sommet
     */
    public Integer ajoutSommet();

    /**Supprime un sommet du graphe. Cette m&eacute;thode change potentiellement 
     * la num&eacute;rotation des autres sommets du graphe.
     * @param sommet le num&eacute;ro du sommet
     * @return true si le sommet &eacute;tait dans le graphe, false sinon
     */
    public boolean supprimeSommet(Integer sommet);

    /**Supprime un arc du graphe.
     * @param dpt le num&eacute;ro du sommet d'origine de l'arc
     * @param arr le num&eacute;ro du sommet d'arriv&eacute;e de l'arc
     * @return true si l'arc &eacute;tait dans le graphe, false sinon
     */
    public boolean supprimeArc(Integer dpt, Integer arr);

    
    
    
    /**Renvoie le nombre de sommets du graphe.
     * @return le nombre de sommets du graphe
     */
    public int nbSommets();

    
    /**Renvoie sous forme de tableau la liste des sommets du graphe.
     * @return la liste des sommets du graphe
     */
    public Integer[] sommets();
    
    
    
    //Adjacence
    
    /** Teste la pr&eacute;sence d'un arc entre deux sommets.
     * @param dpt le num&eacute;ro du sommet d'origine de l'arc
     * @param arr le num&eacute;ro du sommet d'arriv&eacute;e de l'arc
     * @return true si l'arc est dans le graphe, false sinon
     */ 
    public boolean testArc(Integer dpt, Integer arr);
    
    /**Renvoie les successeurs d'un sommet du graphe.
     * @param sommet le num&eacute;ro du sommet
     * @return un tableau contenant les num&eacute;ros des successeurs du sommet.
     */
    public Integer[] successeurs(Integer sommet);
 
    /**Renvoie les pr&eacute;d&eacute;cesseurs d'un sommet du graphe.
     * @param sommet le num&eacute;ro du sommet
     * @return un tableau contenant les num&eacute;ros des pr&eacute;d&eacute;cesseurs du sommet.
     */
    public Integer[] predecesseurs(Integer sommet);

    
    
    // les degres

    /** Calcule le demi-degr&eacute; sortant d'un sommet.
     * @param sommet le num&eacute;ro du sommet
     * @return le degr&eacute; sortant du sommet, ou -1 si le sommet n'est pas dans le graphe.
     */
    public int degreSortant(Integer sommet);

    /** Calcule le demi-degr&eacute; entrant d'un sommet.
     * @param sommet le num&eacute;ro du sommet
     * @return le degr&eacute; entrant du sommet, ou -1 si le sommet n'est pas dans le graphe.
     */
    public int degreEntrant(Integer sommet);

    /** Calcule le degr&eacute; total d'un sommet.
     * @param sommet le num&eacute;ro du sommet
     * @return le degr&eacute; total du sommet, ou -1 si le sommet n'est pas dans le graphe.
     */
    public int degreTotal(Integer sommet);

    
    //Matrice 
    
    /**Calcule la matrice d'adjacence du graphe. 
     * Le coefficient (i,j) vaut 1 s'il y a un arc entre le i-&egrave;me et le j-&egrave;me sommet
     * @return la matrice d'adjacence.
     */
    public int[][] matriceAdjacence();

}
