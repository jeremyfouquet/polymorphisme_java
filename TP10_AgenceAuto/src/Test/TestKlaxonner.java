package Test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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

@DisplayName("TestKlaxonner")
class TestKlaxonner {
	AgenceAuto agence;
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
	@DisplayName("Test 1 : Normal")
	void test1(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
        int index = vehiculeEnVente.size();
        Moto moto = null;
        Voiture voiture = null;
        Velo velo = null;
        Trottinette trottinette = null;
		try {
			agence.ajouterVehicule("Moto", 2000, TypeMoteur.Essence);
	        index = vehiculeEnVente.size();
			moto = index > 0 ? (Moto) vehiculeEnVente.get(index-1) : null;
			agence.ajouterVehicule("Voiture", 2000, TypeMoteur.Essence);
	        index = vehiculeEnVente.size();
			voiture = index > 0 ? (Voiture) vehiculeEnVente.get(index-1) : null;
			agence.ajouterVehicule("Velo", 1000);
	        index = vehiculeEnVente.size();
			velo = index > 0 ? (Velo) vehiculeEnVente.get(index-1) : null;
			agence.ajouterVehicule("Trottinette", 1000);
	        index = vehiculeEnVente.size();
			trottinette = index > 0 ? (Trottinette) vehiculeEnVente.get(index-1) : null;
		} catch (MoteurException e) {
			System.out.printf("%s\n", e.getMessage());
		} finally {
			List<String> klaxonnes = new ArrayList<String>();
			int nbVehiculeNotNull = 0;
			if (null != moto) {
				String klaxonne = moto.klaxonner();
				if(!klaxonnes.contains(klaxonne)) {
					klaxonnes.add(klaxonne);
				}
				nbVehiculeNotNull++;
			}
			if (null != voiture) {
				String klaxonne = voiture.klaxonner();
				if(!klaxonnes.contains(klaxonne)) {
					klaxonnes.add(klaxonne);
				}
				nbVehiculeNotNull++;
			}
			if (null != velo) {
				String klaxonne = velo.klaxonner();
				if(!klaxonnes.contains(klaxonne)) {
					klaxonnes.add(klaxonne);
				}
				nbVehiculeNotNull++;
			}
			if (null != trottinette) {
				String klaxonne = trottinette.klaxonner();
				if(!klaxonnes.contains(klaxonne)) {
					klaxonnes.add(klaxonne);
				}
				nbVehiculeNotNull++;
			}
			System.out.printf("Il y a %d types de vehicule différent\n", nbVehiculeNotNull);
			System.out.printf("Il y a %d types de klaxonne différent\n", klaxonnes.size());
		    boolean condition = klaxonnes.size() == nbVehiculeNotNull;
			assertTrue(condition);
			System.out.println();
		}
	}

}
