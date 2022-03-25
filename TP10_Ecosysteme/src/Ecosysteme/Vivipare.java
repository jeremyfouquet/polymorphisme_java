package Ecosysteme;

public interface Vivipare {
	//	Du côté des animaux ceux-ci seront, soit oit ils seront vivipares
	//	et pondront des œufs.
	default void seReproduire() {		
		System.out.printf("Un Vivipare se reproduit et pond un oeuf\n");
	}

}
