package agence;

import java.util.Arrays;
import java.util.List;

public enum TypeMoteur {
	Essence(Arrays.asList(Carburant.Essence)),
	Electrique(Arrays.asList(Carburant.Electrique)),
	Hybride(Arrays.asList(Carburant.Essence, Carburant.Electrique));
	
	private List<Carburant> carburant;

	TypeMoteur(List<Carburant> carburant) {
		this.carburant = carburant;
	}

	public List<Carburant> getCarburant() {
		return carburant;
	}
	
}
