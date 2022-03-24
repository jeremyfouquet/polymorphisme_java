package Geometrie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import exception.MonException;

public class Utilisateur {
	private HashMap<String, NbPoints> choix;
	private List<Segment> segments;
	private List<Figure> figures;

	public Utilisateur() {
		Main.sc = new Scanner(System.in);
		this.choix = new HashMap<String, NbPoints>();
		this.segments = new ArrayList<Segment>();
		this.figures = new ArrayList<Figure>();
		for (NbPoints nbPoints : NbPoints.values()) {
			choix.put(nbPoints.getVal(), nbPoints);
		}
		try {
			while(Main.STOP != true) {
				choixNbPoints();
				System.out.println();
			}
		} catch(MonException e) {
			System.out.printf("%s\n", e.getMessage());
		} finally {
			System.out.printf("%s\n", "ICI");
			Main.sc.close();
		}
	}
	
	
	public void choixNbPoints() throws MonException  {
		String reponse = "";
		System.out.printf("%s\n", "Combien de points souhaitez vous dessiner ?");
		for (NbPoints nbPoints : NbPoints.values()) {
			System.out.printf("%s\n", nbPoints.getVal());
		}
		System.out.printf("%s\n", "ou STOP !");
		while (this.choix.get(reponse) == null) {
			reponse = Main.sc.nextLine();
			if (reponse.equals("STOP")) {
				Main.STOP = true;
				throw new MonException("Vous souhaitez arretez ! Au revoir !");
			}
		}
		NbPoints choixFinal = this.choix.get(reponse);
		tracer(choixFinal);
	}
	
	public void tracer(NbPoints nbPoints) {
		switch (nbPoints) {
		case deux:
			Segment segment = new Segment();
			segments.add(segment);
			System.out.printf("%s\n", "Le segment à été dessiné avec succes");
			segment.afficherCoordonnnees();
			segment.afficherLongueur();
			break;
		case trois:
		case quatre:
			Figure figure = nbPoints == NbPoints.trois ? new Triangle(nbPoints) : new Rectangle(nbPoints);
			System.out.printf("Le %s %s à été dessiné avec succes\n", figure.getClass().getSimpleName(), figure.getTypefigure());
			figure.calculerLongueurSegment(true);
			figure.afficheNombreAngles();
			figure.afficheAire();
			figure.affichePerimetre();
			figures.add(figure);
			break;
		default:
			break;
		}
	}

}
