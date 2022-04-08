package Test;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import agence.*;

@DisplayName("TestProchainCT")
class TestProchainCT {
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
		int ct = 4;
		System.out.printf("Lors du premier contrôle technique le temps autorisé est de %d années depuis la date de mise en circulation du vehicule\n", ct);
        Voiture voiture = new Voiture(1000, TypeMoteur.Essence);
		vehiculeEnVente.add(voiture);
		int prochainCT = voiture.prochainCT();
	    boolean condition = prochainCT == ct;
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 2 : Normal")
	void test2(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
		int ct = 2;
		System.out.printf("Apres le premier contrôle technique les suivants se font tous les %d ans\n", ct);
        Voiture voiture = new Voiture(1000, TypeMoteur.Essence);
		vehiculeEnVente.add(voiture);
        voiture.faireCT();
		int prochainCT = voiture.prochainCT();
	    boolean condition = prochainCT == ct;
		assertTrue(condition);
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 3 : Particulier")
	void test3(TestInfo testInfo) {
		System.out.printf("%s\n", testInfo.getDisplayName());
		int ct = 2;
		int dernierCT = 3;
		System.out.printf("Apres le premier contrôle technique les suivants se font tous les %d ans\n", ct);
		System.out.printf("Cela fait %d ans depuis le dernier CT, alors un rappel devrait precisé que le CT est dépassé depuis %d année\n", dernierCT, dernierCT - ct);
        Voiture voiture = new Voiture(1000, TypeMoteur.Essence);
		vehiculeEnVente.add(voiture);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.YEAR, -dernierCT);
        Date dateCT = c1.getTime();
        voiture.setDateCT(dateCT);
		int prochainCT = voiture.prochainCT();
	    boolean condition = (prochainCT < 0) && (prochainCT == ct - dernierCT);
		assertTrue(condition);
		System.out.println();
	}



}
