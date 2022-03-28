package Test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import agence.AgenceAuto;
import agence.Electrique;
import agence.Essence;
import agence.TypeMoteur;
import agence.Voiture;

@DisplayName("TestSeDeplacer")
class TestSeDeplacer {
	static AgenceAuto agence;
	static Voiture voiture;
    
	@BeforeAll
	  	static void initAll(TestInfo testInfo) {
	    System.out.printf("%s\n", testInfo.getDisplayName());
	    System.out.println();
	}

	@BeforeEach
		void setUp() throws Exception {
		try {
			agence = new AgenceAuto();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterEach
		void tearDown() throws Exception {
	}

	@AfterAll
	  	static void tearDownAll() {
	    System.out.println("----------------------------------");
	}

	@Test
	@DisplayName("Test 1 : Particulier")
	void test1(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
        double km = 100;
		System.out.printf("Le vehicule souhaite se deplacer de %.1f Km sans carburant\n", km);
        voiture = new Voiture(1000, TypeMoteur.Essence);
		AgenceAuto.vehicules.add(voiture);
		double nbKmAvant = voiture.getMoteurs().get(0).nbKilometreRestant();
		voiture.seDeplacer(km);
		System.out.printf("Avant le deplacement le vehicule peut se deplacer de %.1f Km, Apres le deplacement le vehicule a parcouru %.1f Km\n", nbKmAvant, voiture.getNbkilometres());
	    boolean condition = nbKmAvant == voiture.getNbkilometres();
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 2 : Particulier")
	void test2(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
        double km = 100;
		System.out.printf("Le vehicule souhaite se deplacer de %.1f Km mais on ajoute cette fois ci %.1f unite de carburant\n", km, km/2);
        voiture = new Voiture(1000, TypeMoteur.Essence);
        Essence moteur = (Essence) voiture.getMoteurs().get(0);
        moteur.ajouterCarburant(km/2);
		AgenceAuto.vehicules.add(voiture);
		double nbKmAvant = voiture.getMoteurs().get(0).nbKilometreRestant();
		voiture.seDeplacer(km);
		System.out.printf("Avant le deplacement le vehicule peut se deplacer de %.1f Km, Apres le deplacement le vehicule a parcouru %.1f Km\n", nbKmAvant, voiture.getNbkilometres());
	    boolean condition = nbKmAvant == voiture.getNbkilometres();
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 3 : Normal")
	void test3(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
        double km = 100;
		System.out.printf("Le vehicule souhaite se deplacer de %.1f Km alors on ajoute %.1f unite de carburant\n", km, km);
        voiture = new Voiture(1000, TypeMoteur.Essence);
        Essence moteur = (Essence) voiture.getMoteurs().get(0);
        moteur.ajouterCarburant(km);
		AgenceAuto.vehicules.add(voiture);
		double nbKmAvant = voiture.getMoteurs().get(0).nbKilometreRestant();
		voiture.seDeplacer(km);
		System.out.printf("Avant le deplacement le vehicule peut se deplacer de %.1f Km, Apres le deplacement le vehicule a parcouru %.1f Km\n", nbKmAvant, voiture.getNbkilometres());
	    boolean condition = nbKmAvant == voiture.getNbkilometres();
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 4 : Normal")
	void test4(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
        double km = 100;
		System.out.printf("Le vehicule souhaite se deplacer de %.1f Km alors on ajoute %.1f unite d'Essence et %.1f unite d'Electricite\n", km, km/2, (km/2)*10);
        voiture = new Voiture(1000, TypeMoteur.Hybride);
        Essence moteur1 = (Essence) voiture.getMoteurs().get(0);
        Electrique moteur2 = (Electrique) voiture.getMoteurs().get(1);
        moteur1.ajouterCarburant(km/2);
        moteur2.ajouterCarburant((float)(km/2)*10);
		AgenceAuto.vehicules.add(voiture);
		double nbKmAvant1 = voiture.getMoteurs().get(0).nbKilometreRestant();
		double nbKmAvant2 = voiture.getMoteurs().get(1).nbKilometreRestant();
		voiture.seDeplacer(km);
		System.out.printf("Avant le deplacement le vehicule peut se deplacer de %.1f Km, Apres le deplacement le vehicule a parcouru %.1f Km\n", nbKmAvant1+nbKmAvant2, voiture.getNbkilometres());
	    boolean condition = nbKmAvant1+nbKmAvant2 == voiture.getNbkilometres();
		assertTrue(condition);
		System.out.println();
	}



}
