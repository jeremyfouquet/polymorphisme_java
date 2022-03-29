package agence;

public class Voiture extends Vehicule {
	private int nbroues = 4;
	

	public Voiture(int prix, TypeMoteur typeMoteur) {
		super(prix, typeMoteur);
		setNbroues(this.nbroues);
		switch (typeMoteur) {
			case Essence:
				getMoteurs().add(new Essence(500, Carburant.Essence));
				setCarburant(TypeMoteur.Essence);
				break;
			case Electrique:
				getMoteurs().add(new Electrique(5000, Carburant.Electrique));
				setCarburant(TypeMoteur.Electrique);
				break;
			case Hybride:
				getMoteurs().add(new Essence(250, Carburant.Essence));
				getMoteurs().add(new Electrique(2000, Carburant.Electrique));
				setCarburant(TypeMoteur.Hybride);
				break;
			default:
				break;
		}
	}
	
	public String klaxonner() {
		String klaxonne = "TUUT TUUT";
		System.out.printf("%s %s\n", "La Voiture fait", klaxonne);
		return klaxonne;
	}

}
