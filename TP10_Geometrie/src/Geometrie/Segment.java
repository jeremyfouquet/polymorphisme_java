/** 
 * @author	Jeremy Fouquet
 */
package Geometrie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Segment {
	private List<Point> points = new ArrayList<Point>(2); // liste des 2 points composants le segment

	public Segment() {
		points.add(new Point(0, 0));
		points.add(new Point(200, 0));
	}
	
	/**
	 * @param points liste des valeurs x1, y1, x2, y2
	 */
	public Segment(List<Double> points) {
		this.points.add(new Point(points.get(0), points.get(1)));
		this.points.add(new Point(points.get(2), points.get(3)));
	}

	/** 
	 * 
	 * Affiche les coordonnees x et y des 2 points du segment
	 * 
	 */
	public void afficherCoordonnnees() {
		char lettre = 'A';
		for (Point point :this.points) {
			System.out.printf("Les coordonnées du point %c sont : ", lettre);
			System.out.printf("x = %.1f ", point.getX());
			System.out.printf("y = %.1f\n", point.getY());
			lettre++;
		}	
		System.out.println();	
	}

	/** 
	 * 
	 * Calcule la longeur du segment
	 * 
	 * @return double distance du segment
	 * @see Point#distance(Point)
	 */
	public double calculerLongueur() {
		double distance = this.points.get(0).distance(this.points.get(1));
		return distance;
	}

	/** 
	 * 
	 * Affiche la longeur du segment
	 * 
	 * @see #calculerLongueur()
	 */
	public void afficherLongueur() {
		System.out.printf("La longueur du segment est de %.1f cm\n", this.calculerLongueur());
		System.out.println();
	}
	
	/** 
	 * 
	 * Calcule un angle à partir de 3 points
	 * SRC : https://stackoverflow.com/questions/1211212/how-to-calculate-an-angle-from-three-points
	 * 
	 * @param oppose point oppose au segment et qui represente le centre de l'angle
	 * @return double angle calculé à partir des 3 points
	 */
	public double calculerAngle(Point oppose, String... rectangle){
    	double CentreX = oppose.getX();
    	double CentreY = oppose.getY();
    	double P1X = this.getPoints().get(0).getX();
    	double P1Y = this.getPoints().get(0).getY();
    	double P2X = this.getPoints().get(1).getX();
    	double P2Y = this.getPoints().get(1).getY();
    	boolean refact = false;
    	for (String r : rectangle) {
			if(r.equals("rectangle")) {
				refact = true;
			}
		}
    	if(refact) {
    		CentreX = this.getPoints().get(0).getX();
        	CentreY = this.getPoints().get(0).getY();
        	P1X = oppose.getX();
        	P1Y = oppose.getY();
        	P2X = this.getPoints().get(1).getX();
        	P2Y = this.getPoints().get(1).getY();
    	}
        double numerator = P2Y*(CentreX-P1X) + CentreY*(P1X-P2X) + P1Y*(P2X-CentreX);
        double denominator = (P2X-CentreX)*(CentreX-P1X) + (P2Y-CentreY)*(CentreY-P1Y);
        double ratio = numerator/denominator;
        double angleRad = Math.atan(ratio);
        double angleDeg = (angleRad*180)/Math.PI;
        if(angleDeg<0){
            angleDeg = 180+angleDeg;
        }
        return angleDeg;
    }
	
	// GETTERS, SETTERS, EQUALS, TOSTRING
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segment other = (Segment) obj;
		return Objects.equals(points, other.points);
	}
	@Override
	public String toString() {
		return "Segment [points=" + points + "]";
	}
}
