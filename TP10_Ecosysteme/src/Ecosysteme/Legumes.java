package Ecosysteme;

import exception.MonException;

public class Legumes extends Vegetaux {

	public Legumes() {
		super();
	}

	//	Les fleurs utiliseront une quantité de pollen qui se divisera par 2 à
	//	chaque reproduction. De plus, pour réaliser cela elles nécessiteront
	//	une autre fleur.
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
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
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
