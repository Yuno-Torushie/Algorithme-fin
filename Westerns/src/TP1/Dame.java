package TP1;

public class Dame extends Humain{
	
	private static String BOISSON_DAME_DEFAUT = "le lait";
	private String couleurRobe = "jaune"; 
	private static boolean libre = true;
	
	public Dame(String nom) {
		super(nom,BOISSON_DAME_DEFAUT);
	}
	
	public Dame(String nom, String libre,String couleurrobe) {
		super(nom, libre);
		this.couleurRobe = couleurrobe;
	}
	
	public void estKinapeePar(Brigand b) {
		if (libre=true){
            parler("Au secour! Je suis une jolie dame qui se fait enlever par un vilain monsieur "+b+" !");
            libre = false;
        }
        else{
            parler("je suis d�j� kidnapp�, andouille!");
        }
	}
	
	public void estLibereePar(Cowboy c) {
		if(libre = false){
            parler("Vous �tes mon mamour, merci de m'avoir lib�r� Monsieur "+c+" ! (smac*)");
            libre = true;
        }
        else
            parler("Mais je ne suis pas en dang�! Sale goujat! (pleure)");
    }
	
	public void changerRobe(String couleurrobe) {
		this.couleurRobe = couleurrobe;
		System.out.println("Regardez  ma nouvelle robe "+couleurRobe+" !");
	}
	public void sePresenter() {
		
	}
	public String quelEstTonNom() {
		return ("Miss "+super.quelEstTonNom());//TODO petit probl�me avec le nom de la dame
	}
}
