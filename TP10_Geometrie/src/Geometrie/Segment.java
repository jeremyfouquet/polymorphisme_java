package Geometrie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Segment {
	private List<Point> points = new ArrayList<Point>(2);

	public Segment() {
		points.add(new Point(0, 0));
		points.add(new Point(10, 0));
	}
	
	public Segment(List<Double> points) {
		this.points.add(new Point(points.get(0), points.get(1)));
		this.points.add(new Point(points.get(2), points.get(3)));
	}

	protected void afficherCoordonnnees() {
		char lettre = 'A';
		for (Point point :this.points) {
			System.out.printf("Les coordonnées du point %c sont : ", lettre);
			System.out.printf("x = %.1f ", point.getX());
			System.out.printf("y = %.1f\n", point.getY());
			System.out.println();
			lettre++;
		}		
	}
	
	protected double calculerLongueur() {
		double distance = this.points.get(0).distance(this.points.get(1));
		return distance;
	}
	
	protected void afficherLongueur() {
		System.out.printf("La longueur du segment est de %.1f cm\n", this.calculerLongueur());
		System.out.println();
	}
	
	// https://stackoverflow.com/questions/1211212/how-to-calculate-an-angle-from-three-points
	protected double calculateAngle(Point oppose){
    	double CentreX = oppose.getX();
    	double CentreY = oppose.getY();
    	double P2X = this.getPoints().get(0).getX();
    	double P2Y = this.getPoints().get(0).getY();
    	double P3X = this.getPoints().get(1).getX();
    	double P3Y = this.getPoints().get(1).getY();
        double numerator = P2Y*(CentreX-P3X) + CentreY*(P3X-P2X) + P3Y*(P2X-CentreX);
        double denominator = (P2X-CentreX)*(CentreX-P3X) + (P2Y-CentreY)*(CentreY-P3Y);
        double ratio = numerator/denominator;
        double angleRad = Math.atan(ratio);
        double angleDeg = (angleRad*180)/Math.PI;
        if(angleDeg<0){
            angleDeg = 180+angleDeg;
        }
        return angleDeg;
    }
	


	//GETTERS ET SETTERS

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
}
