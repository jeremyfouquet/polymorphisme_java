package agence;

import java.util.Objects;

public abstract class Moteur {
	private Carburant typeMoteur;


	private int capaciteReservoir;

	public Moteur(int capaciteReservoir, Carburant typeMoteur) {
		this.capaciteReservoir = capaciteReservoir;
		this.typeMoteur = typeMoteur;
	}
	
	protected abstract boolean reservoirPlein();

	protected abstract double nbKilometreRestant();
	
	protected abstract void utiliserCarburant(double deplacement);
	
	// GETTERS, SETTERS, EQUALS, TOSTRING

	public int getCapaciteReservoir() {
		return capaciteReservoir;
	}

	public Carburant getTypeMoteur() {
		return typeMoteur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capaciteReservoir, typeMoteur);
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
		return capaciteReservoir == other.capaciteReservoir && typeMoteur == other.typeMoteur;
	}
	
	@Override
	public String toString() {
		return "Moteur [typeMoteur=" + typeMoteur + ", capaciteReservoir=" + capaciteReservoir + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}
}
