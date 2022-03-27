/**
 * @author Jeremy Fouquet
 */
package Ecosysteme;

import java.util.Arrays;

public abstract class Animaux extends Especes implements Vivipare, Ovipare {
	EspecesAnimale espece;
	Sexe sexe;
	double taille;
	double poids;
	int esv;
	public Animaux(Sexe sexe, double taille, double poids, int esv) {
		this.sexe = sexe;
		this.taille = taille;
		this.poids = poids;
		this.esv = esv;
		EcoSysteme.ajouterEspece(this);
	}
	public Animaux() {
		this.sexe = Arrays.asList(Sexe.values()).get(aleatoire());
		this.taille = 1.0;
		this.poids = 100;
		this.esv = 8;
		EcoSysteme.ajouterEspece(this);
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
				+ esv + "]";
	}

}
