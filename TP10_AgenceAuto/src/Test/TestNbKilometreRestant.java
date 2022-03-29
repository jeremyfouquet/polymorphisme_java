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

@DisplayName("TestNbKilometreRestant")
class TestNbKilometreRestant {
	static AgenceAuto agence;
    
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
	@DisplayName("Test 1 : Normal")
	void test1(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
        double km = 100;
		System.out.printf("Le vehicule reçoit %.1f unites de carburant et souhaite  savoir combien il reste de Km à parcourir\n", km);
        Voiture voiture = new Voiture(1000, TypeMoteur.Essence);
		AgenceAuto.vehicules.add(voiture);
		try {
			voiture.ajouterCarburant(km, Carburant.Essence);
		} catch (MonException e) {
			System.out.printf("%s\n", e.getMessage());
		}
		double nbKm = voiture.nbKilometreRestant();
		System.out.printf("Avec %.1f unite de %s ajouté au vehicule celui ci peut parcourir %.1f Km\n", km, Carburant.Essence, nbKm);
	    boolean condition = nbKm == km;
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 2 : Normal")
	void test2(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
        double km = 100;
        Carburant c1 = Carburant.Essence;
        Carburant c2 = Carburant.Electrique;
		System.out.printf("Le vehicule reçoit %.1f unites d'essence puis %.1f d'unites d'electricite et souhaite  savoir combien il reste de Km à parcourir\n", km, km*10);
        Voiture voiture = new Voiture(1000, TypeMoteur.Hybride);
		AgenceAuto.vehicules.add(voiture);
		try {
			voiture.ajouterCarburant(km, c1);
			voiture.ajouterCarburant(km*10, c2);
		} catch (MonException e) {
			System.out.printf("%s\n", e.getMessage());
		}
		double nbKm = voiture.nbKilometreRestant();
		System.out.printf("Avec %.1f unités de %s et %.1f unités de %s ajouté au vehicule celui ci peut parcourir %.1f Km\n", km, c1, km*10, c2, nbKm);
	    boolean condition = nbKm == km*2;
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 3 : Particulier")
	void test3(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
        double km = 100;
        Carburant c1 = Carburant.Essence;
		System.out.printf("%s\n", "On tente de donner du carburant à un vehicule sans moteur");
        Velo v = new Velo(1000);
		AgenceAuto.vehicules.add(v);
		try {
			v.ajouterCarburant(km, c1);
		} catch (MonException e) {
			System.out.printf("%s\n", e.getMessage());
		}
		double nbKm = v.nbKilometreRestant();
		System.out.printf("Le vehicule à un nombre de kilometre restant de %.1f Km\n", nbKm);
	    boolean condition = nbKm > km;
		assertTrue(condition);
		System.out.println();
	}



}
