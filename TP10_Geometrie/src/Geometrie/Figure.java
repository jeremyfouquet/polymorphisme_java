/** 
 * Jeremy Fouquet
 */
package Geometrie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public abstract class Figure {

	private List<Segment> segments = new ArrayList<Segment>(); // Liste des segments formant la figure
	private TypeFigure typefigure; // type de triangle ou de quadrilatere

	/**
	 * @param nbPoints
	 */
	public Figure(NbPoints nbPoints) {
		this.segments.add(new Segment());
		List<TypeFigure> choix = new ArrayList<TypeFigure>();
		choix.add(TypeFigure.Rectangle);
		switch (nbPoints) {
			case trois:
				choix.add(TypeFigure.Isocele);
				choix.add(TypeFigure.Equilateral);
				break;
			case quatre:
				choix.add(TypeFigure.Carre);
				choix.add(TypeFigure.Losange);
				break;
			default:
				break;
		};
		this.typefigure = choixFigure(nbPoints, choix);
	}

	/** 
	 * 
	 * Permet de calculer l'aire de la figure
	 * 
	 * @return double l'aire calculé
	 */	
	protected abstract double calculerAire();

	/** 
	 * 
	 * Affiche le degree de chaque angles
	 * 
	 */
	protected abstract void afficheDegreeAngles();
	/** 
	 * 
	 * Affiche l'aire calculé
	 * 
	 * @see #calculerAire()
	 */
	protected void afficheAire() {
		System.out.printf("L'aire est de %.1f cm3\n", calculerAire());
		System.out.println();
	};

	/** 
	 * 
	 * Propose de choisir parmis une type de triangle ou un type de quadrilatere
	 * 
	 * @param nbPoints determine la forme triangle ou quadrilatere
	 * @return TypeFigure type choise par l'utilisateur
	 */
	private TypeFigure choixFigure(NbPoints nbPoints, List<TypeFigure> choix) {
		List<String> selection = Arrays.asList("oui", "non");
		TypeFigure choixFinal = null;
		while (choix.contains(choixFinal) != true) {
			for(int i=0; i < choix.size() && choix.contains(choixFinal) != true; i++) {
				String reponse = "";
				System.out.printf("Souhaitez vous dessiner un %s de type : %s ?\n", nbPoints.getForme(), choix.get(i));
				System.out.printf("%s ou %s\n", selection.get(0), selection.get(1));
				while (selection.contains(reponse) != true) {
					reponse = Main.sc.nextLine();
				}
				if(selection.get(0).equals(reponse)) {
					choixFinal = choix.get(i);
				}
			}
		}
		return choixFinal;
	}
	
	/** 
	 * 
	 * Calcule la hauteur d'une figure
	 * SURCHARGE DE METHODE
	 * 
	 * @param base segment representant la base d'un triangle
	 * @return double la hauteur calculé
	 */
	protected double hauteur(double base) {
		double hauteur = (base/2) * Math.sqrt(3);
		return hauteur;
	}

	/** 
	 * 
	 * Calcule la hauteur d'une figure
	 * SURCHARGE DE METHODE
	 * 
	 * @param segment sert de repere pour le point n°1
	 * @param point sert de repere pour le point n°2
	 * @return double la hauteur calculé
	 */
	protected double hauteur(Segment segment, Point point) {
		List<Double> points = new ArrayList<Double>(4);
		points.add(point.getX());
		points.add(segment.getPoints().get(0).getY());
		points.add(point.getX());
		points.add(point.getY());
		Segment segmentHauteur = new Segment(points);
		double hauteur = segmentHauteur.calculerLongueur();
		return hauteur;
	}

	/** 
	 * 
	 * Calcule le nombre d'angle de la figure
	 * 
	 * @return int nombre total d'angle de la figure
	 */
	protected int calculerNombreAngles() {
		List<Point> points = new ArrayList<Point>();
		for (Segment segment : this.segments) {
			Point point1 = segment.getPoints().get(0);
			Point point2 = segment.getPoints().get(1);
			if(points.contains(point1) != true) {
				points.add(point1);
			}
			if(points.contains(point2) != true) {
				points.add(point2);
			}
		}
		int nbAngle = points.size();
		return nbAngle;
	}
	
	/** 
	 * 
	 * Affiche le nombre d'angle calculé
	 * 
	 * @see #afficheNombreAngles()
	 */
	protected void afficheNombreAngles() {
		System.out.printf("Nombre total d'angles est %d\n", this.calculerNombreAngles());
		System.out.println();
	}
	
	/** 
	 * 
	 * Calcule la somme total de tous les segments de la figure
	 * 
	 * @param affiche optionnel ce boolean lorqu'il est à true affiche en plus la longueur de chaque segment et les coordonnées des points associés
	 * @return double somme de la longueur de chaque segment de la figure
	 * @see Segment#afficherLongueur()
	 * @see Segment#afficherCoordonnes()
	 * @see Segment#calculerLongueur()
	 */
	protected double calculerLongueurSegment(boolean... affiche) {
		boolean afficher = false;
		for (boolean a : affiche) {
			afficher = a;
		}
		int index = 1;
		double longueurTotal = 0;
		for (Segment segment :this.segments) {
			if(afficher) {System.out.printf("Segment n°%d : ", index);};
			double longueur = segment.calculerLongueur();
			if(afficher) {
				segment.afficherLongueur();
				segment.afficherCoordonnnees();
			};
			longueurTotal += longueur;
			index++;
		};
		return longueurTotal;
	};

	/** 
	 * 
	 * Calcule le perimetre de la figure
	 * 
	 * @return double perimetre de la figure
	 * @see Figure#calculerLongueurSegment(boolean...)
	 */	
	protected double calculerPerimetre() {
		double perimetre = this.calculerLongueurSegment(false);
		return perimetre;
	}
	
	/** 
	 * 
	 * Affiche le permimetre calculé
	 * 
	 * @see #calculerPerimetre()
	 */	
	protected void affichePerimetre() {
		System.out.printf("Le perimetre est de %.1f cm\n", this.calculerPerimetre());
		System.out.println();
	}
	
	// GETTERS, SETTERS, EQUALS, TOSTRING
	public List<Segment> getSegments() {
		return segments;
	}
	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}
	public TypeFigure getTypefigure() {
		return typefigure;
	}
	public void setTypefigure(TypeFigure typefigure) {
		this.typefigure = typefigure;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figure other = (Figure) obj;
		return Objects.equals(segments, other.segments) && typefigure == other.typefigure;
	}	
	@Override
	public String toString() {
		return "Figure [segments=" + segments + ", typefigure=" + typefigure + "]";
	}

}
