/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;


public class Herbivores extends Animaux {

	public Herbivores(String... oeuf) {
		super(oeuf);
		setEspece(EspecesAnimale.Herbivore);
		setTypeEspece(TypeEspece.Herbivores);
	}
	public Herbivores(Sexe sexe, double taille, double poids, int esv) {
		super(sexe, taille, poids, esv);
		setEspece(EspecesAnimale.Herbivore);
		setTypeEspece(TypeEspece.Herbivores);
	}
	
	/** 
	 * 
	 * Se nourrit
	 * 
	 * @param nourriture qui est consommée
	 * @see Especes#estMange()
	 */
	public void seNourir(Vegetaux nourriture) {
		nourriture.estMange();
	}

	/** 
	 * 
	 * Se nourrit
	 * 
	 * @param nourriture qui est consommée
	 * @see Especes#estMange()
	 */
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
