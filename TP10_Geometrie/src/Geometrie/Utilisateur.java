package Geometrie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Utilisateur {
	private Scanner sc;
	private HashMap<String, NbPoints> choix;
	private List<Segment> segments;
	private List<Figure> figures;

	public Utilisateur() {
		this.sc = new Scanner(System.in);
		this.choix = new HashMap<String, NbPoints>();
		this.segments = new ArrayList<Segment>();
		this.figures = new ArrayList<Figure>();
		for (NbPoints nbPoints : NbPoints.values()) {
			choix.put(nbPoints.getVal(), nbPoints);
		}
		choix();
		this.sc.close();
	}
	
	
	public void choix() {
		String reponse = "";
		System.out.printf("%s\n", "Combien de points souhaitez vous dessiner ?");
		for (NbPoints nbPoints : NbPoints.values()) {
			System.out.printf("%s\n", nbPoints.getVal());
		}
		while (this.choix.get(reponse) == null) {
			reponse = sc.nextLine();
		}
		NbPoints choixFinal = this.choix.get(reponse);
		tracer(choixFinal);
	}
	
	public void tracer(NbPoints nbPoints) {
		switch (nbPoints) {
		case deux:
			Segment segment = new Segment();
			segments.add(segment);
			break;
		case trois:
			Triangle triangle = new Triangle();
			triangle.calculerAire();
			triangle.calculerLongueurTotal();
			triangle.calculerNombreAngles();
			triangle.calculerPerimetre();
			figures.add(triangle);
			break;
		case quatre:
			break;
		default:
			break;
		}
	}

}
