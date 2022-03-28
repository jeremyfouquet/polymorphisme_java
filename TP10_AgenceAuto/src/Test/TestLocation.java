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

@DisplayName("TestLocation")
class TestLocation {
	static AgenceAuto agence;
	static Velo velo;
    
	@BeforeAll
	  	static void initAll(TestInfo testInfo) {
	    System.out.printf("%s\n", testInfo.getDisplayName());
	    System.out.println();
	    try {
			agence = new AgenceAuto();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeEach
		void setUp() throws Exception {
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
        double kmDeLocation = 100;
		System.out.printf("%s %.1f KM\n", "On Souhaite Louer Un Velo Pour", kmDeLocation);
        velo = new Velo(1000);
		AgenceAuto.vehicules.add(velo);
        int avantV = AgenceAuto.vehicules.size();
        int avantL = AgenceAuto.vehiculesLoues.size();
		agence.location(velo, kmDeLocation);
        int apresV = AgenceAuto.vehicules.size();
        int apresL = AgenceAuto.vehiculesLoues.size();
		System.out.printf("La liste des achats de vehicules AVANT la location est de %d, et APRES elle est de %d\n", avantV, apresV);
		System.out.printf("La liste des location de vehicules AVANT la location est de %d, et APRES elle est de %d\n", avantL, apresL);
		System.out.printf("La location est pour %.1f KM, le velo sera rendu dans %.1f KM\n", kmDeLocation, velo.getLouejusque() - velo.getNbkilometres());
	    boolean condition = (avantV - 1 == apresV) && (avantL + 1 == apresL) && ((velo.getLouejusque() - velo.getNbkilometres()) == kmDeLocation);
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 2 : Normal")
	void test2(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
		System.out.printf("%s\n", "On Souhaite Rendre Le Velo precedemment loué");
        int avantV = AgenceAuto.vehicules.size();
        int avantL = AgenceAuto.vehiculesLoues.size();
		velo.rendreLocation();
        int apresV = AgenceAuto.vehicules.size();
        int apresL = AgenceAuto.vehiculesLoues.size();
		System.out.printf("La liste des achats de vehicules AVANT de rendre la location est de %d, et APRES elle est de %d\n", avantV, apresV);
		System.out.printf("La liste des location de vehicules AVANT de rendre la location est de %d, et APRES elle est de %d\n", avantL, apresL);
	    boolean condition = (avantV + 1 == apresV) && (avantL - 1 == apresL);
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 3 : Particulier")
	void test3(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());		
		double kmDeLocation = 20;	
		double kmAParcourir = 100;
		System.out.printf("%s %.1f KM %s %.1f KM\n", "On Souhaite Parcourir", kmAParcourir, "avec un Velo Loue pour seulement", kmDeLocation);
		agence.location(velo, kmDeLocation);
        int avantV = AgenceAuto.vehicules.size();
        int avantL = AgenceAuto.vehiculesLoues.size();
		velo.seDeplacer(kmAParcourir);
        int apresV = AgenceAuto.vehicules.size();
        int apresL = AgenceAuto.vehiculesLoues.size();
        velo.kilometreParcouru();
		System.out.printf("La liste des achats de vehicules AVANT le deplacement est de %d, et APRES le deplacement est de %d\n", avantV, apresV);
		System.out.printf("La liste des location de vehicules AVANT le deplacement est de %d, et APRES le deplacement est de %d\n", avantL, apresL);
		System.out.printf("Le vehicule a été rendu au bout de %.1f KM", velo.getNbkilometres());
	    boolean condition = (avantV + 1 == apresV) && (avantL - 1 == apresL) && (velo.getNbkilometres() == kmDeLocation);
		assertTrue(condition);
		System.out.println();
	}
	


}
