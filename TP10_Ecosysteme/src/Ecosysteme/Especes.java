/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.List;

public abstract class Especes {
	private TypeEspece typeEspece; // type d'espece
	private boolean vivant = true; // true par defaut

	public Especes() {
	}
	

	/** 
	 * 
	 * L'attribut vivant est affecté à false
	 * 
	 */
	public void mourir() {
		this.vivant = false;
	}
	
	/** 
	 * 
	 * Lorsque l'espece est mangé alors elle est retiré de la liste de l'ecosysteme
	 * 
	 * @params especes liste des especes de l'ecosysteme
	 * @see EcoSysteme#retirerEspece(Especes)
	 */
	protected void estMange(List<Especes> especes) {
		retirerEspece(especes);
	}
	
	/** 
	 * 
	 * Ajoute une nouvelle espece à la liste des especes de l'ecosysteme
	 * 
	 * @param especes listes des espeses présentes dans l'écosysteme
	 */
	protected void ajouterEspece(List<Especes> especes) {
		especes.add(this);
	}
	
	/** 
	 * 
	 * Retire une espece à la liste des especes de l'ecosysteme
	 * 
	 * @param especes liste des especes de l'ecosysteme
	 */
	private void retirerEspece(List<Especes> especes) {
		especes.remove(this);
	}

	//GETTERS, SETTERS, EQUALS, TOSTRING
	public boolean isVivant() {
		return vivant;
	}
	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}
	public TypeEspece getTypeEspece() {
		return typeEspece;
	}

	public void setTypeEspece(TypeEspece typeEspece) {
		this.typeEspece = typeEspece;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especes other = (Especes) obj;
		return typeEspece == other.typeEspece && vivant == other.vivant;
	}
	@Override
	public String toString() {
		return "Especes [typeEspece=" + typeEspece + ", vivant=" + vivant + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
		
}
