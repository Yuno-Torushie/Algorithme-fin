package tri;
import java.util.Random;

public class tri {

	static int [] tableau;
	static int [] copieTab;
	static int n=1000;
	static boolean AFFICHAGE=true;
	
	public static void main(String[] args) {
		
		long start,stop;  //sert pour calculer le temps des tris
		
		tableau=new int[n];
		
		Random r=new Random();	
		for(int i=0;i<=n-1;i++)
			tableau[i]=r.nextInt(10000);	//on remplit le tableau aléatoirement

		copieTab=(int[]) tableau.clone(); // on garde une copie pour pouvoir appliquer différentes méthodes de tri sur le même jeu de données
		
		if(AFFICHAGE) afficherTableau();
		System.out.println();
		
		start = System.nanoTime(); 
		triSelection();
		stop = System.nanoTime();
		
		if(AFFICHAGE) afficherTableau();
		
		
		System.out.println("temps de tri par sélection : " + (float) (stop - start)/1000000 +" ms\n");
		
		tableau=(int[]) copieTab.clone(); // on remet le tableau dans l'état initial
		
		start = System.nanoTime(); 
		triFusion(tableau,0,n-1);
		stop = System.nanoTime();
		
		if(AFFICHAGE) afficherTableau();
		
		System.out.println("temps de tri fusion : " + (float) (stop - start)/1000000 +" ms\n");
		
	
		
	}
	
	public static void afficherTableau(){
		
		System.out.print("Tableau :");
		
		for(int i=0;i<=n-1;i++)
			System.out.print(" "+tableau[i]);	
		
		System.out.println(".");

	}
	
	public static void triSelection(){
		int min, Position = 0;
		for(int i=0;i<n-2;i++) {
			min = tableau[0];
			for(int j=i+1; j<n-1; i++){
				if(tableau[j]<min) {
					min = tableau[j];
					Position = j;
				}
			}
			tableau[Position]= tableau[i];
			tableau[i]=min;
		}
	}
	
	public static void triFusion(int []tab, int g, int d){
		int m;
		if(g<d) {
			m=(g+d)/2;
			triFusion(tab,g,m);
			triFusion(tab,m+1,d);
			Fusionner (tab,g,m,d);
		}
			
	}
	
	public static void Fusionner(int []tab, int debut, int milieu, int fin){
		int []tableau;
		tableau = new int[fin-debut+1];
		int i=debut, j=milieu+1, k=0;
		while(i < milieu+1 && j < fin+1) {
			if(tab[i]<=tab[j]) {
				tableau[k]=tab[i];
				i++;
				k++;
			}
			else {
				tableau[k]=tab[j];
				j++;
				k++;
			}
		}
		while(i < milieu+1 || j < fin+1) {
			if(j==fin+1) {
				tableau[k]=tab[i];
				i++;
				k++;
			}
			else if(i==milieu+1) {
				tableau[k]=tab[j];
				j++;
				k++;
			}
		}
		k=0;
		for(int b=debut;b<fin+1;b++) {
			tab[b]=tableau[k];
			k++;
		}
	}
	public static void TriRapide(int []tab){
		int Vm;
		for(int p=1;p<n;p++) {
			for(int i=0; i<n;i++) {
				if (tab[i] <= tab[p]) {
					Vm = tab[i];
					for(int j=0;j<i;j++) {
						tab[j+1]=tab[j];
					}
					tab[0]=Vm;
				}
			}
		}
	}
}
	
	
	
	
	
	
	
