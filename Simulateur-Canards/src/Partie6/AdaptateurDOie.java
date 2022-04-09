package Partie6;

public class AdaptateurDOie implements Cancaneur{
	private Oie oie;
	
	public AdaptateurDOie(Oie oie) {
		this.oie = oie;
	}
	
	public void cancaner() {
		oie.cacarder();
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
