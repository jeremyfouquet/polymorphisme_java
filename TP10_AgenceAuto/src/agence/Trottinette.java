package agence;

public class Trottinette extends Vehicule {
	private int nbroues = 2;
	
	public Trottinette(int prix) {
		super(prix);
		setNbroues(this.nbroues);
	}
	public Trottinette(int prix, TypeMoteur typeMoteur) {
		super(prix, typeMoteur);
		setNbroues(this.nbroues);
		getMoteurs().add(new Electrique(125));
		setCarburant(Carburant.Electrique);
	}

	public String klaxonner() {
		String klaxonne = "Attention ATTENTION !!!";
		System.out.printf("%s %s\n", "La Trottinette fait", klaxonne);
		return klaxonne;
	}
}
