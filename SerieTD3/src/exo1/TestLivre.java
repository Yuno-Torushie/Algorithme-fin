package exo1;

public class TestLivre {

	public static void main(String[] args) {
			
			Livre unLivre = new Livre("Le gout du vrai","Etienne Klein");
			System.out.println(unLivre.toString());
			
			Livre secondLivre = new Livre("Le sommeil","Ewen Gilard","Son lit", 454);
			System.out.println(secondLivre.toString());
		
	}

}
