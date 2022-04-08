/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.List;

import exception.ActionException;

public interface Vivipare {
	
	/** 
	 * 
	 * Créé une nouvelle instance d'Oeuf
	 * 
	 * @param especes liste des especes de l'ecosysteme
	 * @exception ActionException this est un male
	 * @exception ActionException this est mort
	 */
	default void seReproduire(List<Especes> especes) throws ActionException {		
		if (this.getSexe() == Sexe.male) {
			throw new ActionException("Reproduction impossible : Les males ne pondent pas d'oeuf !");
		} else if (this.isVivant() != true) {
			throw new ActionException("Reproduction impossible : L'animal est mort !");
		} else {
			new Oeuf(getEspece(), especes);
		}
	}

	/** 
	 * 
	 * Fertilise l'oeuf
	 * 
	 * @param especes liste des especes de l'ecosysteme
	 * @param oeuf oeuf à fertiliser
	 * @exception ActionException this est une femelle
	 * @exception ActionException this et oeuf ne sont pas de la même espece
	 * @exception ActionException oeuf est mort
	 * @exception ActionException this est mort
	 * @see Oeuf#eclos()
	 */
	default void fertilise(Oeuf oeuf, List<Especes> especes) throws ActionException {		
		if (this.getSexe() == Sexe.femelle) {
			throw new ActionException("Fertilisation echoué : Les femelles ne fertilisent pas !");
		} else if (this.getEspece().equals(oeuf.getEspece()) != true) {
			throw new ActionException("Fertilisation echoué : L'animale n'est pas de la même espece que l'oeuf !");
		} else if (oeuf.isVivant() != true) {
			throw new ActionException("Fertilisation echoué : L'oeuf est mort !");
		} else if (this.isVivant() != true){
			throw new ActionException("Fertilisation echoué : L'animal est mort !");
		} else {
			oeuf.eclos(especes);
		}
	}

	// PROTOTYPE
	public Sexe getSexe();
	public EspecesAnimale getEspece();
	public boolean isVivant();

}
