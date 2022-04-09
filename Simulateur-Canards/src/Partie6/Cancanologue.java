package Partie6;

public class Cancanologue implements Observateur{
	
	public void actualiser(CouacObservable canard) {
		System.out.println("Cancanologue : " + canard + " vient de cancaner.");
	}

	@Override
	public void enregistrerObservateur(Observateur observateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifierObservateurs() {
		// TODO Auto-generated method stub
		
	}
	
}
