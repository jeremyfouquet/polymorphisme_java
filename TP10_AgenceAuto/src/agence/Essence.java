package agence;

import java.util.Objects;

public class Essence extends Moteur {
	private double quantiteReservoir = 0;

	public Essence(int capaciteReservoir, Carburant type) {
		super(capaciteReservoir, type);
	}
	
	protected boolean reservoirPlein() {
		return this.quantiteReservoir == getCapaciteReservoir();
	}

	protected void ajouterCarburant(double carburant) {
		if (this.quantiteReservoir < getCapaciteReservoir()) {
			this.quantiteReservoir += carburant;
		}
	}
	
	protected double nbKilometreRestant() {
		double quantite = this.quantiteReservoir;
		return quantite;
	}
	
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
