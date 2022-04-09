package zombieDiceGame;

public class Player {
	private String name;
	private int cerveaux;
	private boolean hasFinished=false;
	
	//Nom du joueur
	public Player(String name) {
		this.name=name;
		cerveaux=0;
	}
	//Ajout cerveau
	public void addCerveaux(int cerveaux) {
		this.cerveaux+=cerveaux;
	}
	//retour valeur Cerveau
	public int getCerveaux() {
		return cerveaux;
	}
	//Fin
	public boolean isFinishing() {
		return hasFinished;
	}
	//Fin bouléenne
	public void setHasFinished(boolean hasFinished) {
		this.hasFinished = hasFinished;
	}

	@Override
	public String toString() {
		return name;
	}
}
