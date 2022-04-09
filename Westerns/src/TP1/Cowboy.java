package TP1;

public class Cowboy extends Humain{
	
	private static String ADJECTIF_COWBOY_DEFAUT = "vaillant";
	private static String BOISSON_COWBOY_DEFAUT = "le whisky";
	private int popularite = 0;
	private String adjectif;

	
	public Cowboy (String nom) {
		super(nom,BOISSON_COWBOY_DEFAUT);
	}
	
    public Cowboy(String nom, String boisson_favorite, String adjectif) {
        super(nom, boisson_favorite);
        this.adjectif= ADJECTIF_COWBOY_DEFAUT;
    }
	
	public void liberer(Dame D) {
		D.estLibereePar(this);
		popularite++;
		parler("Salut belle damoiselle, vous faites d�sormais parti des "+popularite+" femmes � vouloir m'�pouser !");
	}
	
	public void tirer(Brigand b) {
		 if(!Brigand.enPrison)//TODO enPrison Cowboy
		System.out.println("Le "+adjectif+" "+this.quelEstTonNom()+"tire sur "+b+".  PAN  !\n"+"Prend  �a,  rascal  !");
		 else parler("La z�nitude tu cocos?");
	}
	
	public void sePresenter() {
		parler("J'ai "+popularite+" de dames qui veulent m'�pouser.");
	}

}