/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.ArrayList;
import java.util.List;

public class EcoSysteme {
	public static List<Especes> especes = new ArrayList<Especes>();

	public EcoSysteme() {
//		Animaux monCarnivore = new Animaux(EspecesAnimale.Carnivore);
//		Animaux monOmnivore = new Animaux(EspecesAnimale.Omnivore);
//		Animaux monHerbivore = new Animaux(EspecesAnimale.Herbivore);
//		Animaux monCharognad = new Animaux(EspecesAnimale.Charognard);

	}
	
	public void voirEcoSysteme() {
		for (Especes espece : especes) {
//			Carnivores c = (Carnivores) espece;
			System.out.printf("%s\n", espece.getClass().getSimpleName());
//			System.out.printf("%s\n", c.getSexe());
		}
	}

}
