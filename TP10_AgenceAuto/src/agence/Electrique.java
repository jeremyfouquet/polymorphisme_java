/** 
 * @author Jeremy Fouquet
 */
package agence;


public class Electrique extends Moteur {
	private float quantiteReservoir = 0; // carburant 10 unite == 1km

	/**
	 * @param capaciteReservoir
	 */
	public Electrique(int capaciteReservoir) {
		super(capaciteReservoir);
		setCarburant(Carburant.Electrique);
	}
	
	protected boolean reservoirPlein() {
		return this.quantiteReservoir >= getCapaciteReservoir();
	}

	/**
	 * 
	 * Ajoute une quntité de carburant au reservoir si celui ci n'est pas plein
	 * 
	 * @param float quantité de carburant à ajouter
	 */
	protected void ajouterCarburant(float carburant) {
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
		double quantite = (double) this.quantiteReservoir / 10;
		return quantite;
	}
	
	/**
	 * 
	 * Consomme le carburant dans le reservoire en fonction du deplacement
	 * 
	 * @param deplacement deplacement convertie en fonction de l'unité du carburant
	 */
	protected void utiliserCarburant(double deplacement) {
		float convertion = (float) deplacement * 10;
		quantiteReservoir -= convertion;
	}
	
	// GETTERS, SETTERS, EQUALS, TOSTRING

	public float getQuantiteReservoir() {
		return quantiteReservoir;
	}

	public void setQuantiteReservoir(float quantiteReservoir) {
		this.quantiteReservoir = quantiteReservoir;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Electrique other = (Electrique) obj;
		return Float.floatToIntBits(quantiteReservoir) == Float.floatToIntBits(other.quantiteReservoir);
	}
	
	@Override
	public String toString() {
		return "Electrique [quantiteReservoir=" + quantiteReservoir + ", getCapaciteReservoir()="
				+ getCapaciteReservoir() + ", getCarburant()=" + getCarburant() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}

}
