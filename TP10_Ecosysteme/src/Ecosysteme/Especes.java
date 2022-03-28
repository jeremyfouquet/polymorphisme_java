/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

public abstract class Especes {
	private TypeEspece typeEspece; // type d'espece
	private boolean vivant = true; // true par defaut

	public Especes() {
	}
	
	/** 
	 * 
	 * Lorsque l'espece est mangé alors elle meurt puis elle est retiré de la liste de l'ecosysteme
	 * 
	 * @see #mourir()
	 * @see EcoSysteme#retirerEspece(Especes)
	 */
	protected void estMange() {
		mourir();
		EcoSysteme.retirerEspece(this);
	}

	/** 
	 * 
	 * L'attribut vivant est affecté à false
	 * 
	 */
	public void mourir() {
		this.vivant = false;
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
	public String toString() {
		return "Especes [typeEspece=" + typeEspece + ", vivant=" + vivant + "]";
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
		
}
