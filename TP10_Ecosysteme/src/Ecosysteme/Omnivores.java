/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

public class Omnivores extends Animaux {

	public Omnivores(String... oeuf) {
		super(oeuf);
		setEspece(EspecesAnimale.Omnivore);
		setTypeEspece(TypeEspece.Omnivores);
	}
	public Omnivores(Sexe sexe, double taille, double poids, int esv) {
		super(sexe, taille, poids, esv);
		setEspece(EspecesAnimale.Omnivore);
		setTypeEspece(TypeEspece.Omnivores);
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
	public void seNourir(Oeuf nourriture) {
		nourriture.estMange();
	}
	// EQUALS, TOSTRING

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Omnivores [getEspece()=" + getEspece() + ", getSexe()=" + getSexe() + ", getTaille()=" + getTaille()
				+ ", getPoids()=" + getPoids() + ", getEsperanceDeVie()=" + getEsperanceDeVie() + ", toString()="
				+ super.toString() + ", isVivant()=" + isVivant() + ", getTypeEspece()=" + getTypeEspece()
				+ ", getClass()=" + getClass() + "]";
	}

}
