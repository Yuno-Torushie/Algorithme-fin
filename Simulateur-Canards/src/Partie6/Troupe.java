package Partie6;

import java.util.ArrayList;
import java.util.List;

public class Troupe implements Cancaneur{
	
	private List<Cancaneur> lesCancaneurs = new ArrayList<Cancaneur>();
	
	public void add(Cancaneur cancaneur) {
		lesCancaneurs.add(cancaneur);
	}
	
	@Override
	public void cancaner() {
		for(Cancaneur cancaneur : lesCancaneurs)
			cancaneur.cancaner();
		
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
