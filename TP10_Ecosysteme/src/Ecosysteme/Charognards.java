/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import exception.MonException;

public class Charognards extends Animaux {

	public Charognards(String... oeuf) {
		super(oeuf);
		setEspece(EspecesAnimale.Charognard);
		setTypeEspece(TypeEspece.Charognards);
		// TODO Auto-generated constructor stub
	}
	
	public Charognards(Sexe sexe, double taille, double poids, int esv) {
		super(sexe, taille, poids, esv);
		setEspece(EspecesAnimale.Charognard);
		setTypeEspece(TypeEspece.Charognards);
	}
	
	/** 
	 * 
	 * Se nourrit
	 * 
	 * @param nourriture qui est consommée
	 * @exception MonException nourriture est vivant
	 * @see Especes#estMange()
	 */
	public void seNourir(Animaux nourriture) throws MonException {
		if (nourriture.isVivant()) {
			throw new MonException("Se nourir est impossible : l'animal n'est pas mort !");
		} else {
			nourriture.estMange();
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
