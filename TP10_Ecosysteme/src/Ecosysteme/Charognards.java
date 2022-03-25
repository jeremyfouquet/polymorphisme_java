package Ecosysteme;

import exception.MonException;

public class Charognards extends Animaux {

	public Charognards() {
		super();
		setEspece(EspecesAnimale.Charognard);
		// TODO Auto-generated constructor stub
	}
	
	public Charognards(double taille, double poids, int esv) {
		super(taille, poids, esv);
		setEspece(EspecesAnimale.Carnivore);
	}
	
	//	• Les charognards sont des animaux mangeant des animaux morts.
	public void seNourir(Animaux nourriture) throws MonException {
		if (nourriture.isVivant()) {
			throw new MonException("Se nourir est impossible : l'animal n'est pas mort !");
		} else {
			nourriture.estMange();
		}
	}

}
