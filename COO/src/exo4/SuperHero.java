package exo4;

public class SuperHero extends Humain implements EtreSuperNaturel{
	
	public String pseudo;
	public Pouvoir[] pouvoirs;
	
	public SuperHero(String pnom, String pprenom, int pforceFrappe, String ppseudo, Pouvoir[] ppouvoirs) {
		//initialisation des attributs
		super(pnom,pprenom,pforceFrappe);
		pseudo = ppseudo;
		pouvoirs = ppouvoirs;
	}
	
	@Override
	public void utiliserPouvoirs(Humain adversaire) {
		for (int i=0; i<pouvoirs.length;i++) {
			adversaire.pointsdeVie = adversaire.pointsdeVie - pouvoirs[i].forcePouvoir;
		}
	}
	
	@Override
	void sebattre(Humain adversaire) {
		super.sebattre(adversaire);
		utiliserPouvoirs(adversaire);
	}
}
