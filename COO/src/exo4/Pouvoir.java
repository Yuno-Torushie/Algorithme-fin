package exo4;

public class Pouvoir {
	public String nom;
	public String description;
	public int forcePouvoir;
	
	public Pouvoir(String pnom, String pdescription, int pforcePouvoir) {
		//initialisation des attributs
		nom = pnom;
		description = pdescription;
		forcePouvoir = pforcePouvoir;
	}
}

public interface EtreSuperNaturel{
	void utiliserPouvoirs(Humain adversaire);
}
