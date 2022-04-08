/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.ArrayList;
import java.util.List;

public class EcoSysteme {
	private List<Especes> especes = new ArrayList<Especes>(); // Liste des especes (végétal + animal)

	public EcoSysteme() {
		
	}
	
	/** 
	 * 
	 * Affiche pour chaque espece de la liste l'index + 1, le type d'espece et s'il est vivant
	 * 
	 */
	public void voirEspeces() {
		System.out.println("\nListe des especes presentes dans l'Écosystème :\n");
		int index = 0;
		for (Especes espece : especes) {
			index++;
			System.out.printf("Espece %d: %s (%s)\n", index, espece.getTypeEspece(), espece.isVivant()?"vivant":"mort");
		}
	}
	

	// SETTER ET GETTER
	
	public List<Especes> getEspeces() {
		return especes;
	}

	public void setEspeces(List<Especes> especes) {
		this.especes = especes;
	}
	

}
