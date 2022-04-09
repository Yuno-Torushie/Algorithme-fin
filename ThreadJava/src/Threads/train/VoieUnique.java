package Threads.train;

public interface VoieUnique {

	// Simule l'arrivé d'un train sur la voie unique et sa sortie
	// retourne la voie de sortie correspondante à  la voie d'entrée
	public int emprunter(int voieEntree) throws MauvaiseVoieException;
}