package Partie6;

public interface CouacObservable {
	public void enregistrerObservateur(Observateur observateur);
	
	public void notifierObservateurs();

}
