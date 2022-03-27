/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.ArrayList;
import java.util.List;

public class EcoSysteme {
	public static List<Especes> especes = new ArrayList<Especes>();
//	Implémenter votre environnement, celui-ci possédera une liste
//	d'espèces (végétal + animal) et pourra ajouter, retirer ou afficher les
//	espèces de cette liste.
	public EcoSysteme() {
	}
	
	public static void voirEspeces() {
		System.out.println("\nListe des especes presentes dans l'Écosystème :\n");
		int index = 0;
		for (Especes espece : especes) {
			index++;
			System.out.printf("Espece %d: %s (%s)\n", index, espece.getTypeEspece(), espece.isVivant()?"vivant":"mort");
		}
	}
	
	public static void ajouterEspece(Especes espece) {
		especes.add(espece);
	}
	
	public static void retirerEspece(Especes espece) {
		especes.remove(espece);
	}
	
	public static void remplacerEspece(Oeuf oeuf, Especes espece) {
		int index = especes.indexOf(oeuf);
		especes.set(index, espece);
	}
	

}
