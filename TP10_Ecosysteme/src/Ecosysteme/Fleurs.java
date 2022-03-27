/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import exception.MonException;

public class Fleurs extends Vegetaux {

	private boolean eclos = false;

	public Fleurs() {
		super();
	}
	
	//	Les fleurs utiliseront une quantité de pollen qui se divisera par 2 à
	//	chaque reproduction. De plus, pour réaliser cela elles nécessiteront
	//	une autre fleur.
	public void seReproduire(Fleurs fleur) throws MonException {
		if(this.eclos != true) {
			throw new MonException("Reproduction impossible : La fleur n'est pas eclos !");
		} else if (getGraineEtPollen() == 0) {
			throw new MonException("Reproduction impossible : Pollen insuffisant !");
		} else if (this.equals(fleur)) {
			throw new MonException("Reproduction impossible : Une fleur ne peut se reproduire avec elle même !");
		} else if (this.isVivant() != true || fleur.isVivant() != true) {
			throw new MonException("Reproduction impossible : La fleur est morte !");
		} else {
			new Fleurs();
			enleveGraineEtPollen();
		}
	}
	
	public void eclore(boolean eclore) {
		this.eclos = eclore;
	}
	
	protected void enleveGraineEtPollen() {
		setGraineEtPollen(getGraineEtPollen()/2);
	}

	//GETTERS, SETTERS, EQUALS, TOSTRING
	public boolean isEclos() {
		return eclos;
	}
	public void setEclos(boolean eclos) {
		this.eclos = eclos;
	}	
	@Override
	public String toString() {
		return "Fleurs [eclos=" + eclos + ", getGraineEtPollen()=" + getGraineEtPollen() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fleurs other = (Fleurs) obj;
		return eclos == other.eclos;
	}

}
