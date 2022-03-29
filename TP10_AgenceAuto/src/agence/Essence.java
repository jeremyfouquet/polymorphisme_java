package agence;

/** 
 * @author Jeremy Fouquet
 */
import java.util.Objects;

public class Essence extends Moteur {
	private double quantiteReservoir = 0; // carburant 1 unite == 1km

	/**
	 * @param capaciteReservoir
	 * @param type
	 */
	public Essence(int capaciteReservoir, Carburant type) {
		super(capaciteReservoir, type);
	}
	
	
	protected boolean reservoirPlein() {
		return this.quantiteReservoir >= getCapaciteReservoir();
	}

	/**
	 * 
	 * Ajoute une quantité de carburant au reservoir si celui ci n'est pas plein
	 * 
	 * @param double quantité de carburant à ajouter
	 */
	protected void ajouterCarburant(double carburant) {
		if (this.quantiteReservoir < getCapaciteReservoir()) {
			this.quantiteReservoir += carburant;
		}
	}
	
	/**
	 * 
	 * Calcule le nombre de kilometre restant en fonction de la quantité du reservoir
	 * 
	 * @return double nombre de kilometre que la capacité du reservoire offre la possibilité de faire
	 */
	protected double nbKilometreRestant() {
		double quantite = this.quantiteReservoir;
		return quantite;
	}
	
	/**
	 * 
	 * Consomme le carburant dans le reservoire en fonction du deplacement
	 * 
	 * @param deplacement deplacement convertie en fonction de l'unité du carburant
	 */
	protected void utiliserCarburant(double deplacement) {
		quantiteReservoir -= deplacement;
	}
	
	// GETTERS, SETTERS, EQUALS, TOSTRING

	public double getQuantiteReservoir() {
		return quantiteReservoir;
	}

	public void setQuantiteReservoir(double quantiteReservoir) {
		this.quantiteReservoir = quantiteReservoir;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(quantiteReservoir);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Essence other = (Essence) obj;
		return Double.doubleToLongBits(quantiteReservoir) == Double.doubleToLongBits(other.quantiteReservoir);
	}

	@Override
	public String toString() {
		return "Essence [quantiteReservoir=" + quantiteReservoir + ", getCapaciteReservoir()=" + getCapaciteReservoir()
				+ ", getTypeMoteur()=" + getTypeMoteur() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + "]";
	}

}
