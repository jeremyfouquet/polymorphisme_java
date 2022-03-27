/**
 * @author Jeremy Fouquet
 */
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Tests test = new Tests();
		
		test.testSeReproduireFleur("SeReproduire(Fleurs)");
		test.testSeReproduireLegume("SeReproduireLegume()");
		
		test.testSeNourirHerbivore("SeNourir(Vegetaux)");
		test.testSeNourirCharognard("SeNourir(Animaux)");
		test.testSeNourirOmnivore("SeNourir(Herbivores|Vegetaux|Carnivores|Oeufs)");
		test.testSeNourirCarnivore("SeNourir(Herbivores|Carnivore)");
		
		test.testSeReproduireOvipare("SeReproduire(Ovipare)");
		test.testSeReproduireVivipare("SeReproduireVivipare()");
		test.testFertiliseOeuf("Fertilise(Oeuf)");
		
		test.testAjouterEtVoir("ajouterEtVoir()");
		
	}


}
