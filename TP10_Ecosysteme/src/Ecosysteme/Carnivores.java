/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.List;

public class Carnivores extends Animaux {

	public Carnivores(List<Especes> especes, String... oeuf) {
		super(especes, oeuf);
		setEspece(EspecesAnimale.Carnivore);
		setTypeEspece(TypeEspece.Carnivores);
		// TODO Auto-generated constructor stub
	}
	
	public Carnivores(Sexe sexe, double taille, double poids, int esv, List<Especes> especes) {
		super(sexe, taille, poids, esv, especes);
		setEspece(EspecesAnimale.Carnivore);
		setTypeEspece(TypeEspece.Carnivores);
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
	public void seNourir(Carnivores nourriture, List<Especes> especes) {
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
		return "Carnivores [getEspece()=" + getEspece() + ", getSexe()=" + getSexe() + ", getTaille()=" + getTaille()
				+ ", getPoids()=" + getPoids() + ", getEsperanceDeVie()=" + getEsperanceDeVie() + ", toString()="
				+ super.toString() + ", isVivant()=" + isVivant() + ", getTypeEspece()=" + getTypeEspece()
				+ ", getClass()=" + getClass() + "]";
	}

}
