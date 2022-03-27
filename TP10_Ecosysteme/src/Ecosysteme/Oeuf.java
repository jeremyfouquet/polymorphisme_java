/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

public class Oeuf extends Especes {
	private boolean eclos = false;
	private EspecesAnimale espece;
	//	Ajouter l'objet œuf, cet objet aura des caractéristiques par défaut tant
	//	qu'il n'a pas été fertilisé par un mal de son espèce et disparaîtra de
	//	son environnement pour laisser place à un animal une fois éclos.
	//	À noter que celui-ci peut être consommé par les animaux omnivores.
	public Oeuf(EspecesAnimale espece) {
		this.espece = espece;
		setTypeEspece(TypeEspece.Oeuf);
		EcoSysteme.ajouterEspece(this);
	}

	public void eclos() {
		this.eclos = true;
		Especes eclosion = null;
		switch (this.espece) {
			case Carnivore:
				eclosion = new Carnivores("oeuf");
				break;
			case Omnivore:
				eclosion = new Omnivores("oeuf");
				break;
			case Herbivore:
				eclosion = new Herbivores("oeuf");
				break;
			case Charognard:
				eclosion = new Charognards("oeuf");
				break;
			default:
				break;
		}
		EcoSysteme.remplacerEspece(this, eclosion);
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
