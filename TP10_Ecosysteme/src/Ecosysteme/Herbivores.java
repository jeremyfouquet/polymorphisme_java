package Ecosysteme;


public class Herbivores extends Animaux {

	public Herbivores() {
		super();
		setEspece(EspecesAnimale.Herbivore);
		// TODO Auto-generated constructor stub
	}
	public Herbivores(Sexe sexe, double taille, double poids, int esv) {
		super(sexe, taille, poids, esv);
		setEspece(EspecesAnimale.Herbivore);
	}
	
	//	Les herbivores sont des animaux pouvant manger des végétaux de
	//	n'importe quel type ou exclusivement des légumes.
	public void seNourir(Vegetaux nourriture) {
		nourriture.estMange();
	}

	//	Les herbivores sont des animaux pouvant manger des végétaux de
	//	n'importe quel type ou exclusivement des légumes.
	public void seNourir(Legumes nourriture) {
		nourriture.estMange();
	}
	

}
