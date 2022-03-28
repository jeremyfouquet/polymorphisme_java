/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.ArrayList;
import java.util.List;

public class EcoSysteme {
	public static List<Especes> especes = new ArrayList<Especes>(); // Liste des especes (végétal + animal)

	public EcoSysteme() {
	}
	
	/** 
	 * 
	 * Affiche pour chaque espece de la liste l'index + 1, le type d'espece et s'il est vivant
	 * 
	 */
	public static void voirEspeces() {
		System.out.println("\nListe des especes presentes dans l'Écosystème :\n");
		int index = 0;
		for (Especes espece : especes) {
			index++;
			System.out.printf("Espece %d: %s (%s)\n", index, espece.getTypeEspece(), espece.isVivant()?"vivant":"mort");
		}
	}
	
	/** 
	 * 
	 * Ajoute une nouvelle espece à la liste des especes de l'ecosysteme
	 * 
	 * @param espece l'espece à ajouter
	 */
	public static void ajouterEspece(Especes espece) {
		especes.add(espece);
	}
	
	/** 
	 * 
	 * Ajoute une espece à la liste des especes de l'ecosysteme
	 * 
	 * @param espece l'espece à retirer
	 */
	public static void retirerEspece(Especes espece) {
		especes.remove(espece);
	}

	/** 
	 * 
	 * Remplace un Oeuf par une Especes
	 * 
	 * @param oeuf l'oeuf à remplacer par l'espece
	 * @param espece l'espece à ajouter à la place de l'oeuf
	 */
	public static void remplacerEspece(Oeuf oeuf, Especes espece) {
		int index = especes.indexOf(oeuf);
		especes.set(index, espece);
	}
	

}
