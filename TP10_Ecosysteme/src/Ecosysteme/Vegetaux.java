/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

public abstract class Vegetaux extends Especes {
	private int graineEtPollen = 1; // Utilisé lors de la reproduction

	public Vegetaux() {
		EcoSysteme.ajouterEspece(this);
	}
	

	/** 
	 * 
	 * Retire le nombre nécessaire de graineEtPollen pour la reproduction
	 * 
	 */
	protected abstract void enleveGraineEtPollen();

	//GETTERS, SETTERS, EQUALS, TOSTRING
	public int getGraineEtPollen() {
		return graineEtPollen;
	}
	public void setGraineEtPollen(int graineEtPollen) {
		this.graineEtPollen = graineEtPollen;
	}
	@Override
	public String toString() {
		return "Vegetaux [graineEtPollen=" + graineEtPollen + ", isVivant()=" + isVivant() + ", getTypeEspece()="
				+ getTypeEspece() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vegetaux other = (Vegetaux) obj;
		return graineEtPollen == other.graineEtPollen;
	}

}
