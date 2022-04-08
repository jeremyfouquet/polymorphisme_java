/** 
 * @author Jeremy Fouquet
 */
package agence;


public class Moto extends Vehicule {

	private int nbroues = 2;
	

	public Moto(double prix, TypeMoteur typeMoteur) {
		super(prix, typeMoteur);
		setNbroues(this.nbroues);
		switch (typeMoteur) {
			case Essence:
				getMoteurs().add(new Essence(125));
				break;
			case Electrique:
				getMoteurs().add(new Electrique(1250));
				break;
			case Hybride:
				getMoteurs().add(new Essence(65));
				getMoteurs().add(new Electrique(600));
				break;
		}
		
	}

	public String klaxonner() {
		String klaxonne = "POUET POUET";
		System.out.printf("%s %s\n", "La Moto fait", klaxonne);
		return klaxonne;
	}
	
	// EQUALS ET TOSTRING

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moto other = (Moto) obj;
		return nbroues == other.nbroues;
	}
	@Override
	public String toString() {
		return "Moto [nbroues=" + nbroues + ", nbKilometreRestant()=" + nbKilometreRestant() + ", prochainCT()="
				+ prochainCT() + ", getTypeMoteur()=" + getTypeMoteur() + ", getImmatriculation()="
				+ getImmatriculation() + ", getPrix()=" + getPrix() + ", getNbroues()=" + getNbroues()
				+ ", getNbkilometres()=" + getNbkilometres() + ", getLouejusque()=" + getLouejusque() + ", getDateCT()="
				+ getDateCT() + ", getDateMiseEnService()=" + getDateMiseEnService() + ", getMoteurs()=" + getMoteurs()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}


}
