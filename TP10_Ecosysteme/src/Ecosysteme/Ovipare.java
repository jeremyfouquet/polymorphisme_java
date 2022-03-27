/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.Arrays;
import java.util.List;

import exception.MonException;

public interface Ovipare {
	//	Du côté des animaux ceux-ci seront, soit ovipares et nécessiteront un
	//	partenaire du sexe opposé pour se reproduire.
	//	Lors de la reproduction des vivipares, l'enfant récupère
	//	aléatoirement les caractéristiques (espérance de vie, poids, taille,
	//	sexe) selon celle de son père ou de sa mère.
	default void seReproduire(Ovipare partenaire) throws MonException {
		if (partenaire.getSexe() == this.getSexe()) {
			throw new MonException("Reproduction impossible : Les partenaires sont de même sexe !");
		} else if (this.isVivant() != true || partenaire.isVivant() != true) {
			throw new MonException("Reproduction impossible : L'animal est mort !");
		} else {
			caracteristiques(partenaire);
		}	
	}
	
	private void caracteristiques(Ovipare partenaire) {
		List<Double> ltailles = Arrays.asList(this.getTaille(), partenaire.getTaille()); 
		List<Double> lpoids = Arrays.asList(this.getPoids(), partenaire.getPoids()); 
		List<Integer> lesv = Arrays.asList(this.getEsperanceDeVie(), partenaire.getEsperanceDeVie()); 
		Sexe sexe = Arrays.asList(Sexe.values()).get(aleatoire());
		double taille = ltailles.get(aleatoire());
		double poids = lpoids.get(aleatoire());
		int esv = lesv.get(aleatoire());
		switch (getEspece()) {
			case Carnivore:
				new Carnivores(sexe, taille, poids, esv);
				break;
			case Omnivore:
				new Omnivores(sexe, taille, poids, esv);
				break;
			case Herbivore:
				new Herbivores(sexe, taille, poids, esv);
				break;
			case Charognard:
				new Charognards(sexe, taille, poids, esv);
				break;
			default:
				break;
		}
	}
	
	default int aleatoire() {
		int r = (int) (Math.random() * 2);
		return r;
	}
	
	public EspecesAnimale getEspece();
	public Sexe getSexe();
	public double getTaille();
	public double getPoids();
	public int getEsperanceDeVie();
	public boolean isVivant();

}
