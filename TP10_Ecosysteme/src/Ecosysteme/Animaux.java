package Ecosysteme;

import java.util.Arrays;

public abstract class Animaux extends Especes implements Vivipare, Ovipare {
	EspecesAnimale espece;
	Sexe sexe;
	double taille;
	double poids;
	int esv;

	public Animaux() {
		this.sexe = Arrays.asList(Sexe.values()).get(aleatoire());
		this.taille = 1.0;
		this.poids = 100;
		this.esv = 8;
		EcoSysteme.especes.add(this);
	}
	public Animaux(double taille, double poids, int esv) {
		this.sexe = Arrays.asList(Sexe.values()).get(aleatoire());
		this.taille = taille;
		this.poids = poids;
		this.esv = esv;
		EcoSysteme.especes.add(this);
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

}
