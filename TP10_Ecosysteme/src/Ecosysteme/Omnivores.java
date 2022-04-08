/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.List;

public class Omnivores extends Animaux {

	public Omnivores(List<Especes> especes, String... oeuf) {
		super(especes, oeuf);
		setEspece(EspecesAnimale.Omnivore);
		setTypeEspece(TypeEspece.Omnivores);
	}

	public Omnivores(Sexe sexe, double taille, double poids, int esv, List<Especes> especes) {
		super(sexe, taille, poids, esv, especes);
		setEspece(EspecesAnimale.Omnivore);
		setTypeEspece(TypeEspece.Omnivores);
	}

	/** 
	 * 
	 * Se nourrit
	 * 
	 * @param nourriture qui est consommée
	 * @param especes liste des especes de l'ecosysteme
	 * @see Especes#estMange()
	 */
	public void seNourir(Carnivores nourriture, List<Especes> especes) {	
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
	public void seNourir(Herbivores nourriture, List<Especes> especes) {
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
	public void seNourir(Oeuf nourriture, List<Especes> especes) {
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
		return "Omnivores [getEspece()=" + getEspece() + ", getSexe()=" + getSexe() + ", getTaille()=" + getTaille()
				+ ", getPoids()=" + getPoids() + ", getEsperanceDeVie()=" + getEsperanceDeVie() + ", toString()="
				+ super.toString() + ", isVivant()=" + isVivant() + ", getTypeEspece()=" + getTypeEspece()
				+ ", getClass()=" + getClass() + "]";
	}

}
