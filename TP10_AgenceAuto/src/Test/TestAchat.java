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

@DisplayName("TestAchat")
class TestAchat {
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
		System.out.printf("%s\n", "On Souhaite Achater Un Velo");
        Velo velo = new Velo(1000);
		AgenceAuto.vehicules.add(velo);
        int avantV = AgenceAuto.vehicules.size();
		agence.achat(velo);
        int apresV = AgenceAuto.vehicules.size();
		System.out.printf("La liste des achats de vehicules AVANT l'achat est de %d\n", avantV);
		System.out.printf("La liste des achats de vehicules APRES l'achat est de %d\n", apresV);		
	    boolean condition = (avantV - 1 == apresV);
		assertTrue(condition);
		System.out.println();
	}

}
