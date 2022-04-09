

/**
 * La classe <code>GrapheValueMatrice</code> impl&eacute;mente l'interface
 * <code>GrapheValue</code> en repr&eacute;sentant en m&eacute;moire un graphe
 * valu&eacute; par sa matrice de valuation.
 */

public class GrapheValueMatrice implements GrapheValue {

    private int nb_sommets; //le nombre de sommets du graphe
    private int[][] matVal; //la matrice de valuation du graphe

    /*les constructeurs*/

    /**
     * Construit un graphe valu&eacute; vide
     */
    public GrapheValueMatrice() {
        nb_sommets = 0;
        matVal = new int[0][0];
    }

    /**
     * Construit un graphe valu&eacute; &agrave; n sommets, sans arc.
     * Les sommets vont de 1 &agrave; n.
     *
     * @param n le nombre de sommets
     */
    public GrapheValueMatrice(int n) {
        nb_sommets = n;
        matVal = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matVal[i][j] = GrapheValue.INFINI;
    }

    /**
     * Construit un graphe valu&eacute; &agrave; partir de la matrice de valuation.
     * Les sommets vont de 1 &agrave; n.
     *
     * @param n   le nombre de sommets
     * @param mat la matrice de valuation
     */
    public GrapheValueMatrice(int n, int[][] mat) {
        nb_sommets = n;
        //copie de la matrice
        matVal = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matVal[i][j] = mat[i][j];
    }


    /**
     * Construit un graphe valu&eacute; &agrave; partir d'un graphe.
     * Les sommets vont de 1 &agrave; n.
     * Les arcs ont tous la valuation 1.
     *
     * @param g le graphe (non valu&eacute;)
     */
    public GrapheValueMatrice(Graphe g) {
        nb_sommets = g.nbSommets();
        matVal = new int[nb_sommets][nb_sommets];
        int[][] m = g.matriceAdjacence();
        for (int i = 0; i < nb_sommets; i++)
            for (int j = 0; j < nb_sommets; j++)
                if (m[i][j] == 1)
                    matVal[i][j] = 1;
                else
                    matVal[i][j] = GrapheValue.INFINI;
    }



    /*les methodes de GrapheValue*/

    public void ajoutArc(Integer dpt, Integer arr, int valuation) {
        changeValuation(dpt, arr, valuation);
    }

    public void changeValuation(Integer dpt, Integer arr, int valuation) {
        matVal[dpt - 1][arr - 1] = valuation;
    }

    public int[][] matriceValuation() {
        return matVal;
    }

    public int valuationArc(Integer dpt, Integer arr) {
        //attention a la numerotation...
        return matVal[dpt - 1][arr - 1];
    }


    /*les methodes de Graphe*/

    /**
     * Ajoute un arc au graphe. La valuation par d&eacute;faut de l'arc est 1.
     *
     * @param dpt le num&eacute;ro du sommet d'origine de l'arc
     * @param arr le num&eacute;ro du sommet d'arriv&eacute;e de l'arc
     */
    public void ajoutArc(Integer dpt, Integer arr) {
        ajoutArc(dpt, arr, 1);
    }

    public Integer ajoutSommet() {
        int[][] new_matVal = new int[nb_sommets + 1][nb_sommets + 1];

        for(int i = 0; i < nb_sommets; i++) {
            for(int j = 0; j < nb_sommets; j++) {
                new_matVal[i][j] = INFINI;
            }
        }

        matVal = new_matVal;
        nb_sommets++;
        return nb_sommets;
    }

    public int degreEntrant(Integer sommet) {
        int degre = 0;

        for(int i = 0; i < nb_sommets; i++){
            if(matVal[i][sommet - 1] != INFINI){
                degre++;
            }
        }

        return degre;
    }

    public int degreSortant(Integer sommet) {
        int degre = 0;

        for(int i = 0; i < nb_sommets; i++){
            if(matVal[sommet - 1][i] != INFINI){
                degre++;
            }
        }

        return degre;
    }

    public int degreTotal(Integer sommet) {
        return degreEntrant(sommet) + degreSortant(sommet);
    }

    public int[][] matriceAdjacence() {
        int[][] matAdj = new int[nb_sommets][nb_sommets];

        for(int i = 0; i < nb_sommets; i++) {
            for(int j = 0; j < nb_sommets; j++) {
                matAdj[i][j] = matVal[i][j] == INFINI ? 0 : 1;
            }
        }

        return matAdj;
    }

    public int nbSommets() {
        return nb_sommets;
    }

    public Integer[] predecesseurs(Integer sommet) {
        Integer[] pred = new Integer[degreEntrant(sommet)];
        int index = 0;

        for(int i = 0; i < nb_sommets; i++){
            if(matriceAdjacence()[i][sommet - 1] != 0){
                pred[index] = i + 1;
                index++;
            }
        }

        return pred;
    }

    public Integer[] sommets() {
        Integer[] res = new Integer[nb_sommets];

        for (int i = 0; i < nb_sommets; i++)
            res[i] = i + 1;

        return res;
    }

    public Integer[] successeurs(Integer sommet) {
        Integer[] succ = new Integer[degreSortant(sommet)];
        int index = 0;

        for(int i = 0; i < nb_sommets; i++){
            if(matriceAdjacence()[sommet - 1][i] != 0){
                succ[index] = i + 1;
                index++;
            }
        }

        return succ;
    }

    public boolean supprimeArc(Integer dpt, Integer arr) {
        if(dpt > nb_sommets || dpt <= 0 || arr > nb_sommets || arr <= 0)
            return false;

        matVal[dpt - 1][arr - 1] = INFINI;
        return true;
    }

    /**
     * Supprime un sommet du graphe. Cette m&eacute;thode d&eacute;cale la
     * num&eacute;rotation des sommets du graphe.
     *
     * @param sommet le num&eacute;ro du sommet
     * @return true si le sommet &eacute;tait dans le graphe, false sinon
     */
    public boolean supprimeSommet(Integer sommet) {
        if (sommet > nb_sommets || sommet <= 0)
            return false;

        int[][] new_matVal = new int[nb_sommets - 1][nb_sommets - 1];
        for (int i = 0; i < nb_sommets - 1; i++)
            for (int j = 0; j < nb_sommets - 1; j++)
                new_matVal[i][j] = matVal[(i < sommet - 1) ? i : i + 1][(j < sommet - 1) ? j : j + 1];
        matVal = new_matVal;
        nb_sommets--;
        return true;
    }

    public boolean testArc(Integer dpt, Integer arr) {
        return (matVal[dpt - 1][arr - 1] != GrapheValue.INFINI);
    }

}