/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import exception.MonException;

public class Fleurs extends Vegetaux {

	private boolean eclos = false; // false par defaut, la reproduction n'est possible que l'orsque cet attribut est true

	public Fleurs() {
		super();
		setTypeEspece(TypeEspece.Fleurs);
	}
	
	/** 
	 * 
	 * Créé une nouvelle instance de Fleurs
	 * 
	 * @param fleur l'espece à ajouter à la place de l'oeuf
	 * @see #enleveGraineEtPollen()
	 * @exception MonException Si eclos est false
	 * @exception MonException Si plus de graineEtPollen
	 * @exception MonException Si this.equals(fleur)
	 * @exception MonException Si this ou fleur est mort
	 */
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
	
	/** 
	 * 
	 * Fait eclore la fleur
	 * 
	 */
	public void eclore() {
		this.eclos = true;
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
				+ super.toString() + ", isVivant()=" + isVivant() + ", getTypeEspece()=" + getTypeEspece()
				+ ", getClass()=" + getClass() + "]";
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
