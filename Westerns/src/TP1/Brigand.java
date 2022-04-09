package TP1;

public class Brigand extends Humain {

	private static String BOISSON_COWBOY_DEFAUT = "le tord-boyaux";
	private static String LOOK_BRIGAND_DEFAUT = "m�chant";
	private String look;
	private int nbDamesEnlevees = 0;
	private int recompense= 100;
	private boolean enPrison = false;

	public Brigand(String nom) {
		super(nom,BOISSON_COWBOY_DEFAUT);
	}
	
	public Brigand(String nom, String boisson, String look) {
		super(nom, boisson);
		this.look = LOOK_BRIGAND_DEFAUT;
	}
	
	public void kidnapper(Dame dameKidnapper) {
		if(!enPrison) {
			parler("Ah ah  !  "+dameKidnapper+",  tu  es  mienne  desormais  !");
			nbDamesEnlevees++;
			}
		else 
			parler("Bien essay� ! Mais je suis en train de moisir au cachou !");
		dameKidnapper.estKinapeePar(this);
		recompense = recompense + 100;
	}
	public void estEmprisonnerpar(Cowboy hommeVaillant) {
		if(!enPrison) {
			parler("Damned, je suis fait ! "+hommeVaillant+", tu m�as eu !");
			recompense = 0;
			enPrison = true;
		}
		else  parler("Oh oh ! Et droit de vivre, alors ?");
	}

	public int setRecompense() {
		return recompense;
	}
	
	public void sePresenter() {
		parler("J'ai l'air "+look+" et j'ai d�j� kidnapp� "+nbDamesEnlevees+" dames");
		parler("Ma t�te est mise � prix pour "+recompense+" $ !");
	}
	
	public String quelEstTonNom() {
		return(super.quelEstTonNom()+" le "+look);//TODO petit probl�me de nom pour le brigand
	}
	
}