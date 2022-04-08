/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.List;

public class Herbivores extends Animaux {

	public Herbivores(List<Especes> especes, String... oeuf) {
		super(especes, oeuf);
		setEspece(EspecesAnimale.Herbivore);
		setTypeEspece(TypeEspece.Herbivores);
	}
	public Herbivores(Sexe sexe, double taille, double poids, int esv, List<Especes> especes) {
		super(sexe, taille, poids, esv, especes);
		setEspece(EspecesAnimale.Herbivore);
		setTypeEspece(TypeEspece.Herbivores);
	}
	
	/** 
	 * 
	 * Se nourrit
	 * 
	 * @param nourriture qui est consommée
	 * @param especes liste des especes de l'ecosysteme
	 * @see Especes#estMange()
	 */
	public void seNourir(Vegetaux nourriture, List<Especes> especes) {
		nourriture.estMange(especes);
	}

	/** 
	 * 
	 * Se nourrit
	 * 
	 * @param nourriture qui est consommée
	 * @param especes liste des especes de l'ecosysteme
	 * @see Especes#estMange()
	 */
	public void seNourir(Legumes nourriture, List<Especes> especes) {
		nourriture.estMange(especes);
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
		return "Herbivores [getEspece()=" + getEspece() + ", getSexe()=" + getSexe() + ", getTaille()=" + getTaille()
				+ ", getPoids()=" + getPoids() + ", getEsperanceDeVie()=" + getEsperanceDeVie() + ", toString()="
				+ super.toString() + ", isVivant()=" + isVivant() + ", getTypeEspece()=" + getTypeEspece()
				+ ", getClass()=" + getClass() + "]";
	}

}
