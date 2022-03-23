package Geometrie;

import java.util.ArrayList;
import java.util.List;

public abstract class Figure {
	private List<Segment> segments = new ArrayList<Segment>();

	public Figure() {
		// TODO Auto-generated constructor stub
	}
	
	// Une méthode abstraite permettant de calculer l'aire de chaque figure
	protected abstract int calculerAire();
	
	// Une méthode permettant de calculer le périmètre total d'une figure
	protected abstract double calculerPerimetre();

	// Une méthode pouvant afficher la longueur de chacun des segments
	protected void calculerLongueurTotal() {
		int index = 1;
		for (Segment segment :this.segments) {
			double distance = segment.calculerLongueur();
			System.out.printf("Segment %d, longueur = %.1f\n", index,  distance);
			index++;
		};
	};
	
	// Une méthode abstraite permettant de calculer le nombre d'angles
	protected int calculerNombreAngles() {
		List<Double> angles = new ArrayList<>();
		int index = 1;
		for (Segment segment :this.segments) {
			double angle = segment.getPoints().get(0).getAngle(segment.getPoints().get(1));
			System.out.printf("Angle %d = %.1f\n", index, angle);
			angles.add(angle);
			index++;
		}
		return angles.size();
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	};

	
	


}
