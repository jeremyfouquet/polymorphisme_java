package Ecosysteme;

public class Omnivores extends Animaux {

	public Omnivores() {
		super();
		setEspece(EspecesAnimale.Omnivore);
	}
	public Omnivores(double taille, double poids, int esv) {
		super(taille, poids, esv);
		setEspece(EspecesAnimale.Carnivore);
	}

	//	• Les omnivores eux peuvent manger des carnivores, des herbivores
	//	des plantes ainsi que des œufs.		
	public void seNourir(Carnivores nourriture) {	
		nourriture.estMange();
	}
	public void seNourir(Herbivores nourriture) {
		nourriture.estMange();
	}
	public void seNourir(Vegetaux nourriture) {
		nourriture.estMange();
	}
//	public void seNourir(Object nourriture) {
//	nourriture.estMange();
//	}

}
