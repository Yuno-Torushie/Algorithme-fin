import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test1 {

	public static void main(String[] args) 
	{
		System.out.println("Creation du graphe.");
		System.out.print("Nombre de sommets du graphe ? ");
		GrapheValue g = new GrapheValueMatrice(lireNombre());
		boolean boucle = true;
		
		while (boucle)
		{
			//boucle de modification du graphe
			boolean boucle1 = true;
			while(boucle1)
			{
				System.out.println("\nPour visualiser le graphe, tapez 1.");
				System.out.println("Pour ajouter ou modifier un arc, tapez 2.");
				System.out.println("Pour supprimer un arc, tapez 3.");
				System.out.println("Pour ajouter un sommet, tapez 4.");
				System.out.println("Pour supprimer un sommet, tapez 5.");
				System.out.println("Pour passer a la phase suivante, tapez 0.");
				System.out.print("Votre choix ? ");
				int choix = lireNombre();
				System.out.println("");
				switch (choix)
				{
				case 0 : //sortie
					boucle1 = false;
					break;
				case 1 : //affichage
					affiche(g.matriceValuation());
					break;
				case 2: //ajout d'un arc
					System.out.print("Sommet d'origine ? ");
					int dpt = lireNombre();
					if (dpt>g.nbSommets() || dpt<=0)
					{
						System.out.println("\nCe sommet ne fait pas partie du graphe.");
						break;
					}
					System.out.print("\nSommet d'arrivee ? ");
					int arr= lireNombre();
					if (arr>g.nbSommets() || arr<=0)
					{
						System.out.println("\nCe sommet ne fait pas partie du graphe.");
						break;
					}
					int val=g.valuationArc(dpt, arr);
					if (val==GrapheValue.INFINI)
					{
						System.out.println("Cet arc va etre cree.");
						System.out.print("Valuation de l'arc ? ");
						g.ajoutArc(dpt, arr, lireNombre());
					}
					else
					{
						System.out.println("La valuation de cet arc est actuellement "+val);
						System.out.print("Nouvelle valuation ? ");
						g.changeValuation(dpt, arr, lireNombre());
					}
					System.out.println("");
					break;
				case 3 : //suppression d'un arc
					System.out.print("Sommet d'origine ? ");
					dpt = lireNombre();
					if (dpt>g.nbSommets() || dpt<=0)
					{
						System.out.println("\nCe sommet ne fait pas partie du graphe.");
						break;
					}
					System.out.print("Sommet d'arrivee ? ");
					arr = lireNombre();
					if (arr>g.nbSommets() || arr<=0)
					{
						System.out.println("\nCe sommet ne fait pas partie du graphe.");
						break;
					}
					if (g.supprimeArc(dpt, arr))
						System.out.println("L'arc a ete supprime.");
					else
						System.out.print("Cet arc ne fait pas partie du graphe.");
					break;
				case 4 : //ajout d'un sommet
					g.ajoutSommet();
					System.out.println("Sommet ajoute.");
					break;
				case 5 : //suppression d'un sommet
					System.out.print("Sommet a supprimer ? ");
					int som = lireNombre();
					if (g.supprimeSommet(som))
						System.out.println("\nSommet supprime.");
					else
						System.out.println("\nCe sommet ne fait pas partie du graphe.");
					break;
				}	
			}

		//boucle de tests des methodes
		boolean boucle2 = true;
		while(boucle2)
		{
			System.out.println("\nPour visualiser le graphe, tapez 1.");
			System.out.println("Pour modifier le graphe, tapez 2.");
			System.out.println("Pour calculer le degre entrant d'un sommet, tapez 3.");
			System.out.println("Pour calculer le degre sortant d'un sommet, tapez 4.");
			System.out.println("Pour calculer le degre total d'un sommet, tapez 5.");
			System.out.println("Pour afficher les predecesseurs d'un sommet, tapez 6.");
			System.out.println("Pour afficher les successeurs d'un sommet, tapez 7.");
			System.out.println("Pour afficher la matrice d'adjacence du graphe, tapez 8.");
			System.out.println("Pour quitter, tapez 0.");

			System.out.print("Votre choix ? ");
			int choix = lireNombre();
			switch(choix)
			{
			case 0 : //sortie
				boucle = false;
				boucle2 = false;
				break;
			case 1 : //affichage
				affiche(g.matriceValuation());
				break;
			case 2 : //retour modification
				boucle2 = false;
				break;
			case 3 : //degre entrant
				System.out.print("\nNumero du sommet ? ");
				int sommet = lireNombre();
				int res = g.degreEntrant(sommet);
				if (res==-1)
					System.out.println("Ce sommet n'est pas dans le graphe");
				else
					System.out.println("Degre entrant du sommet "+sommet+" : "+res);
				break;
			case 4 : //degre sortant
				System.out.print("\nNumero du sommet ? ");
				sommet = lireNombre();
				res = g.degreSortant(sommet);
				if (res==-1)
					System.out.println("Ce sommet n'est pas dans le graphe");
				else
					System.out.println("Degre sortant du sommet "+sommet+" : "+res);
				break;
			case 5 : //degre total
				System.out.print("\nNumero du sommet ? ");
				sommet = lireNombre();
				res = g.degreTotal(sommet);
				if (res==-1)
					System.out.println("Ce sommet n'est pas dans le graphe");
				else
					System.out.println("Degre total du sommet "+sommet+" : "+res);
				break;
			case 6 : //predecesseur
				System.out.print("\nNumero du sommet ? ");
				sommet = lireNombre();
				if (sommet<=0 || sommet>g.nbSommets())
				{
					System.out.println("Ce sommet n'est pas dans le graphe");
					break;
				}
				Integer[] tab = g.predecesseurs(sommet);
				if (tab.length==0)
					System.out.println("Ce sommet n'a pas de predecesseurs");
				else
				{
					String ligne = "Les predecesseurs du sommet "+sommet+
					" sont les sommets : ";
					for (Integer pred : tab)
						ligne+=pred+" ";
					System.out.println(ligne);
				}
				break;
			case 7 : //successeur
				System.out.print("\nNumero du sommet ? ");
				sommet = lireNombre();
				tab = g.successeurs(sommet);
				if (sommet<=0 || sommet>g.nbSommets())
				{
					System.out.println("Ce sommet n'est pas dans le graphe");
					break;
				}
				if (tab.length==0)
					System.out.println("Ce sommet n'a pas de successeurs");
				else
				{
					String ligne = "Les successeurs du sommet "+sommet+
					" sont les sommets : ";
					for (Integer succ : tab)
						ligne+=succ+" ";
					System.out.println(ligne);
				}
				break;
			case 8 : //matrice d'adjacence
				affiche(g.matriceAdjacence());
				break;
			}
		}
		}
		
	}

	private static int lireNombre()
	{
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in)); 
		boolean ok=false;
		int res=-1;
		while(!ok)
			{
			try 
				{			
				res=Integer.parseInt(buff.readLine());
				ok=true;
				} 
			catch (IOException e) {e.printStackTrace();}
			catch (NumberFormatException f)
				{
				System.out.print("\nCeci n'est pas un nombre, veuillez recommencer : ");
				}
			}
		return res;
	}
	
	private static void affiche(int[][] matrice)
	{
		int n = matrice.length;
		//recherche du plus long element
		int tailleMax = String.valueOf(n).length();
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				if (matrice[i][j]!=GrapheValue.INFINI && 
						tailleMax < String.valueOf(matrice[i][j]).length())
					tailleMax = String.valueOf(matrice[i][j]).length();
		
		//affichage
		String ligne = blanc(tailleMax);
		for (int i=0; i<n; i++)
		    ligne+=blanc(tailleMax+1-String.valueOf(i+1).length())+(i+1);
		System.out.println(ligne);
		for (int i=0; i<n; i++)
			{
			    ligne =blanc(tailleMax-String.valueOf(i+1).length())+(i+1);
			for (int j=0; j<n; j++)
				if (matrice[i][j]==GrapheValue.INFINI)
					ligne+=blanc(tailleMax)+"-";
				else
					ligne+=blanc(tailleMax+1-String.valueOf(matrice[i][j]).length())+matrice[i][j];
			System.out.println(ligne);
			}
		System.out.println("");
	}
	
	//construit une chaine de nb espace
	private static String blanc(int nb)
	{
		String res="";
		for (int i=0; i<nb; i++)
			res+=" ";
		return res; 
	}
}
