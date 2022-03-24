package Geometrie;


public class Point {
	private double x; // Coordonnée de l'axe des abscisses
	private double y; // Coordonnée de l'axe des ordonnées

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// http://www.codeurjava.com/2015/04/droite-et-distance-entre-deux-points-en-java.html#:~:text=La%20th%C3%A9or%C3%A8me%20de%20Pythagore%20est,sqrt().
	protected double distance(Point p){
		return Math.sqrt(sqr(p.getX()-this.x) + sqr(p.getY()-this.y));
	}
    private double sqr(double a) {
        return a*a;
    }
	// GETTERS ET SETTERS

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
