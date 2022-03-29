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

@DisplayName("TestAjouterVehicule")
class TestAjouterVehicule {
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
        int avant = AgenceAuto.vehicules.size();
        int apres = AgenceAuto.vehicules.size();
        Vehicule vehicule = null;
		try {
			agence.ajouterVehicule(TypeVehicule.Moto, 2000, TypeMoteur.Essence);
	        apres = AgenceAuto.vehicules.size();
			vehicule = apres > 0 ? AgenceAuto.vehicules.get(apres-1) : null;
		} catch (MonException e) {
			System.out.printf("%s\n", e.getMessage());
		} finally {
			System.out.printf("La liste des vehicules AVANT l'ajout du vehicule est de %d vehicules au total\n", avant);
			System.out.printf("La liste des vehicules APRES l'ajout du vehicule est de %d vehicules au total\n", apres);
		    boolean condition = null != vehicule ? avant == apres-1 : avant == apres;
			assertTrue(condition);
			System.out.println();
		}
	}
	
	@Test
	@DisplayName("Test 2 : Particulier")
	void test2(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
		System.out.printf("%s\n", "Tente d'ajouter une Moto sans Moteur");
        int avant = AgenceAuto.vehicules.size();
        int apres = AgenceAuto.vehicules.size();
        Vehicule vehicule = null;
		try {
			agence.ajouterVehicule(TypeVehicule.Moto, 2000);
	        apres = AgenceAuto.vehicules.size();
			vehicule = apres > 0 ? AgenceAuto.vehicules.get(apres-1) : null;
		} catch (MonException e) {
			System.out.printf("%s\n", e.getMessage());
		} finally {
			System.out.printf("La liste des vehicule AVANT l'ajout du vehicule est de %d vehicules au total\n", avant);
			System.out.printf("La liste des vehicule APRES l'ajout du vehicule est de %d vehicules au total\n", apres);
		    boolean condition = null != vehicule ? avant == apres-1 : avant == apres;
			assertTrue(condition);
			System.out.println();
		}
	}
	
	@Test
	@DisplayName("Test 3 : Particulier")
	void test3(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
		System.out.printf("%s\n", "Tente d'ajouter un Velo avec un Moteur à Essence");
        int avant = AgenceAuto.vehicules.size();
        int apres = AgenceAuto.vehicules.size();
        Vehicule vehicule = null;
		try {
			agence.ajouterVehicule(TypeVehicule.Velo, 1500, TypeMoteur.Essence);
	        apres = AgenceAuto.vehicules.size();
			vehicule = apres > 0 ? AgenceAuto.vehicules.get(apres-1) : null;
		} catch (MonException e) {
			System.out.printf("%s\n", e.getMessage());
		} finally {
			System.out.printf("La liste des vehicule AVANT l'ajout du vehicule est de %d vehicules au total\n", avant);
			System.out.printf("La liste des vehicule APRES l'ajout du vehicule est de %d vehicules au total\n", apres);
		    TypeMoteur carburant = null != vehicule ? vehicule.getCarburant() : null;
			boolean condition = avant == apres-1 && carburant.equals(TypeMoteur.Electrique);
			if (condition) {
				System.out.printf("%s %s\n", "Quelque soit le Moteur envoyé La Classe Velo le remplace automatiquement par un Moteur", carburant);
			}
			assertTrue(condition);
			System.out.println();
		}
	}

}
