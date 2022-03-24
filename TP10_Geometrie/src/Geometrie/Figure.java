package Geometrie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public abstract class Figure {
	private List<Segment> segments = new ArrayList<Segment>();
	private TypeFigure typefigure;

	public Figure(NbPoints nbPoints) {
		this.segments.add(new Segment());
		this.typefigure = choixFigure(nbPoints);
	}
	
	private TypeFigure choixFigure(NbPoints nbPoints) {
		List<TypeFigure> choix = new ArrayList<TypeFigure>();
		List<String> selection = Arrays.asList("oui", "non");
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

	// Une méthode abstraite permettant de calculer l'aire de chaque figure
	protected abstract double calculerAire();
	
	protected double hauteur(double base) {
		double hauteur = (base/2) * Math.sqrt(3);
		return hauteur;
	}
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

	protected void afficheAire() {
		System.out.printf("L'aire est de %.1f cm3\n", calculerAire());
		System.out.println();
	};

	// Une méthode abstraite ?? permettant de calculer le nombre d'angles
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
	
	protected void afficheNombreAngles() {
		System.out.printf("Nombre total d'angles est %d\n", this.calculerNombreAngles());
		System.out.println();
	}
	// Une méthode pouvant calculer la longueur de chacun des segments
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

	// Une méthode permettant de calculer le périmètre total d'une figure
	protected double calculerPerimetre() {
		double perimetre = this.calculerLongueurSegment(false);
		return perimetre;
	}
	
	// Une méthode permettant de calculer le périmètre total d'une figure
	protected void affichePerimetre() {
		System.out.printf("Le perimetre est de %.1f cm\n", this.calculerPerimetre());
		System.out.println();
	}
	
	// GETTERS ET SETTERS

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

}
