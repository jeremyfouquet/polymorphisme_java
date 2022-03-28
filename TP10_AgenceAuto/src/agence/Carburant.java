package agence;

import java.util.Arrays;
import java.util.List;

public enum Carburant {
	Essence(Arrays.asList(TypeMoteur.Essence)),
	Electrique(Arrays.asList(TypeMoteur.Electrique)),
	Hybride(Arrays.asList(TypeMoteur.Essence, TypeMoteur.Electrique));
	
	private List<TypeMoteur> carburant;

	Carburant(List<TypeMoteur> carburant) {
		this.carburant = carburant;
	}

	public List<TypeMoteur> getCarburant() {
		return carburant;
	}
	
}
