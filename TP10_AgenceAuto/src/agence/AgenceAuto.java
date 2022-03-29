/** 
 * @author Jeremy Fouquet
 */
package agence;

import java.util.ArrayList;
import java.util.List;

import exception.MonException;

public class AgenceAuto {
	public static int id; //Incrementé à chaque instance de vehicule et utilisé pour les immatriculations
	public static List<Vehicule> vehicules; // liste des vehicules en ventes
	public static List<Vehicule> vehiculesLoues; // liste des vehicules loués

	public AgenceAuto() {
		vehicules = new ArrayList<Vehicule>();
		vehiculesLoues = new ArrayList<Vehicule>();
	}
	
	/** 
	 * 	
	 * acheter un vehicule parmis la liste des vehicules en ventes
	 * 
	 * @param vehicule Vehicule supprimé de la liste des vehicules en vente
	 */
	public void achat(Vehicule vehicule) {
		vehicules.remove(vehicule);
	}
	
	/** 
	 * 	
	 * Louer un vehicule pour un nombre de kilometre
	 * 
	 * @param vehicule Vehicule à louer
	 * @param nbKilometresLoue nombre de kilometre que le vehicule pourra faire avant d'être remis en vente
	 */
	public void location(Vehicule vehicule, double nbKilometresLoue) {
		vehicule.loue(nbKilometresLoue);
		vehicules.remove(vehicule);
		vehiculesLoues.add(vehicule);
	}
	
	
	/** 
	 * 	
	 * Ajouter un vehicule à la liste des ventes
	 * 
	 * @param typeVehicule TypeVehicule à mettre en vente (Velo, Voiture, Trottinette, Moto)
	 * @param prix Prix de vente
	 * @param typeMoteur TypeMoteur optionnel (Electrique, Essence, Hybride)
	 */
	public void ajouterVehicule(TypeVehicule typeVehicule, double prix, TypeMoteur... typeMoteur) throws MonException {
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
