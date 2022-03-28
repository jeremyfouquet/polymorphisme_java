package agence;

import java.util.ArrayList;
import java.util.List;

import exception.MonException;

public class AgenceAuto {
	public static int id;
	public static List<Vehicule> vehicules;
	public static List<Vehicule> vehiculesLoues;

	public AgenceAuto() {
		vehicules = new ArrayList<Vehicule>();
		vehiculesLoues = new ArrayList<Vehicule>();
	}
	
	public void achat(Vehicule vehicule) {
		vehicules.remove(vehicule);
	}
	
	public void location(Vehicule vehicule, double nbKilometresLoue) {
		vehicule.loue(nbKilometresLoue);
		vehicules.remove(vehicule);
		vehiculesLoues.add(vehicule);
	}
	
	public void ajouterVehicule(TypeVehicule typeVehicule, int prix, TypeMoteur... typeMoteur) throws MonException {
		TypeMoteur moteur = null;
		boolean ismoteur = false;
		for (TypeMoteur tm : typeMoteur) {
			moteur = tm;
			ismoteur = true;
		}
		Vehicule vehicule = null;
		switch (typeVehicule) {
			case Moto:
				if(ismoteur) {
					vehicule = new Moto(prix, moteur);
				} else {
					throw new MonException("Il y a besoin d'un moteur pour créer ce vehicule");
				}
				break;
			case Voiture:
				if(ismoteur) {
					vehicule = new Voiture(prix, moteur);
				} else {
					throw new MonException("Il y a besoin d'un moteur pour créer ce vehicule");
				}
				break;
			case Velo:
				if(ismoteur) {
					vehicule = new Velo(prix, moteur);
				} else {
					vehicule = new Velo(prix);
				}
				break;
			case Trottinette:
				if(ismoteur) {
					vehicule = new Trottinette(prix, moteur);
				} else {
					vehicule = new Trottinette(prix);
				}
				break;
			default :
				break;
		}
		if(null != vehicule) {
			vehicules.add(vehicule);
		} else {
			throw new MonException("Le vehicule n'a pas été ajouté");
		}
	}

}
