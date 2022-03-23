package Geometrie;

import java.util.ArrayList;
import java.util.List;

public abstract class Figure {
	private List<Segment> segments = new ArrayList<Segment>(4);

	public Figure() {
		this.segments.add(new Segment(NbPoints.deux));
		// TODO Auto-generated constructor stub
	}
	
	// Une méthode abstraite permettant de calculer l'aire de chaque figure
	public abstract int calculerAire();
	
	// Une méthode abstraite permettant de calculer le nombre d'angles
	public abstract int calculerNombreAngles();

	// Une méthode pouvant afficher la longueur de chacun des segments
	public void calculerLongueurTotal() {
		for (Segment segment :this.segments) {
			double distance = segment.calculerLongueur();
			System.out.printf("distance = %.1f\n", distance);
		};
	};
	
	// Une méthode permettant de calculer le périmètre total d'une figure
	public abstract int calculerPerimetre();

	
	


}
