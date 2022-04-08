/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.List;

public class Oeuf extends Especes {
	private boolean eclos = false; // false par defaut et true lorsque l'animal sort de l'oeuf
	private EspecesAnimale espece; // permet de determiner quel espece sera instancier à partir de l'oeuf

	/**
	 * @param espece
	 * @param especes liste des especes de l'ecosysteme
	 */
	public Oeuf(EspecesAnimale espece, List<Especes> especes) {
		this.espece = espece;
		setTypeEspece(TypeEspece.Oeuf);
		ajouterEspece(especes);
	}

	/** 
	 * 
	 * Fait eclore l'oeuf
	 * 
	 * @param especes liste des especes de l'ecosysteme
	 * @see EcoSysteme#remplacerEspece(Oeuf, Especes)
	 */
	public void eclos(List<Especes> especes) {
		this.eclos = true;
		Especes eclosion = null;
		switch (this.espece) {
			case Carnivore:
				eclosion = new Carnivores(especes, "oeuf");
				break;
			case Omnivore:
				eclosion = new Omnivores(especes, "oeuf");
				break;
			case Herbivore:
				eclosion = new Herbivores(especes, "oeuf");
				break;
			case Charognard:
				eclosion = new Charognards(especes, "oeuf");
				break;
			default:
				break;
		}
		remplacerEspece(eclosion, especes);
	}
	
	/** 
	 * 
	 * Remplace un Oeuf par une Especes
	 * 
	 * @param especes listes des epseces de l'ecosysteme
	 * @param espece l'espece à ajouter à la place de l'oeuf
	 */
	private void remplacerEspece(Especes espece, List<Especes> especes) {
		int index = especes.indexOf(this);
		especes.set(index, espece);
	}

	//GETTERS, SETTERS, EQUALS, TOSTRING
	
	public boolean isEclos() {
		return eclos;
	}
	public EspecesAnimale getEspece() {
		return espece;
	}

	public void setEspece(EspecesAnimale espece) {
		this.espece = espece;
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
		Oeuf other = (Oeuf) obj;
		return eclos == other.eclos && espece == other.espece;
	}
	@Override
	public String toString() {
		return "Oeuf [eclos=" + eclos + ", espece=" + espece + ", isVivant()=" + isVivant() + ", getTypeEspece()="
				+ getTypeEspece() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}


}
