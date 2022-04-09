package tri;

import java.util.Arrays;
import java.util.Random;

public class SortExample {
		
	public static void main(String[] args){
		int n=1000;
		int []tab;
		tab = new int[n];
		
		Random r=new Random();	
		for(int i=0;i<=n-1;i++)
		tab[i]=r.nextInt(10000);	//on remplit le tableau aléatoirement
		
		Arrays.sort(tab);			//tri tab à la façon Arrays.sort
		System.out.printf(Arrays.toString(tab));
	
	}
}
	
