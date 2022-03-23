package Geometrie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Utilisateur {
	private Scanner sc;
	private HashMap<String, NbPoints> choix;
	private List<List<Segment>> dessins;

	public Utilisateur() {
		this.sc = new Scanner(System.in);
		choix = new HashMap<String, NbPoints>();
		for (NbPoints nbPoints : NbPoints.values()) {
			choix.put(nbPoints.getVal(), nbPoints);
		}
		dessins = new ArrayList<List<Segment>>();
		tracer();
		this.sc.close();
	}
	
	
	public void tracer() {
		String reponse = "";
		System.out.printf("%s\n", "Combien de points souhaitez vous dessiner ?");
		for (NbPoints nbPoints : NbPoints.values()) {
			System.out.printf("%s\n", nbPoints.getVal());
		}
		while (this.choix.get(reponse) == null) {
			reponse = sc.nextLine();
		}
		NbPoints choixFinal = this.choix.get(reponse);
		dessins.add(new ArrayList<Segment>(choixFinal.getNumVal()));
		List<Segment> dessin = dessins.get(dessins.size()-1);
		for (int i = 0; i < choixFinal.getNumSegment(); i++) {
			dessin.add(new Segment(choixFinal));
		}
		System.out.printf("%s\n", this.toString());
	}

	@Override
	public String toString() {
		return "Page [dessin=" + dessins + "]";
	}

}
