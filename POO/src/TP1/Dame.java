package TP1;

public class Dame extends Humain{
	
	public static String couleurRobe = "jaune";
	public static boolean libre = true;
	static String boissonFavorite = "lait";
	
	
	public Dame(String nom, String boisson) {
		super(nom, boisson);
	}
	
	public Dame(String nom, String boisson,String couleurrobe) {
		super(nom, boisson);
		couleurRobe = couleurrobe;
	}
	
	public void estKinapeePar(Brigand) {
		System.out.println(Dame+" hurle !");
	}
	
	public void estLibereePar(CowBoy) {
		 
	}
	
	public void changerRobe(String couleurrobe) {
		couleurRobe = couleurrobe;
		System.out.println("Regardez  ma nouvelle robe "+couleurRobe+" !");
	}
}
