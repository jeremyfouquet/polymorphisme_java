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
//		Animaux monCarnivore = new Animaux(EspecesAnimale.Carnivore);
//		Animaux monOmnivore = new Animaux(EspecesAnimale.Omnivore);
//		Animaux monHerbivore = new Animaux(EspecesAnimale.Herbivore);
//		Animaux monCharognad = new Animaux(EspecesAnimale.Charognard);

	}
	
	public void voirEspeces() {
		for (Especes espece : especes) {
			System.out.printf("Espece : %s\n", espece.getClass().getSimpleName());
		}
	}
	
	public static void ajouterEspece(Especes espece) {
		especes.add(espece);
	}
	
	public static void retirerEspece(Especes espece) {
		especes.remove(espece);
	}

}
