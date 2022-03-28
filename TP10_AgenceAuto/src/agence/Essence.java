package agence;


public class Essence extends Moteur {
	private double quantiteReservoir = 0;

	public Essence(int capaciteReservoir) {
		super(capaciteReservoir);
	}
	
	public void ajouterCarburant(double carburant) {
		this.quantiteReservoir += carburant;
	}
	
	public double nbKilometreRestant() {
		double quantite = this.quantiteReservoir;
		return quantite;
	}
	
	protected void utiliserCarburant(double deplacement) {
		quantiteReservoir -= deplacement;
	}
	
	// GETTERS ET SETTERS

	public double getQuantiteReservoir() {
		return quantiteReservoir;
	}

	public void setQuantiteReservoir(double quantiteReservoir) {
		this.quantiteReservoir = quantiteReservoir;
	}

}
