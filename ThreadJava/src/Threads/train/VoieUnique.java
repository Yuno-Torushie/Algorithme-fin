package Threads.train;

public interface VoieUnique {

	// Simule l'arriv� d'un train sur la voie unique et sa sortie
	// retourne la voie de sortie correspondante � la voie d'entr�e
	public int emprunter(int voieEntree) throws MauvaiseVoieException;
}