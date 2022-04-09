package TP1;

public class Barman extends Humain{

	private static String BOISSON_BARMAN_DEFAUT = "le vin";
	private static String nomBar;
		
	public Barman(String nom) {
		super(nom,BOISSON_BARMAN_DEFAUT);
	}
	
	public Barman(String nom, String nomBar) {
		super(nom);
		this.nomBar = nomBar;//TODO petit problème avec le nom de bar
	}
	
	public void servir(Humain h) {
		parler("Et voila ! Un bon verre de "+h.getBoissonFavorite()+" pour "+h.quelEstTonNom()+" ?");
 
	}
	 
	public void parler(String texte) {
		System.out.println("("+super.quelEstTonNom()+") - "+texte+" Coco.\n");
	}
    public void SePresenter() {
        super.sePresenter();
        this.parler("Oh et.. bienvenue ici : "+nomBar);
    }
    
	public void sePresenter() {
		parler("Je tiens un bar du nom de "+nomBar+" !");
	}

}
