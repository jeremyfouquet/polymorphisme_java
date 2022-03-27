/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;


public class Herbivores extends Animaux {

	public Herbivores(String... oeuf) {
		super(oeuf);
		setEspece(EspecesAnimale.Herbivore);
		setTypeEspece(TypeEspece.Herbivores);
		// TODO Auto-generated constructor stub
	}
	public Herbivores(Sexe sexe, double taille, double poids, int esv) {
		super(sexe, taille, poids, esv);
		setEspece(EspecesAnimale.Herbivore);
		setTypeEspece(TypeEspece.Herbivores);
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
	
	// EQUALS, TOSTRING

	@Override
	public String toString() {
		return "Herbivores [getEspece()=" + getEspece() + ", getSexe()=" + getSexe() + ", getTaille()=" + getTaille()
				+ ", getPoids()=" + getPoids() + ", getEsperanceDeVie()=" + getEsperanceDeVie() + ", toString()="
				+ super.toString() + ", isVivant()=" + isVivant() + ", getTypeEspece()=" + getTypeEspece()
				+ ", getClass()=" + getClass() +  "]";
	}
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

}
