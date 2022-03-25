/** 
 * Jeremy Fouquet
 */
package Geometrie;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Figure {

	/**
	 * @param nbPoints
	 */
	public Rectangle(NbPoints nbPoints) {
		super(nbPoints);
		List<Double> S2 = new ArrayList<Double>(4);
		List<Double> S3 = new ArrayList<Double>(4);
		List<Double> S4 = new ArrayList<Double>(4);
		Segment segmentBase = getSegments().get(0);
		S2.add(segmentBase.getPoints().get(0).getX());
		S2.add(segmentBase.getPoints().get(0).getY());
		switch (getTypefigure()) {
		case Rectangle:
			S2.add(segmentBase.getPoints().get(0).getX());
			S2.add(segmentBase.getPoints().get(1).getX()/2);
			S3.add(S2.get(2));
			S3.add(S2.get(3));
			S3.add(segmentBase.getPoints().get(1).getX());
			S3.add(S2.get(3));
			break;
		case Carre:
			S2.add(segmentBase.getPoints().get(0).getX());
			S2.add(segmentBase.getPoints().get(0).getY());
			S3.add(S2.get(2));
			S3.add(S2.get(3));
			S3.add(segmentBase.getPoints().get(1).getX());
			S3.add(S2.get(3));
			break;
		case Losange:
			S2.add(-(segmentBase.getPoints().get(1).getX()/2));
			S2.add(hauteur(segmentBase.calculerLongueur()));
			S3.add(S2.get(2));
			S3.add(S2.get(3));
			S3.add(segmentBase.getPoints().get(1).getX()/2);
			S3.add(S2.get(3));
			break;
		default :
			break;
		}
		S4.add(S3.get(2));
		S4.add(S3.get(3));
		S4.add(segmentBase.getPoints().get(1).getX());
		S4.add(segmentBase.getPoints().get(1).getY());
		getSegments().add(new Segment(S2));
		getSegments().add(new Segment(S3));
		getSegments().add(new Segment(S4));
	}
	
	protected double calculerAire() {
		double aire = getSegments().get(0).calculerLongueur() + getSegments().get(1).calculerLongueur();
		return aire;
	};

}
