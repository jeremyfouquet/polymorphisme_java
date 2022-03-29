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
import exception.MonException;

@DisplayName("TestKlaxonner")
class TestKlaxonner {
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
        int index = AgenceAuto.vehicules.size();
        Moto moto = null;
        Voiture voiture = null;
        Velo velo = null;
        Trottinette trottinette = null;
		try {
			agence.ajouterVehicule(TypeVehicule.Moto, 2000, TypeMoteur.Essence);
	        index = AgenceAuto.vehicules.size();
			moto = index > 0 ? (Moto) AgenceAuto.vehicules.get(index-1) : null;
			agence.ajouterVehicule(TypeVehicule.Voiture, 2000, TypeMoteur.Essence);
	        index = AgenceAuto.vehicules.size();
			voiture = index > 0 ? (Voiture) AgenceAuto.vehicules.get(index-1) : null;
			agence.ajouterVehicule(TypeVehicule.Velo, 1000);
	        index = AgenceAuto.vehicules.size();
			velo = index > 0 ? (Velo) AgenceAuto.vehicules.get(index-1) : null;
			agence.ajouterVehicule(TypeVehicule.Trottinette, 1000);
	        index = AgenceAuto.vehicules.size();
			trottinette = index > 0 ? (Trottinette) AgenceAuto.vehicules.get(index-1) : null;
		} catch (MonException e) {
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
