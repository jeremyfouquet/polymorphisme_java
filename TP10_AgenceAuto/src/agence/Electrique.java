package agence;


public class Electrique extends Moteur {
	private float quantiteReservoir = 0;

	public Electrique(int capaciteReservoir) {
		super(capaciteReservoir);
	}
	
	public void ajouterCarburant(float carburant) {
		this.quantiteReservoir += carburant;
	}
	
	public double nbKilometreRestant() {
		double quantite = (double) this.quantiteReservoir / 10;
		return quantite;
	}
	
	protected void utiliserCarburant(double deplacement) {
		float convertion = (float) deplacement * 10;
		quantiteReservoir -= convertion;
	}
	
	// GETTERS ET SETTERS

	public float getQuantiteReservoir() {
		return quantiteReservoir;
	}

	public void setQuantiteReservoir(float quantiteReservoir) {
		this.quantiteReservoir = quantiteReservoir;
	}

}
