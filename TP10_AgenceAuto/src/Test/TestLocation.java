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


@DisplayName("TestLocation")
class TestLocation {
	static AgenceAuto agence;
	static List<Vehicule> vehiculeEnVente;
	static List<String> vehiculeLoue;
	static Velo velo;
    
	@BeforeAll
	  	static void initAll(TestInfo testInfo) {
	    System.out.printf("%s\n", testInfo.getDisplayName());
	    System.out.println();
	    agence = new AgenceAuto();
	    vehiculeEnVente = agence.getVehicules();
	    vehiculeLoue = agence.getVehiculesLoues();
	   
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
		vehiculeEnVente.add(velo);
        int avantV = vehiculeEnVente.size();
        int avantL = vehiculeLoue.size();
		agence.location(velo, kmDeLocation);
        int apresV = vehiculeEnVente.size();
        int apresL = vehiculeLoue.size();
		System.out.printf("La liste des achats de vehicules AVANT la location : %d ; APRES la location : %d\n", avantV, apresV);
		System.out.printf("La liste des location de vehicules AVANT la location : %d ; APRES la location : %d\n", avantL, apresL);
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
        int avantV = vehiculeEnVente.size();
        int avantL = vehiculeLoue.size();
		agence.rendreLocation(velo);
        int apresV = vehiculeEnVente.size();
        int apresL = vehiculeLoue.size();
		System.out.printf("La liste des achats de vehicules AVANT retour de location : %d ; APRES retour de location  : %d\n", avantV, apresV);
		System.out.printf("La liste des location de vehicules AVANT retour de location : %d ; APRES retour de location : %d\n", avantL, apresL);
	    boolean condition = (avantV + 1 == apresV) && (avantL - 1 == apresL);
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 3 : Normal")
	void test3(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
        int size = vehiculeEnVente.size();
        System.out.printf("L'immatriculation du vehicule à louer : %s\n", vehiculeEnVente.get(size-1).getImmatriculation());
		agence.location(velo, 100);
		System.out.printf("La liste des vehicules loués contient l'immatriculation du vehicule : %b\n", vehiculeLoue.contains(velo.getImmatriculation()));
		assertTrue(vehiculeLoue.contains(velo.getImmatriculation()));
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 4 : Particulier")
	void test4(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());		
		double kmDeLocation = 20;	
		double kmAParcourir = 100;
		System.out.printf("%s %.1f KM %s %.1f KM\n", "On Souhaite Parcourir", kmAParcourir, "avec un Velo Loue pour seulement", kmDeLocation);
		agence.location(velo, kmDeLocation);
        int avantV = vehiculeEnVente.size();
        int avantL = vehiculeLoue.size();
		velo.seDeplacer(kmAParcourir, agence);
        int apresV = vehiculeEnVente.size();
        int apresL = vehiculeLoue.size();
        velo.kilometreParcouru();
		System.out.printf("La liste des achats de vehicules AVANT deplacement : %d ; APRES deplacement : %d\n", avantV, apresV);
		System.out.printf("La liste des location de vehicules AVANT deplacement : %d ; APRES deplacement : %d\n", avantL, apresL);
		System.out.printf("Le vehicule a été rendu au bout de %.1f KM", velo.getNbkilometres());
	    boolean condition = (avantV + 1 == apresV) && (avantL - 1 == apresL) && (velo.getNbkilometres() == kmDeLocation);
	    assertTrue(condition);
		System.out.println();
	}
	


}
