/** 
 * @author	Jeremy Fouquet
 */
package Geometrie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import exception.StopException;

public class Rectangle extends Figure {
	private List<String> listCategorie = Arrays.asList("Rectangle", "Carre", "Losange");

	public Rectangle() {
		super();
		setTypeFigure(choixFigure("Quadrilatere", listCategorie));
		ajoutSegments();
	}
	
	public Rectangle(Utilisateur auto) {
		super();
		setTypeFigure(choixFigureAdapte(auto));
		ajoutSegments();
	}
	
	protected void ajoutSegments() {
		List<Double> S2 = new ArrayList<Double>(4);
		List<Double> S3 = new ArrayList<Double>(4);
		List<Double> S4 = new ArrayList<Double>(4);
		Segment segmentBase = getSegments().get(0);
		switch (getTypeFigure()) {
		case "Rectangle":
			S2.add(segmentBase.getPoints().get(0).getX());
			S2.add(segmentBase.getPoints().get(1).getX()/2);
			S2.add(segmentBase.getPoints().get(0).getX());
			S2.add(segmentBase.getPoints().get(0).getY());
			S3.add(segmentBase.getPoints().get(1).getX());
			break;
		case "Carre":
			S2.add(segmentBase.getPoints().get(0).getX());
			S2.add(segmentBase.getPoints().get(1).getX());
			S2.add(segmentBase.getPoints().get(0).getX());
			S2.add(segmentBase.getPoints().get(0).getY());
			S3.add(segmentBase.getPoints().get(1).getX());
			break;
		case "Losange":
			S2.add((segmentBase.getPoints().get(1).getX()/2));
			S2.add(hauteur(segmentBase.calculerLongueur()));
			S2.add(segmentBase.getPoints().get(0).getX());
			S2.add(segmentBase.getPoints().get(0).getY());
			S3.add(segmentBase.getPoints().get(1).getX()+S2.get(0));
			break;
		}
		S3.add(S2.get(1));
		S3.add(S2.get(0));
		S3.add(S2.get(1));
		S4.add(segmentBase.getPoints().get(1).getX());
		S4.add(segmentBase.getPoints().get(1).getY());
		S4.add(S3.get(0));
		S4.add(S3.get(1));
		getSegments().add(new Segment(S2));
		getSegments().add(new Segment(S3));
		getSegments().add(new Segment(S4));
	}
	
	protected String choixFigureAdapte(Utilisateur auto) {
		String typeRectangle = null;
		int angleRectangle = 0;
		int coteEgaux = 0;
		try {
			angleRectangle = Integer.parseInt(auto.choixEtSaisie("Choisissez un nombre d'angle droit", Arrays.asList("0", "4")));
			if(angleRectangle == 4) {
				coteEgaux = Integer.parseInt(auto.choixEtSaisie("Choisissez un nombre de côté égaux", Arrays.asList("2", "4")));
				if(coteEgaux == 2) {
					typeRectangle = "Rectangle";
				} else {
					typeRectangle = "Carre";
				}
			} else {
				coteEgaux = Integer.parseInt(auto.choixEtSaisie("Choisissez un nombre de côté égaux", Arrays.asList("2", "4")));
				typeRectangle = "Losange";
			}
		} catch(StopException e) {
			System.out.printf("%s\n", e.getMessage());
		}
		return typeRectangle;
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
			double degreeAngle = segment.calculerAngle(oppose, "rectangle");
			System.out.printf("Angle n°%d %.1f degree\n", index+1, degreeAngle);
			index++;
		}
		System.out.println();
	}
	
	// EQUALS, TOSTRING

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		return Objects.equals(listCategorie, other.listCategorie);
	}

	@Override
	public String toString() {
		return "Rectangle [listCategorie=" + listCategorie + ", calculerNombreAngles()=" + calculerNombreAngles()
				+ ", calculerPerimetre()=" + calculerPerimetre() + ", toString()=" + super.toString()
				+ ", getSegments()=" + getSegments() + ", getTypeFigure()=" + getTypeFigure() + ", getClass()="
				+ getClass() +"]";
	}

}
