/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.List;

public abstract class Vegetaux extends Especes {
	private int graineEtPollen = 1; // Utilisé lors de la reproduction; initialisé à 1 par default pour l'application test, il serait possible et plus ouvert de donner le libre choix à l'utilisateur d'initialiser lui même cet attribut

	/**
	 * @param especes // liste des especes de l'ecosysteme
	 */
	public Vegetaux(List<Especes> especes) {
		ajouterEspece(especes);
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

	@Override
	public String toString() {
		return "Vegetaux [graineEtPollen=" + graineEtPollen + ", isVivant()=" + isVivant() + ", getTypeEspece()="
				+ getTypeEspece() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
}
