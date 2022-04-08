/** 
 * @author	Jeremy Fouquet
 */
package Geometrie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public abstract class Figure {
	private List<Segment> segments = new ArrayList<Segment>(); // Liste des segments formant la figure
	private String typeFigure; // type de triangle ou de quadrilatere


	public Figure() {
		this.segments.add(new Segment());
	}
	
	public Figure(Utilisateur auto) {
		this();
	}
	
	/** 
	 * 
	 * ajout les segments à la figure
	 * 
	 */
	protected abstract void ajoutSegments();

	/** 
	 * 
	 * Choisi automatiquement en fonction du nombre d'angle droit et de coté égaux une figure adéquate
	 * 
	 */	
	protected abstract String choixFigureAdapte(Utilisateur auto);

	/** 
	 * 
	 * Permet de calculer l'aire de la figure
	 * 
	 * @return double l'aire calculé
	 */	
	protected abstract double calculerAire();

	/** 
	 * 
	 * Affiche le degree de chaques angles
	 * 
	 */
	protected abstract void afficheDegreeAngles();
	/** 
	 * 
	 * Affiche l'aire calculé
	 * 
	 * @see #calculerAire()
	 */
	protected void afficheAire() {
		System.out.printf("L'aire est de %.1f cm3\n", calculerAire());
		System.out.println();
	};

	/** 
	 * 
	 * Propose de choisir parmis un type de triangle ou un type de quadrilatere
	 * 
	 * @param nomFigure determine la forme triangle ou quadrilatere
	 * @return listeTypeFigure sous type choisi par l'utilisateur
	 */
	protected String choixFigure(String nomFigure, List<String> listeTypeFigure) {
		HashMap<String, String> selection = new HashMap<String, String>(); // HashMap utilisé pour verifier que la reponse est bonne; Permet de traduire le choix de l'utilisateur en TypeFigure
		int i = 1;
		for(String list : Arrays.asList("oui", "non")) {
			selection.put(Integer.toString(i), list);
			i++;
		}
		String choixFinal = null;
		do {
			// iteration de chacun des sous type de la figure tant qu'aucun choix n'a été fait (tant que "oui" n'est pas répondu)
			for(int indice = 0; indice < listeTypeFigure.size() && listeTypeFigure.contains(choixFinal) != true; indice++) {
				String reponse = "";
				System.out.printf("Souhaitez vous dessiner un %s de type : %s ?\n", nomFigure , listeTypeFigure.get(indice));
				System.out.printf("1 -> %s\n", selection.get("1"));
				System.out.printf("2 -> %s\n", selection.get("2"));
				do {
					reponse = Main.sc.nextLine();  // tant que la reponse n'est pas correcte on rentre en boucle
				}
				while (selection.get(reponse) == null);
				if (selection.get(reponse) == "oui") {
					choixFinal = listeTypeFigure.get(indice);
				}
			}
		} while (listeTypeFigure.contains(choixFinal) != true);
		return choixFinal;
	}
	
	/** 
	 * 
	 * Calcule la hauteur d'une figure
	 * SURCHARGE DE METHODE
	 * 
	 * @param base segment representant la base d'un triangle
	 * @return double la hauteur calculé
	 */
	protected double hauteur(double base) {
		double hauteur = (base/2) * Math.sqrt(3);
		return hauteur;
	}

	/** 
	 * 
	 * Calcule la hauteur d'une figure
	 * SURCHARGE DE METHODE
	 * 
	 * @param segment sert de repere pour le point n°1
	 * @param point sert de repere pour le point n°2
	 * @return double la hauteur calculé
	 */
	protected double hauteur(Segment segment, Point point) {
		List<Double> points = new ArrayList<Double>(4);
		points.add(point.getX());
		points.add(segment.getPoints().get(0).getY());
		points.add(point.getX());
		points.add(point.getY());
		Segment segmentHauteur = new Segment(points);
		double hauteur = segmentHauteur.calculerLongueur();
		return hauteur;
	}

	/** 
	 * 
	 * Calcule le nombre d'angle de la figure
	 * 
	 * @return int nombre total d'angle de la figure
	 */
	protected int calculerNombreAngles() {
		List<Point> points = new ArrayList<Point>();
		for (Segment segment : this.segments) {
			Point point1 = segment.getPoints().get(0);
			Point point2 = segment.getPoints().get(1);
			if(points.contains(point1) != true) {
				points.add(point1);
			}
			if(points.contains(point2) != true) {
				points.add(point2);
			}
		}
		int nbAngle = points.size();
		return nbAngle;
	}
	
	/** 
	 * 
	 * Affiche le nombre d'angle calculé
	 * 
	 * @see #afficheNombreAngles()
	 */
	protected void afficheNombreAngles() {
		System.out.printf("Nombre total d'angles est %d\n", this.calculerNombreAngles());
		System.out.println();
	}
	
	/** 
	 * 
	 * Calcule la somme total de tous les segments de la figure
	 * 
	 * @param affiche optionnel ce boolean lorqu'il est à true affiche en plus la longueur de chaque segment et les coordonnées des points associés
	 * @return double somme de la longueur de chaque segment de la figure
	 * @see Segment#afficherLongueur()
	 * @see Segment#afficherCoordonnes()
	 * @see Segment#calculerLongueur()
	 */
	protected double calculerLongueurSegment(boolean... affiche) {
		boolean afficher = false;
		for (boolean a : affiche) {
			afficher = a;
		}
		int index = 1;
		double longueurTotal = 0;
		for (Segment segment :this.segments) {
			if(afficher) {System.out.printf("Segment n°%d : ", index);};
			double longueur = segment.calculerLongueur();
			if(afficher) {
				segment.afficherLongueur();
				segment.afficherCoordonnnees();
			};
			longueurTotal += longueur;
			index++;
		};
		return longueurTotal;
	};

	/** 
	 * 
	 * Calcule le perimetre de la figure
	 * 
	 * @return double perimetre de la figure
	 * @see Figure#calculerLongueurSegment(boolean...)
	 */	
	protected double calculerPerimetre() {
		double perimetre = this.calculerLongueurSegment(false);
		return perimetre;
	}
	
	/** 
	 * 
	 * Affiche le permimetre calculé
	 * 
	 * @see #calculerPerimetre()
	 */	
	protected void affichePerimetre() {
		System.out.printf("Le perimetre est de %.1f cm\n", this.calculerPerimetre());
		System.out.println();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figure other = (Figure) obj;
		return Objects.equals(segments, other.segments) && Objects.equals(typeFigure, other.typeFigure);
	}

	@Override
	public String toString() {
		return "Figure [segments=" + segments + ", typeFigure=" + typeFigure + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	// GETTERS, SETTERS, EQUALS, TOSTRING
	public List<Segment> getSegments() {
		return segments;
	}
	public String getTypeFigure() {
		return typeFigure;
	}

	public void setTypeFigure(String typeFigure) {
		this.typeFigure = typeFigure;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

}
