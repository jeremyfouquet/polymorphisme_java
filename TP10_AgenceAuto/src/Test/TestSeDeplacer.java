package Test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import agence.*;
import exception.MonException;

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
		double nbKmAvant = voiture.nbKilometreRestant();
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
		AgenceAuto.vehicules.add(voiture);
		double nbKmAvant = voiture.getNbkilometres();
        try {
			voiture.ajouterCarburant(km/2, Carburant.Essence);
			voiture.seDeplacer(km);
		} catch (MonException e) {
			System.out.printf("%s\n", e.getMessage());
		}
		double nbKmApres = voiture.getNbkilometres();
		System.out.printf("Avant le deplacement le vehicule à un compteur à %.1f Km, Apres le deplacement le vehicule a un compteur à %.1f Km\n", nbKmAvant, nbKmApres);
	    boolean condition = nbKmApres == km/2;
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
		AgenceAuto.vehicules.add(voiture);
		double nbKmAvant = voiture.getNbkilometres();
        try {
			voiture.ajouterCarburant(km, Carburant.Essence);
			voiture.seDeplacer(km);
		} catch (MonException e) {
			System.out.printf("%s\n", e.getMessage());
		}
		double nbKmApres = voiture.getNbkilometres();
		System.out.printf("Avant le deplacement le vehicule à un compteur à %.1f Km, Apres le deplacement le vehicule a un compteur à %.1f Km\n", nbKmAvant, nbKmApres);
	    boolean condition = nbKmApres == km;
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
		AgenceAuto.vehicules.add(voiture);
		double nbKmAvant = voiture.getNbkilometres();
        try {
            voiture.ajouterCarburant(km/2, Carburant.Essence);
			voiture.ajouterCarburant((km/2)*10, Carburant.Electrique);
			voiture.seDeplacer(km);
		} catch (MonException e) {
			System.out.printf("%s\n", e.getMessage());
		}
		double nbKmApres = voiture.getNbkilometres();
		System.out.printf("Avant le deplacement le vehicule à un compteur à %.1f Km, Apres le deplacement le vehicule a un compteur à %.1f Km\n", nbKmAvant, nbKmApres);
	    boolean condition = nbKmApres == km;
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 5 : Normal")
	void test5(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
        double km = 100;
		System.out.printf("Le vehicule souhaite se deplacer de %.1f Km mais on tente d'ajoute %.1f unite de carburant Electrique dans un Vehicule Thermique\n", km, km*10);
        voiture = new Voiture(1000, TypeMoteur.Essence);
		AgenceAuto.vehicules.add(voiture);
		double nbKmAvant = voiture.getNbkilometres();
        try {
			voiture.ajouterCarburant(km*10, Carburant.Electrique);
			voiture.seDeplacer(km);
		} catch (MonException e) {
			System.out.printf("%s\n", e.getMessage());
		}
		double nbKmApres = voiture.getNbkilometres();
		System.out.printf("Avant le deplacement le vehicule à un compteur à %.1f Km, Apres le deplacement le vehicule a un compteur à %.1f Km\n", nbKmAvant, nbKmApres);
	    boolean condition = nbKmApres == 0;
		assertTrue(condition);
		System.out.println();
	}



}
