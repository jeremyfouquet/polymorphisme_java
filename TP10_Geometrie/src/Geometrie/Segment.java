package Geometrie;

import java.util.ArrayList;
import java.util.List;

public class Segment {
	private List<Point> points = new ArrayList<Point>(2);

	public Segment() {
		points.add(new Point(0, 0));
		points.add(new Point(0, 10));
	}

	protected void afficherCoordonnnees() {
		char lettre = 'A';
		for (Point point :this.points) {
			System.out.printf("%s %c :\n", "Coordonnées du point", lettre);
			System.out.printf("%s=%d\n", "x", point.getX());
			System.out.printf("%s=%d\n", "y", point.getY());
			lettre++;
		}		
	}
	
	protected double calculerLongueur() {
		double distance = points.get(0).distance(points.get(1));
		return distance;
	}
	
	//GETTERS ET SETTERS
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

}
