package agence;

import java.util.Objects;

public abstract class Moteur {
	private Carburant carburant;
	private int capaciteReservoir;

	public Moteur(int capaciteReservoir, Carburant typeMoteur) {
		this.capaciteReservoir = capaciteReservoir;
		this.carburant = typeMoteur;
	}
	
	protected abstract boolean reservoirPlein();

	protected abstract double nbKilometreRestant();
	
	protected abstract void utiliserCarburant(double deplacement);
	
	// GETTERS, SETTERS, EQUALS, TOSTRING

	public int getCapaciteReservoir() {
		return capaciteReservoir;
	}

	public Carburant getTypeMoteur() {
		return carburant;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capaciteReservoir, carburant);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moteur other = (Moteur) obj;
		return capaciteReservoir == other.capaciteReservoir && carburant == other.carburant;
	}
	
	@Override
	public String toString() {
		return "Moteur [carburant=" + carburant + ", capaciteReservoir=" + capaciteReservoir + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}
}
