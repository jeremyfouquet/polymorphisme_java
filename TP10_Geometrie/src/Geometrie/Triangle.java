package Geometrie;

public class Triangle extends Figure {

	public Triangle() {
		super();
		super.getSegments().add(new Segment());
		super.getSegments().add(new Segment());
		super.getSegments().add(new Segment());
		// TODO Auto-generated constructor stub
	}
	
	// Une méthode abstraite permettant de calculer l'aire de chaque figure
	protected int calculerAire() {
		return 0;
	};
	
	// Une méthode permettant de calculer le périmètre total d'une figure
	protected double calculerPerimetre() {
		double perimetre = super.getSegments().get(0).calculerLongueur() + super.getSegments().get(1).calculerLongueur() + super.getSegments().get(2).calculerLongueur();
		System.out.printf("Perimetre : %.1f\n", perimetre);
		return perimetre;
	};
	

}
