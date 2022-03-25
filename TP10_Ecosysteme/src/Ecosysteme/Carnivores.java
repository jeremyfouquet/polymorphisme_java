package Ecosysteme;

public class Carnivores extends Animaux {

	public Carnivores() {
		super();
		setEspece(EspecesAnimale.Carnivore);
		// TODO Auto-generated constructor stub
	}
	
	public Carnivores(double taille, double poids, int esv) {
		super(taille, poids, esv);
		setEspece(EspecesAnimale.Carnivore);
	}
	//	• Les carnivores sont des animaux pouvant manger des herbivores
	//	ainsi que d'autres carnivores.
	public void seNourir(Herbivores nourriture) {
		nourriture.estMange();
	}
	public void seNourir(Carnivores nourriture) {
		nourriture.estMange();
	}

}
