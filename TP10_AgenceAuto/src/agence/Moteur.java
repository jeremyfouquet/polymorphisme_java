/** 
 * @author Jeremy Fouquet
 */
package agence;

import java.util.Objects;

public abstract class Moteur {
	private Carburant carburant; // carburant nécéssaire au moteur (Electrique, Essence, Hybride)
	private int capaciteReservoir; // capacité maximum du reservoir

	/**
	 * @param capaciteReservoir
	 * @param typeMoteur
	 */
	public Moteur(int capaciteReservoir, Carburant typeMoteur) {
		this.capaciteReservoir = capaciteReservoir;
		this.carburant = typeMoteur;
	}
	
	/**
	 * 
	 * Verifie si le reservoire est plein
	 * 
	 * @return boolean si le reservoire est plein true sinon false
	 */
	protected abstract boolean reservoirPlein();

	/**
	 * 
	 * Convertie la quantité du reservoire en nombre de kilometre pouvant être réalisé par le vehicule
	 * 
	 * @return double nombre de kilometre que la capacité du reservoire offre la possibilité de faire
	 */
	protected abstract double nbKilometreRestant();
	
	/**
	 * 
	 * Consomme le carburant dans le reservoire en fonction du deplacement
	 * 
	 * @param deplacement deplacement realisé qui consomme le carburant
	 */
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
