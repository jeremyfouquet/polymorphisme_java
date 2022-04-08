/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.Arrays;
import java.util.List;

public abstract class Animaux extends Especes implements Vivipare, Ovipare {
	private EspecesAnimale espece; // Type d'animal
	private Sexe sexe; // male ou femelle
	private double taille;
	private double poids;
	private int esv; // esperance de vie

	/**
	 * @param sexe
	 * @param taille
	 * @param poids
	 * @param esv
	 * @param especes // liste des especes de l'ecosysteme
	 */
	public Animaux(Sexe sexe, double taille, double poids, int esv, List<Especes> especes) {
		this.sexe = sexe;
		this.taille = taille;
		this.poids = poids;
		this.esv = esv;
		ajouterEspece(especes);
	}

	/**
	 * @param oeuf optionnel si le paramettre oeuf existe alors on ne l'ajoute pas à l'ecosysteme c'est la class Oeuf qui s'en chargera
	 * @param especes // liste des especes de l'ecosysteme
	 */
	public Animaux(List<Especes> especes, String... oeuf) {
		this.sexe = Arrays.asList(Sexe.values()).get(aleatoire());
		this.taille = 1.0;
		this.poids = 100;
		this.esv = 8;
		boolean ajouter = true;
		for (String o :oeuf) {
			if(o.equals("oeuf") == true) {
				ajouter = false;
			}
		}
		if (ajouter) {
			ajouterEspece(especes);
		}
	}
		
	//GETTERS, SETTERS, EQUALS, TOSTRING
	
	public EspecesAnimale getEspece() {
		return espece;
	}
	public void setEspece(EspecesAnimale espece) {
		this.espece = espece;
	}
	public Sexe getSexe() {
		return sexe;
	}
	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}
	public double getTaille() {
		return taille;
	}
	public void setTaille(double taille) {
		this.taille = taille;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	public int getEsperanceDeVie() {
		return esv;
	}
	public void setEsperanceDeVie(int esperanceDeVie) {
		this.esv = esperanceDeVie;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animaux other = (Animaux) obj;
		return espece == other.espece && esv == other.esv
				&& Double.doubleToLongBits(poids) == Double.doubleToLongBits(other.poids) && sexe == other.sexe
				&& Double.doubleToLongBits(taille) == Double.doubleToLongBits(other.taille);
	}
	@Override
	public String toString() {
		return "Animaux [espece=" + espece + ", sexe=" + sexe + ", taille=" + taille + ", poids=" + poids + ", esv="
				+ esv + ", isVivant()=" + isVivant() + ", getTypeEspece()=" + getTypeEspece() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() +"]";
	}

}
