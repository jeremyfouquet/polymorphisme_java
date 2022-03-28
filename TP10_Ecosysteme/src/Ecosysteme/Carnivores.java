/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;


public class Carnivores extends Animaux {

	public Carnivores(String... oeuf) {
		super(oeuf);
		setEspece(EspecesAnimale.Carnivore);
		setTypeEspece(TypeEspece.Carnivores);
		// TODO Auto-generated constructor stub
	}
	
	public Carnivores(Sexe sexe, double taille, double poids, int esv) {
		super(sexe, taille, poids, esv);
		setEspece(EspecesAnimale.Carnivore);
		setTypeEspece(TypeEspece.Carnivores);
	}

	/** 
	 * 
	 * Se nourrit
	 * 
	 * @param nourriture qui est consommée
	 * @see Especes#estMange()
	 */
	public void seNourir(Herbivores nourriture) {
		nourriture.estMange();
	}

	/** 
	 * 
	 * Se nourrit
	 * 
	 * @param nourriture qui est consommée
	 * @see Especes#estMange()
	 */
	public void seNourir(Carnivores nourriture) {
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
		return "Carnivores [getEspece()=" + getEspece() + ", getSexe()=" + getSexe() + ", getTaille()=" + getTaille()
				+ ", getPoids()=" + getPoids() + ", getEsperanceDeVie()=" + getEsperanceDeVie() + ", toString()="
				+ super.toString() + ", isVivant()=" + isVivant() + ", getTypeEspece()=" + getTypeEspece()
				+ ", getClass()=" + getClass() +"]";
	}

}
