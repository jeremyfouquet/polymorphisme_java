package agence;

public class Velo extends Vehicule {
	private int nbroues = 2;
	
	public Velo(int prix) {
		super(prix);
		setNbroues(this.nbroues);
	}
	public Velo(int prix, TypeMoteur typeMoteur) {
		super(prix, typeMoteur);
		setNbroues(this.nbroues);
		getMoteurs().add(new Electrique(125, Carburant.Electrique));
		setCarburant(TypeMoteur.Electrique);
	}

	public String klaxonner() {
		String klaxonne = "DRING DRING";
		System.out.printf("%s %s\n", "Le Velo fait", klaxonne);
		return klaxonne;
	}
}
