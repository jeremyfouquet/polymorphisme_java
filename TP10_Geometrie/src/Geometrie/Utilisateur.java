/** 
 * @author	Jeremy Fouquet
 */
package Geometrie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import exception.StopException;

public class Utilisateur {
	private List<Segment> segments; // liste des segments realisés sans figure
	private List<Figure> figures; // liste des figures réalisés


	public Utilisateur() {
		Main.sc = new Scanner(System.in);
		this.segments = new ArrayList<Segment>();
		this.figures = new ArrayList<Figure>();
		choixNbPoints();
	}
	
	/** 
	 * 
	 * Propose à l'utilisateur de choisir entre 2, 3 ou 4 points ou le generateur (pas fait !!!!!!)
	 * 
	 * @see	#tracer(String)
	 */
	public void choixNbPoints() {
		do{    
			try {
				List<String> listeChoix = Arrays.asList("2", "3", "4", "Je prefere utiliser le générateur de figure !");
				if(figures.size() > 0) {
					listeChoix = Arrays.asList("2", "3", "4", "Je prefere utiliser le générateur de figure !", "Voir un dessin de la derniere figure ( parce que c'est fun !)");				
				}
				String choix = choixEtSaisie("Combien de points souhaitez vous dessiner ?", listeChoix);  
				tracer(choix);
			} catch(StopException e) {
				System.out.printf("%s\n", e.getMessage());
				Main.sc.close();
			} finally {
			}
		} while(Main.STOP != true);  // le programme tourne en boucle tant que l'utilisateur ne l'interrompte pas avec STOP
		Main.sc.close();
	}
	
	/** 
	 * 
	 * Dessine un segment, un triangle ou un quadrilatere puis l'ajout dans sa liste avant d'afficher ses detailles
	 * 
	 * @param nbPoints choix de l'utilisateur qui determine le nombre de points et de segments
	 * @see Segment#afficherCoordonnnees()
	 * @see	Segment#afficherLongueur()
	 * @see	Figure#calculerLongueurSegment(boolean...)
	 * @see	Figure#afficheNombreAngles()
	 * @see	Figure#afficheAire()
	 * @see	Figure#affichePerimetre()
	 */
	public void tracer(String nbPoints) {
		switch (nbPoints) {
			case "2":
				Segment segment = new Segment();
				segments.add(segment);
				afficherSegment(segment);
				break;
			case "3":
			case "4":
				Figure figure = nbPoints == "3" ? new Triangle() : new Rectangle();
				figures.add(figure);
				afficherFigure(figure);
				break;
			case "Voir un dessin de la derniere figure ( parce que c'est fun !)":
				Figure f = figures.get(figures.size()-1);
				new DrawFigure(f);
				break;
			default:
				choixCotes();
				break;
		}
	}
	
	/** 
	 * 
	 * Propose une liste de choix et retourne celle selectionnée par l'utilisateur
	 * 
	 * @param question question à poser à l'utilisateur
	 * @param selections list de string de selection à proposer à l'utilisateur
	 * @exception StopException Si l'utilisateur ecrit "STOP" arrete la saisie
	 */
	public String choixEtSaisie(String question, List<String> selections) throws StopException  {
		String reponse = "";
		HashMap<String, String> choix = new HashMap<String, String>(); // HashMap utilisé pour verifier que la reponse est bonne; Permet de traduire le choix de l'utilisateur en sa reponse
		System.out.printf("%s\n", question);
		int i = 1;
		for (String select : selections) {
			choix.put(Integer.toString(i), select);
			System.out.printf("%d -> %s\n", i, select);
			i++;
		}
		System.out.printf("%d -> %s\n", 0, "STOP !");
		do {
			reponse = Main.sc.nextLine();
			if (reponse.equals("0")) {
				Main.STOP = true;
				throw new StopException("Au revoir !");
			}
		}
		while (choix.get(reponse) == null);
		return choix.get(reponse);
	}
	

	/** 
	 * 
	 * Choisi un nombre de côté entre 3 et 4
	 * 
	 * @see #generateurDeFigure(int)
	 */
	public void choixCotes() {
		int nbCote = 0;
		try {
			nbCote = Integer.parseInt(choixEtSaisie("Choisissez un nombre de côtés", Arrays.asList("3", "4")));  
		} catch(StopException e) {
			System.out.printf("%s\n", e.getMessage());
		} finally {
			generateurDeFigure(nbCote);
			System.out.println();
		}
	}

	/** 
	 * 
	 * Générateur de figure
	 * 
	 * @param nbCote nombre de côté choisi par l'utilisateur
	 * @see #afficherFigure(Figure)
	 */
	public void generateurDeFigure(int nbCote) {
		Figure figure = nbCote == 3 ? new Triangle(this) : new Rectangle(this);
		figures.add(figure);
		afficherFigure(figure);
	}

	/** 
	 * 
	 * Affiche les détails du segment dessiné
	 * 
	 * @param segment segment à afficher
	 * 
	 */
	public void afficherSegment(Segment segment) {
				System.out.printf("Le %s à été dessiné avec succes\n", segment.getClass().getSimpleName());
				System.out.println();
				segment.afficherCoordonnnees();
				segment.afficherLongueur();
	}

	/** 
	 * 
	 * Affiche les détails de la figure déssiné
	 * @param figure figure à afficher
	 */
	public void afficherFigure(Figure figure) {
			figures.add(figure);
			System.out.printf("Le %s de type %s à été dessiné avec succes\n", figure.getClass().getSimpleName(), figure.getTypeFigure());
			System.out.println();
			figure.calculerLongueurSegment(true);
			figure.afficheNombreAngles();
			figure.afficheDegreeAngles();
			figure.afficheAire();
			figure.affichePerimetre();
	}
	

}
