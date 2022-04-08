/** 
 * @author	Jeremy Fouquet
 */
package Geometrie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import exception.StopException;

public class Triangle extends Figure {
	private List<String> listCategorie = Arrays.asList("Rectangle", "Isocele", "Equilateral");

	public Triangle() {
		// DSL pour les calcules ;S Un peu tiré par les cheveux
		super();
		setTypeFigure(choixFigure("Triangle", listCategorie));
		ajoutSegments();
	}

	public Triangle(Utilisateur auto) {
		super();
		setTypeFigure(choixFigureAdapte(auto));
		ajoutSegments();
	}
	
	protected void ajoutSegments() {
		List<Double> S2 = new ArrayList<Double>(4);
		List<Double> S3 = new ArrayList<Double>(4);
		double x3 = 0;
		double y3 = 0;
		Segment segmentBase = getSegments().get(0);
		switch (getTypeFigure()) {
			case "Isocele":
				x3 = segmentBase.getPoints().get(1).getX()/2;
				y3 = 20;
				break;
			case "Equilateral":
				x3 = segmentBase.getPoints().get(1).getX()/2;
				y3 = pointEquilateral(segmentBase.calculerLongueur());
				break;
			case "Rectangle":
				x3 = segmentBase.getPoints().get(0).getX();
				y3 = segmentBase.getPoints().get(1).getX()/2;
				break;
		}
		S2.add(x3);
		S2.add(y3);
		S2.add(segmentBase.getPoints().get(0).getX());
		S2.add(segmentBase.getPoints().get(0).getY());
		S3.add(segmentBase.getPoints().get(1).getX());
		S3.add(segmentBase.getPoints().get(1).getY());
		S3.add(x3);
		S3.add(y3);
		getSegments().add(new Segment(S2));
		getSegments().add(new Segment(S3));
	}
	
	protected String choixFigureAdapte(Utilisateur auto) {
		String typeTriangle = null;
		int angleRectangle = 0;
		int coteEgaux = 0;
		try {
			angleRectangle = Integer.parseInt(auto.choixEtSaisie("Choisissez un nombre d'angle droit", Arrays.asList("0", "1")));
			if(angleRectangle == 1) {
				coteEgaux = Integer.parseInt(auto.choixEtSaisie("Choisissez un nombre de côté égaux", Arrays.asList("0", "2")));
				if(coteEgaux == 2) {
					typeTriangle = "Isocele";
				} else {
					typeTriangle = "Rectangle";
				}
			} else {
				coteEgaux = Integer.parseInt(auto.choixEtSaisie("Choisissez un nombre de côté égaux", Arrays.asList("2", "3")));
				if(coteEgaux == 2) {
					typeTriangle = "Isocele";
				} else {
					typeTriangle = "Equilaterale";
				}
			}
		} catch(StopException e) {
			System.out.printf("%s\n", e.getMessage());
		}
		return typeTriangle;
	}

	protected double calculerAire() {
		Segment segment1 = getSegments().get(0);
		Segment segment2 = getSegments().get(1);
		Segment segment3 = getSegments().get(2);
		double base = 0;
		double hauteur = 0;
		switch (getTypeFigure()) {
			case "Equilateral":
				base = segment1.calculerLongueur();
				hauteur = hauteur(base);
				break;
			case "Isocele":
				base = 
					segment1.calculerLongueur() == segment2.calculerLongueur() ? segment3.calculerLongueur() :
					segment1.calculerLongueur() == segment3.calculerLongueur() ? segment2.calculerLongueur() :
					segment1.calculerLongueur();
				hauteur = hauteur(segment1, segment2.getPoints().get(0));
				break;
			case "Rectangle":
				List<Segment> segmentRectangle = segmentRectangle();
				base = segmentRectangle.get(0).calculerLongueur();
				hauteur = segmentRectangle.get(1).calculerLongueur();
				break;
		}
		double aire = 0.5 * base * hauteur;
		return aire;
	};
	
	protected void afficheDegreeAngles() {
		int index = 0;
		for (Segment segment : getSegments()) {
			Point oppose = null;
			if (index >= getSegments().size()-1) {
				oppose = getSegments().get(0).getPoints().get(0);
			} else {
				oppose = getSegments().get(index+1).getPoints().get(0);
			}
			double degreeAngle = segment.calculerAngle(oppose);
			System.out.printf("Angle n°%d %.1f degree\n", index+1, degreeAngle);
			index++;
		}
		System.out.println();

	}

	/** 
	 * 
	 * Trouve les 2 segments adjacents à un angle droit pour un triangle rectangle
	 * 
	 * @return List<Segment> liste des segments adjacents à l'angle droit
	 */	
	private List<Segment> segmentRectangle() {
		List<Point> angleDroit = new ArrayList<Point>();
		List<Segment> segmentRectangle = new ArrayList<Segment>();
		double angleRectangle = 90;
		int index = 1;
		for (Segment segment : getSegments()) {
			Point oppose = null;
			if (index == getSegments().size()) {
				oppose = getSegments().get(0).getPoints().get(0);
			} else {
				oppose = getSegments().get(index).getPoints().get(0);
			}
			if (segment.calculerAngle(oppose) == angleRectangle && !angleDroit.contains(oppose)) {
				angleDroit.add(oppose);
			};
			index++;

		}
		for (Segment segment : getSegments()) {
			if(segment.getPoints().contains(angleDroit.get(0))) {
				segmentRectangle.add(segment);
			};
		}
		return segmentRectangle;
	}

	/** 
	 * 
	 * Calcule la distance la valeur du point du sommet du triangle equilateral
	 * 
	 * @param base longueur de la base du triangle equilateral
	 * @return double liste des segments adjacents à l'angle droit
	 */
	private double pointEquilateral(double base) {
		double hauteur =  Math.pow(base, 2) - Math.pow(base/2, 2);
		return Math.sqrt(hauteur);
	}
	
	// EQUALS, TOSTRING

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		return Objects.equals(listCategorie, other.listCategorie);
	}

	@Override
	public String toString() {
		return "Triangle [listCategorie=" + listCategorie + ", calculerNombreAngles()=" + calculerNombreAngles()
				+ ", calculerPerimetre()=" + calculerPerimetre() + ", toString()=" + super.toString()
				+ ", getSegments()=" + getSegments() + ", getTypeFigure()=" + getTypeFigure() + ", getClass()="
				+ getClass() + "]";
	}
	

}
