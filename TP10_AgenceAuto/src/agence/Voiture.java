/** 
 * @author Jeremy Fouquet
 */
package agence;

public class Voiture extends Vehicule {


	private int nbroues = 4;
	

	public Voiture(double prix, TypeMoteur typeMoteur) {
		super(prix, typeMoteur);
		setNbroues(this.nbroues);
		switch (typeMoteur) {
			case Essence:
				getMoteurs().add(new Essence(500));
				break;
			case Electrique:
				getMoteurs().add(new Electrique(5000));
				break;
			case Hybride:
				getMoteurs().add(new Essence(250));
				getMoteurs().add(new Electrique(2000));
				break;
		}
	}
	
	public String klaxonner() {
		String klaxonne = "TUUT TUUT";
		System.out.printf("%s %s\n", "La Voiture fait", klaxonne);
		return klaxonne;
	}
	
	//EQUALS ET TOSTRING
	
	@Override
	public String toString() {
		return "Voiture [nbroues=" + nbroues + ", nbKilometreRestant()=" + nbKilometreRestant() + ", prochainCT()="
				+ prochainCT() + ", getTypeMoteur()=" + getTypeMoteur() + ", getImmatriculation()="
				+ getImmatriculation() + ", getPrix()=" + getPrix() + ", getNbroues()=" + getNbroues()
				+ ", getNbkilometres()=" + getNbkilometres() + ", getLouejusque()=" + getLouejusque() + ", getDateCT()="
				+ getDateCT() + ", getDateMiseEnService()=" + getDateMiseEnService() + ", getMoteurs()=" + getMoteurs()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voiture other = (Voiture) obj;
		return nbroues == other.nbroues;
	}

}
