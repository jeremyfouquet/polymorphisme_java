package Geometrie;

public class Point {
	private int x; // Coordonnée de l'axe des abscisses
	private int y; // Coordonnée de l'axe des ordonnées

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// http://www.codeurjava.com/2015/04/droite-et-distance-entre-deux-points-en-java.html#:~:text=La%20th%C3%A9or%C3%A8me%20de%20Pythagore%20est,sqrt().
	public double distance(Point p){
		return Math.sqrt((p.getX()-this.getX()) + (p.getY()-this.getY()));
	}
	// https://askcodez.com/java-le-calcul-de-langle-entre-deux-points-en-degres.html
	public double getAngle(Point p) {
	    double angle = Math.toDegrees(Math.atan2(p.y - y, p.x - x));
	    if(angle < 0){
	        angle += 360;
	    }
	    return angle;
	}
	// GETTERS ET SETTERS
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
