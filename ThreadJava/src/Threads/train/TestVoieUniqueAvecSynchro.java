package Threads.train;

import Threads.train.*;

public class TestVoieUniqueAvecSynchro {

	public static void main(String[] args) {
		VoieUnique vu= new VoieUniqueSansSynchro();
		int nbTrains = 0;
		
		while (nbTrains < 10) {
			int voie;
			if((int) (Math.random()*2) % 2 ==0) voie = 4;
			else voie = 1;
			Train t = new Train(vu, voie);
			t.setName("Train" + nbTrains++);
			t.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
