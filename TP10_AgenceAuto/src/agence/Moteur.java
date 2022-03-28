package agence;

import java.util.Date;

public abstract class Moteur {
	private int capaciteReservoir;
	private Date dateCT;

	public Moteur(int capaciteReservoir) {
		this.capaciteReservoir = capaciteReservoir;
		dateCT = new Date();
	}
	
	public abstract double nbKilometreRestant();
	
	protected abstract void utiliserCarburant(double deplacement);
	
	//GETTERS ET SETTERS
	public int getCapaciteReservoir() {
		return capaciteReservoir;
	}
	public Date getDateCT() {
		return dateCT;
	}
	public void setDateCT(Date dateCT) {
		this.dateCT = dateCT;
	}

}
