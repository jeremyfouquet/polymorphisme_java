/** 
 * @author	Jeremy Fouquet
 */
package Geometrie;

public class Point {
	private double x; // Coordonnée de l'axe des abscisses
	private double y; // Coordonnée de l'axe des ordonnées

	/**
	 * @param x
	 * @param y
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/** 
	 * 
	 * Calcule la distance entre 2 points
	 * SRC : http://www.codeurjava.com/2015/04/droite-et-distance-entre-deux-points-en-java.html#:~:text=La%20th%C3%A9or%C3%A8me%20de%20Pythagore%20est,sqrt().
	 * 
	 * @param p le point dont on souhaite connaitre la distance depuis this
	 * @return double distance entre this et p
	 */
	public double distance(Point p){
		return Math.sqrt(sqr(p.getX()-this.x) + sqr(p.getY()-this.y));
	}

	/** 
	 * 
	 * Calcule le carre d'une valeur
	 * 
	 * @param a la valeur dont on souhaite calculer le carre
	 * @return double le carre de a
	 */
    private double sqr(double a) {
        return a*a;
    }
 
	// GETTERS, SETTERS, EQUALS
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
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
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}
