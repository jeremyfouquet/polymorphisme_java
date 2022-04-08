/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.Arrays;
import java.util.List;

import exception.ActionException;

public interface Ovipare {

	/** 
	 * 
	 * Créé une nouvelle instance (Carnivores | Herbivores | Charognards | Omnivores)
	 * 
	 * @param especes liste des especes de l'ecosysteme
	 * @param partenaire Ovipare avec lequel la reproduction sera faite
	 * @see #caracteristiques(Ovipare)
	 * @exception ActionException partenaire et this sont de même sexe
	 * @exception ActionException partenaire ou this sont mort
	 */
	default void seReproduire(Ovipare partenaire, List<Especes> especes) throws ActionException {
		if (partenaire.getSexe() == this.getSexe()) {
			throw new ActionException("Reproduction impossible : Les partenaires sont de même sexe !");
		} else if (this.isVivant() != true || partenaire.isVivant() != true) {
			throw new ActionException("Reproduction impossible : L'animal est mort !");
		} else {
			caracteristiques(partenaire, especes);
		}	
	}

	/** 
	 * 
	 * Genere aleatoirement un chiffre entre 0 et 1
	 * 
	 * @return int chiffre generé aleatoirement
	 */
	default int aleatoire() {
		int r = (int) (Math.random() * 2);
		return r;
	}
	
	/** 
	 * 
	 * Choisi aleatoirement les caracteristiques entre 2 Ovipares avant de créer une nouvelle instance à partir des caractéristique choisi
	 * 
	 * @param especes liste des especes de l'ecosysteme
	 * @param partenaire Ovipare avec lequel la reproduction sera faite
	 * @see #aleatoire()
	 * @see #getEspece()
	 * @see #getTaille()
	 * @see #getPoids()
	 * @see #getEsperanceDeVie()
	 */
	private void caracteristiques(Ovipare partenaire, List<Especes> especes) {
		List<Double> ltailles = Arrays.asList(this.getTaille(), partenaire.getTaille()); 
		List<Double> lpoids = Arrays.asList(this.getPoids(), partenaire.getPoids()); 
		List<Integer> lesv = Arrays.asList(this.getEsperanceDeVie(), partenaire.getEsperanceDeVie()); 
		Sexe sexe = Arrays.asList(Sexe.values()).get(aleatoire());
		double taille = ltailles.get(aleatoire());
		double poids = lpoids.get(aleatoire());
		int esv = lesv.get(aleatoire());
		switch (getEspece()) {
			case Carnivore:
				new Carnivores(sexe, taille, poids, esv, especes);
				break;
			case Omnivore:
				new Omnivores(sexe, taille, poids, esv, especes);
				break;
			case Herbivore:
				new Herbivores(sexe, taille, poids, esv, especes);
				break;
			case Charognard:
				new Charognards(sexe, taille, poids, esv, especes);
				break;
			default:
				break;
		}
	}
	
	// PROTOTYPES
	public EspecesAnimale getEspece();
	public Sexe getSexe();
	public double getTaille();
	public double getPoids();
	public int getEsperanceDeVie();
	public boolean isVivant();

}
