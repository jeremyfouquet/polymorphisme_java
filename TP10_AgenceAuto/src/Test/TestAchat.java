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

@DisplayName("TestAchat")
class TestAchat {
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
		System.out.printf("%s\n", "On Souhaite Acheter Un Velo");
        Velo velo = new Velo(1000);
		vehiculeEnVente.add(velo);
        int avantV = vehiculeEnVente.size();
		agence.achat(velo);
        int apresV = vehiculeEnVente.size();
		System.out.printf("La liste des achats de vehicules AVANT l'achat : %d\n", avantV);
		System.out.printf("La liste des achats de vehicules APRES l'achat : %d\n", apresV);		
	    boolean condition = (avantV - 1 == apresV);
		assertTrue(condition);
		System.out.println();
	}

}
