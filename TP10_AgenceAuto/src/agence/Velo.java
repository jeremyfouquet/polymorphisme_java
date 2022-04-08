/** 
 * @author Jeremy Fouquet
 */
package agence;


public class Velo extends Vehicule {


	private int nbroues = 2;
	
	public Velo(double prix) {
		super(prix);
		setNbroues(this.nbroues);
	}
	public Velo(double prix, TypeMoteur typeMoteur) {
		super(prix, TypeMoteur.Electrique);
		setNbroues(this.nbroues);
		getMoteurs().add(new Electrique(125));
	}

	public String klaxonner() {
		String klaxonne = "DRING DRING";
		System.out.printf("%s %s\n", "Le Velo fait", klaxonne);
		return klaxonne;
	}
	
	//EQUALS ET TOSTRING
	
	@Override
	public String toString() {
		return "Velo [nbroues=" + nbroues + ", nbKilometreRestant()=" + nbKilometreRestant() + ", prochainCT()="
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
		Velo other = (Velo) obj;
		return nbroues == other.nbroues;
	}
}
