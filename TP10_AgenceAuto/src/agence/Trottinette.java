/** 
 * @author Jeremy Fouquet
 */
package agence;


public class Trottinette extends Vehicule {


	private int nbroues = 2;
	
	public Trottinette(double prix) {
		super(prix);
		setNbroues(this.nbroues);
	}
	public Trottinette(double prix, TypeMoteur typeMoteur) {
		super(prix, typeMoteur);
		setNbroues(this.nbroues);
		getMoteurs().add(new Electrique(125));
	}

	public String klaxonner() {
		String klaxonne = "Attention ATTENTION !!!";
		System.out.printf("%s %s\n", "La Trottinette fait", klaxonne);
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
		Trottinette other = (Trottinette) obj;
		return nbroues == other.nbroues;
	}
	
	@Override
	public String toString() {
		return "Trottinette [nbroues=" + nbroues + ", nbKilometreRestant()=" + nbKilometreRestant() + ", prochainCT()="
				+ prochainCT() + ", getTypeMoteur()=" + getTypeMoteur() + ", getImmatriculation()="
				+ getImmatriculation() + ", getPrix()=" + getPrix() + ", getNbroues()=" + getNbroues()
				+ ", getNbkilometres()=" + getNbkilometres() + ", getLouejusque()=" + getLouejusque() + ", getDateCT()="
				+ getDateCT() + ", getDateMiseEnService()=" + getDateMiseEnService() + ", getMoteurs()=" + getMoteurs()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
}
