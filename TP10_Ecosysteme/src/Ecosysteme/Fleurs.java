/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.List;

import exception.ActionException;

public class Fleurs extends Vegetaux {

	private boolean eclos = false; // false par defaut, la reproduction n'est possible que l'orsque cet attribut est true

	public Fleurs(List<Especes> especes) {
		super(especes);
		setTypeEspece(TypeEspece.Fleurs);
	}
	
	/** 
	 * 
	 * Créé une nouvelle instance de Fleurs
	 * 
	 * @param especes liste des especes de l'ecosysteme
	 * @param fleur l'espece à ajouter à la place de l'oeuf
	 * @see #enleveGraineEtPollen()
	 * @exception ActionException Si eclos est false
	 * @exception ActionException Si plus de graineEtPollen
	 * @exception ActionException Si this.equals(fleur)
	 * @exception ActionException Si this ou fleur est mort
	 */
	public void seReproduire(Fleurs fleur, List<Especes> especes) throws ActionException {
		if(this.eclos != true) {
			throw new ActionException("Reproduction impossible : La fleur n'est pas eclos !");
		} else if (getGraineEtPollen() == 0) {
			throw new ActionException("Reproduction impossible : Pollen insuffisant !");
		} else if (this.equals(fleur)) {
			throw new ActionException("Reproduction impossible : Une fleur ne peut se reproduire avec elle même !");
		} else if (this.isVivant() != true || fleur.isVivant() != true) {
			throw new ActionException("Reproduction impossible : La fleur est morte !");
		} else {
			new Fleurs(especes);
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
	@Override
	public String toString() {
		return "Fleurs [eclos=" + eclos + ", getGraineEtPollen()=" + getGraineEtPollen() + ", toString()="
				+ super.toString() + ", isVivant()=" + isVivant() + ", getTypeEspece()=" + getTypeEspece()
				+ ", getClass()=" + getClass() + "]";
	}

}
