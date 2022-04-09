package Partie7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Observable implements CouacObservable{
	private List<Observateur> observateurs = new ArrayList<Observateur>();
	private CouacObservable canard;
	
	public Observable(CouacObservable canard) {
		this.canard = canard;
	}
	
	public void enregistrerObservateur(Observateur observateur) {
		observateurs.add(observateur);
	}

	@Override
	public void notifierObservateurs() {
		Iterator<Observateur> iterateur = observateurs.iterator();
		while(iterateur.hasNext()) {
			Observateur observateur = (Observateur)iterateur.next();
			observateur.actualiser(canard);	
		}
		
	}

}
