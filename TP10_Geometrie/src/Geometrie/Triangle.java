package Geometrie;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Figure {

	public Triangle(NbPoints nbPoints) {
		super(nbPoints);
		List<Double> S2 = new ArrayList<Double>(4);
		List<Double> S3 = new ArrayList<Double>(4);
		double x3 = 0;
		double y3 = 0;
		Segment segmentBase = getSegments().get(0);
		switch (getTypefigure()) {
			case Isocele:
				x3 = segmentBase.getPoints().get(1).getX()/2;
				y3 = 20;
				break;
			case Equilateral:
				x3 = segmentBase.getPoints().get(1).getX()/2;
				y3 = pointEquilateral(segmentBase.calculerLongueur());
				break;
			case Rectangle:
				x3 = segmentBase.getPoints().get(0).getX();
				y3 = segmentBase.getPoints().get(1).getX()/2;
				break;
			default :
				break;
		}
		S2.add(segmentBase.getPoints().get(0).getX());
		S2.add(segmentBase.getPoints().get(0).getY());
		S2.add(x3);
		S2.add(y3);
		S3.add(x3);
		S3.add(y3);
		S3.add(segmentBase.getPoints().get(1).getX());
		S3.add(segmentBase.getPoints().get(1).getY());
		getSegments().add(new Segment(S2));
		getSegments().add(new Segment(S3));
	}
	
	protected double calculerAire() {
		Segment segment1 = getSegments().get(0);
		Segment segment2 = getSegments().get(1);
		Segment segment3 = getSegments().get(2);
		double base = 0;
		double hauteur = 0;
		switch (getTypefigure()) {
			case Equilateral:
				base = segment1.calculerLongueur();
				hauteur = hauteur(base);
				break;
			case Isocele:
				base = 
					segment1.calculerLongueur() == segment2.calculerLongueur() ? segment3.calculerLongueur() :
					segment1.calculerLongueur() == segment3.calculerLongueur() ? segment2.calculerLongueur() :
					segment1.calculerLongueur();
				hauteur = hauteur(segment1, segment2.getPoints().get(1));
				break;
			case Rectangle:
				List<Segment> segmentRectangle = segmentRectangle();
				base = segmentRectangle.get(0).calculerLongueur();
				hauteur = segmentRectangle.get(1).calculerLongueur();
				break;
			default :
				break;
		}
		double aire = 0.5 * base * hauteur;
		return aire;
	};
	
	protected List<Segment> segmentRectangle() {
		List<Point> angleDroit = new ArrayList<Point>();
		List<Segment> segmentRectangle = new ArrayList<Segment>();
		double angleRectangle = 90;
		int index = 1;
		for (Segment segment : getSegments()) {
			Point oppose = null;
			if(index == getSegments().size()) {
				oppose = getSegments().get(0).getPoints().get(0);
			} else {
				oppose = getSegments().get(index).getPoints().get(1);
			}
			if (segment.calculateAngle(oppose) == angleRectangle && !angleDroit.contains(oppose)) {
				angleDroit.add(oppose);
			};
			index++;

		}
		for (Segment segment :getSegments()) {
			if(segment.getPoints().contains(angleDroit.get(0))) {
				segmentRectangle.add(segment);
			};
			
		}
		return segmentRectangle;
	}
	
	private double pointEquilateral(double base) {
		double hauteur =  Math.pow(base, 2) - Math.pow(base/2, 2);
		return Math.sqrt(hauteur);
	}
	

}
