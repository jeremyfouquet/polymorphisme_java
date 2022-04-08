package Test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import agence.*;
import exception.MoteurException;

@DisplayName("TestSeDeplacer")
class TestSeDeplacer {
	AgenceAuto agence;
	Voiture voiture;
	List<Vehicule> vehiculeEnVente;
    
	@BeforeAll
	  	static void initAll(TestInfo testInfo) {
	    System.out.printf("%s\n", testInfo.getDisplayName());
	    System.out.println();
	}

	@BeforeEach
		void setUp() throws Exception {
		try {
			agence = new AgenceAuto();
			vehiculeEnVente = agence.getVehicules();
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
		System.out.printf("Une Voiture souhaite se deplacer de %.1f Km sans carburant\n", km);
        voiture = new Voiture(1000, TypeMoteur.Essence);
		vehiculeEnVente.add(voiture);
		double nbKmAvant = voiture.nbKilometreRestant();
		voiture.seDeplacer(km, agence);
		System.out.printf("Avant le deplacement le vehicule peut se deplacer de %.1f Km\nApres le deplacement le vehicule a parcouru %.1f Km\n", nbKmAvant, voiture.getNbkilometres());
	    boolean condition = nbKmAvant == voiture.getNbkilometres();
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 2 : Particulier")
	void test2(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
        double km = 100;
        TypeMoteur moteur = TypeMoteur.Essence;
		System.out.printf("Une Voiture souhaite se deplacer de %.1f Km mais avec %.1f unite de %s\n", km, km/2, moteur);
        voiture = new Voiture(1000, moteur);
		vehiculeEnVente.add(voiture);
		double nbKmAvant = voiture.getNbkilometres();
        try {
			voiture.ajouterCarburant(km/2, Carburant.Essence);
			voiture.seDeplacer(km, agence);
		} catch (MoteurException e) {
			System.out.printf("%s\n", e.getMessage());
		}
		double nbKmApres = voiture.getNbkilometres();
		System.out.printf("Avant le deplacement le vehicule à un compteur à %.1f Km\nApres le deplacement le vehicule a un compteur à %.1f Km\n", nbKmAvant, nbKmApres);
	    boolean condition = nbKmApres == km/2;
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 3 : Normal")
	void test3(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
        double km = 100;
        TypeMoteur moteur = TypeMoteur.Essence;
		System.out.printf("Une Voiture souhaite se deplacer de %.1f Km avec %.1f unite de %s\n", km, km, moteur);
        voiture = new Voiture(1000, moteur);
		vehiculeEnVente.add(voiture);
		double nbKmAvant = voiture.getNbkilometres();
        try {
			voiture.ajouterCarburant(km, Carburant.Essence);
			voiture.seDeplacer(km, agence);
		} catch (MoteurException e) {
			System.out.printf("%s\n", e.getMessage());
		}
		double nbKmApres = voiture.getNbkilometres();
		System.out.printf("Avant le deplacement le vehicule à un compteur à %.1f Km\nApres le deplacement le vehicule a un compteur à %.1f Km\n", nbKmAvant, nbKmApres);
	    boolean condition = nbKmApres == km;
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 4 : Normal")
	void test4(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
        double km = 100;
        Carburant carburant1 = Carburant.Essence;
        Carburant carburant2 = Carburant.Electrique;
		System.out.printf("Une Voiture souhaite se deplacer de %.1f Km avec %.1f unite de %s et %.1f unite de %s\n", km, km/2, carburant1, (km/2)*10, carburant2);
		voiture = new Voiture(1000, TypeMoteur.Hybride);
		vehiculeEnVente.add(voiture);
		double nbKmAvant = voiture.getNbkilometres();
        try {
            voiture.ajouterCarburant(km/2, carburant1);
			voiture.ajouterCarburant((km/2)*10, carburant2);
			voiture.seDeplacer(km, agence);
		} catch (MoteurException e) {
			System.out.printf("%s\n", e.getMessage());
		}
		double nbKmApres = voiture.getNbkilometres();
		System.out.printf("Avant le deplacement le vehicule à un compteur à %.1f Km\nApres le deplacement le vehicule a un compteur à %.1f Km\n", nbKmAvant, nbKmApres);
	    boolean condition = nbKmApres == km;
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 5 : Normal")
	void test5(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
        double km = 100;
		System.out.println("Une Voiture souhaite ajouter le mauvais carburant, puis de se déplacer");
        voiture = new Voiture(1000, TypeMoteur.Essence);
		vehiculeEnVente.add(voiture);
		double nbKmAvant = voiture.getNbkilometres();
        try {
			voiture.ajouterCarburant(km*10, Carburant.Electrique);
			voiture.seDeplacer(km, agence);
		} catch (MoteurException e) {
			System.out.printf("%s\n", e.getMessage());
		}
		double nbKmApres = voiture.getNbkilometres();
		System.out.printf("Avant le deplacement le vehicule à un compteur à %.1f Km\nApres le deplacement le vehicule a un compteur à %.1f Km\n", nbKmAvant, nbKmApres);
	    boolean condition = nbKmApres == 0;
		assertTrue(condition);
		System.out.println();
	}



}
