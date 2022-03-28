/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import exception.MonException;

public class Legumes extends Vegetaux {

	public Legumes() {
		super();
		setTypeEspece(TypeEspece.Legumes);
	}

	/** 
	 * 
	 * Créé une nouvelle instance de Legumes
	 * 
	 * @see #enleveGraineEtPollen()
	 * @exception MonException Si plus de graineEtPollen
	 */
	public void seReproduire() throws MonException {
		if (getGraineEtPollen() == 0) {
			throw new MonException("Reproduction impossible : Il n'y a plus de graine !");
		} else {
			new Legumes();
			enleveGraineEtPollen();
		}
	}
	
	protected void enleveGraineEtPollen() {
		setGraineEtPollen(getGraineEtPollen()-1);
	}

	//GETTERS, SETTERS, EQUALS, TOSTRING

	@Override
	public String toString() {
		return "Legumes [getGraineEtPollen()=" + getGraineEtPollen() + ", toString()=" + super.toString()
				+ ", isVivant()=" + isVivant() + ", getTypeEspece()=" + getTypeEspece() + ", getClass()=" + getClass()
				+ "]";
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
