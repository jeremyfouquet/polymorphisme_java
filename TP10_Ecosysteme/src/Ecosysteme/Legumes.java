/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.List;

import exception.ActionException;

public class Legumes extends Vegetaux {

	public Legumes(List<Especes> especes) {
		super(especes);
		setTypeEspece(TypeEspece.Legumes);
	}

	/** 
	 * 
	 * Créé une nouvelle instance de Legumes
	 * 
	 * @param especes liste des especes de l'ecosysteme
	 * @see #enleveGraineEtPollen()
	 * @exception ActionException Si plus de graineEtPollen
	 */
	public void seReproduire(List<Especes> especes) throws ActionException {
		if (getGraineEtPollen() == 0) {
			throw new ActionException("Reproduction impossible : Il n'y a plus de graine !");
		} else {
			new Legumes(especes);
			enleveGraineEtPollen();
		}
	}
	
	/** 
	 * 
	 * decremente la graineEtPollen de 1
	 * 
	 */
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
