/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import exception.MonException;

public interface Vivipare {
	//	Du côté des animaux ceux-ci seront, soit oit ils seront vivipares
	//	et pondront des œufs.
	default void seReproduire() throws MonException {		
		if (this.getSexe() == Sexe.male) {
			throw new MonException("Reproduction impossible : Les males ne pondent pas d'oeuf !");
		} else if (this.isVivant() != true) {
			throw new MonException("Reproduction impossible : L'animal est mort !");
		} else {
			new Oeuf(getEspece());
		}
	}
	
	default void fertilise(Oeuf oeuf) throws MonException {		
		if (this.getSexe() == Sexe.femelle) {
			throw new MonException("Fertilisation echoué : Les femelles ne fertilisent pas !");
		} else if (this.getEspece().equals(oeuf.getEspece()) != true) {
			throw new MonException("Fertilisation echoué : L'animale n'est pas de la même espece que l'oeuf !");
		} else if (oeuf.isVivant() != true) {
			throw new MonException("Fertilisation echoué : L'oeuf est mort !");
		} else if (this.isVivant() != true){
			throw new MonException("Fertilisation echoué : L'animal est mort !");
		} else {
			oeuf.eclos();
		}
	}

	public Sexe getSexe();
	public EspecesAnimale getEspece();
	public boolean isVivant();

}
