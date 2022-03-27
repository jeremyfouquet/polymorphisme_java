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
		switch (getTypefigure()) {
		case Rectangle:
			S2.add(segmentBase.getPoints().get(0).getX());
			S2.add(segmentBase.getPoints().get(1).getX()/2);
			S2.add(segmentBase.getPoints().get(0).getX());
			S2.add(segmentBase.getPoints().get(0).getY());
			S3.add(segmentBase.getPoints().get(1).getX());
			S3.add(S2.get(1));
			S3.add(S2.get(0));
			S3.add(S2.get(1));
			break;
		case Carre:
			S2.add(segmentBase.getPoints().get(0).getX());
			S2.add(segmentBase.getPoints().get(1).getX());
			S2.add(segmentBase.getPoints().get(0).getX());
			S2.add(segmentBase.getPoints().get(0).getY());
			S3.add(segmentBase.getPoints().get(1).getX());
			S3.add(S2.get(1));
			S3.add(S2.get(0));
			S3.add(S2.get(1));
			break;
		case Losange:
			S2.add(-(segmentBase.getPoints().get(1).getX()/2));
			S2.add(hauteur(segmentBase.calculerLongueur()));
			S2.add(segmentBase.getPoints().get(0).getX());
			S2.add(segmentBase.getPoints().get(0).getY());
			S3.add(segmentBase.getPoints().get(1).getX()/2);
			S3.add(S2.get(1));
			S3.add(S2.get(0));
			S3.add(S2.get(1));
			break;
		default :
			break;
		}
		S4.add(segmentBase.getPoints().get(1).getX());
		S4.add(segmentBase.getPoints().get(1).getY());
		S4.add(S3.get(0));
		S4.add(S3.get(1));
		getSegments().add(new Segment(S2));
		getSegments().add(new Segment(S3));
		getSegments().add(new Segment(S4));
	}
	
	protected double calculerAire() {
		double aire = getSegments().get(0).calculerLongueur() + getSegments().get(1).calculerLongueur();
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

}
