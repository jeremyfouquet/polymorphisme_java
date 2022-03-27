/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

public abstract class Especes {
	private TypeEspece typeEspece;
	private boolean vivant = true;

	public Especes() {
		// TODO Auto-generated constructor stub
	}
	
	protected void estMange() {
		mourir();
		EcoSysteme.retirerEspece(this);
	}

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
