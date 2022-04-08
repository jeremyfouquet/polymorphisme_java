/** 
 * @author Jeremy Fouquet
 */
package agence;

public abstract class Moteur {
	private Carburant carburant;
	private int capaciteReservoir; // capacité maximum du reservoir

	/**
	 * @param capaciteReservoir
	 */
	public Moteur(int capaciteReservoir) {
		this.capaciteReservoir = capaciteReservoir;
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
	
	public Carburant getCarburant() {
		return carburant;
	}

	public void setCarburant(Carburant carburant) {
		this.carburant = carburant;
	}

	public void setCapaciteReservoir(int capaciteReservoir) {
		this.capaciteReservoir = capaciteReservoir;
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
		return capaciteReservoir == other.capaciteReservoir;
	}
	
	@Override
	public String toString() {
		return "Moteur [capaciteReservoir=" + capaciteReservoir + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
}
