package agence;

public class Moto extends Vehicule {
	private int nbroues = 2;
	

	public Moto(int prix, TypeMoteur typeMoteur) {
		super(prix, typeMoteur);
		setNbroues(this.nbroues);
		switch (typeMoteur) {
			case Essence:
				getMoteurs().add(new Essence(125));
				setCarburant(Carburant.Essence);
				break;
			case Electrique:
				getMoteurs().add(new Electrique(1250));
				setCarburant(Carburant.Electrique);
				break;
			case Hybride:
				getMoteurs().add(new Essence(65));
				getMoteurs().add(new Electrique(600));
				setCarburant(Carburant.Hybride);
				break;
			default:
				break;
		}
		
	}

	public String klaxonner() {
		String klaxonne = "POUET POUET";
		System.out.printf("%s %s\n", "La Moto fait", klaxonne);
		return klaxonne;
	}
}