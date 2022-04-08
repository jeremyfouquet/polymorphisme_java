/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.List;

import exception.ActionException;

public class Charognards extends Animaux {

	public Charognards(List<Especes> especes, String... oeuf) {
		super(especes, oeuf);
		setEspece(EspecesAnimale.Charognard);
		setTypeEspece(TypeEspece.Charognards);
		// TODO Auto-generated constructor stub
	}
	
	public Charognards(Sexe sexe, double taille, double poids, int esv, List<Especes> especes) {
		super(sexe, taille, poids, esv, especes);
		setEspece(EspecesAnimale.Charognard);
		setTypeEspece(TypeEspece.Charognards);
	}
	
	/** 
	 * 
	 * Se nourrit
	 * 
	 * @param nourriture qui est consommée
	 * @param especes liste des especes de l'ecosysteme
	 * @exception ActionException nourriture est vivant
	 * @see Especes#estMange()
	 */
	public void seNourir(Animaux nourriture, List<Especes> especes) throws ActionException {
		if (nourriture.isVivant()) {
			throw new ActionException("Se nourir est impossible : l'animal n'est pas mort !");
		} else {
			nourriture.estMange(especes);
		}
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
		return "Charognards [getEspece()=" + getEspece() + ", getSexe()=" + getSexe() + ", getTaille()=" + getTaille()
				+ ", getPoids()=" + getPoids() + ", getEsperanceDeVie()=" + getEsperanceDeVie() + ", toString()="
				+ super.toString() + ", isVivant()=" + isVivant() + ", getTypeEspece()=" + getTypeEspece()
				+ ", getClass()=" + getClass() + "]";
	}

}
