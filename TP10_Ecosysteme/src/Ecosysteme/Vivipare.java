/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import exception.MonException;

public interface Vivipare {
	
	/** 
	 * 
	 * Créé une nouvelle instance d'Oeuf
	 * 
	 * @exception MonException this est un male
	 * @exception MonException this est mort
	 */
	default void seReproduire() throws MonException {		
		if (this.getSexe() == Sexe.male) {
			throw new MonException("Reproduction impossible : Les males ne pondent pas d'oeuf !");
		} else if (this.isVivant() != true) {
			throw new MonException("Reproduction impossible : L'animal est mort !");
		} else {
			new Oeuf(getEspece());
		}
	}

	/** 
	 * 
	 * Fertilise l'oeuf
	 * 
	 * @param oeuf oeuf à fertiliser
	 * @exception MonException this est une femelle
	 * @exception MonException this et oeuf ne sont pas de la même espece
	 * @exception MonException oeuf est mort
	 * @exception MonException this est mort
	 * @see Oeuf#eclos()
	 */
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
