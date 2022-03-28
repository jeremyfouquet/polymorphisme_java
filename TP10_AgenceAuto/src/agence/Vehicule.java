package agence;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicule {
	private Carburant carburant;
	private String immatriculation;
	private double prix;
	private int nbroues;
	private double nbkilometres = 0;
	private double louejusque = Double.NaN;
	private List<Moteur> moteurs = new ArrayList<Moteur>();

	public Vehicule(int prix) {
		this.immatriculation = this.getClass().getSimpleName()+AgenceAuto.id++;
	}

	public Vehicule(int prix, TypeMoteur typeMoteur) {
		this(prix);
	}
	
	public abstract String klaxonner();
	
	public void kilometreParcouru() {
		System.out.printf("%s %.1f %s\n", "Le vehicule a parcouru", this.nbkilometres, "kilomètres");
	}
	
	public void rendreLocation() {
		AgenceAuto.vehiculesLoues.remove(this);
		AgenceAuto.vehicules.add(this);
		this.louejusque = Double.NaN;
	}
	
	// A VOIR POUR INSTALLER UN WHILLE QUI RETIRE 1 PAR 1 LES KILOMETRE PARCOURU
	public void seDeplacer(double kilometresAParcourir) {
		double avance = 1;
		double parcouru = kilometresAParcourir;
		boolean stop = false;
		while (parcouru > (double) 0 && stop == false) {
			if(moteurs.size() > 0) {
				if (moteurPremierActif()) {
					nbkilometres += avance;
					moteurs.get(0).utiliserCarburant(avance);
				} else if (moteurSecondActif()) {
					nbkilometres += avance;
					moteurs.get(1).utiliserCarburant(avance);
				} else {
					System.out.printf("%s\n", "Le vehicule est en panne de carburant");
					stop = true;
				}
			} else {
				nbkilometres += avance;
				if(doitEtreRendu()) {
					 rendreLocation();
					 System.out.printf("%s\n", "La location à été rendu car les kilomètres sont épuisés");
					 stop = true;
				}
			}
			parcouru -= avance;
		}
		
		
	}
	
	protected void loue(double nbKilometresLoue) {
		this.louejusque = nbkilometres+nbKilometresLoue;
	}
	
	private boolean moteurPremierActif() {
		boolean toReturn = false;
		if (moteurs.size() > 0) {
			if (moteurs.get(0).nbKilometreRestant() > 0) {
				toReturn = true;
			}
		}
		return toReturn;
	}
	
	private boolean moteurSecondActif() {
		boolean toReturn = false;
		if (moteurs.size() > 1) {
			if (moteurs.get(1).nbKilometreRestant() > 0) {
				toReturn = true;
			}
		}
		return toReturn;
	}
	
	private boolean doitEtreRendu() {
		boolean toReturn = false;
		if(enCourtDeLocation()) {
			if (aRendre()) {
				toReturn = true; 
			}
 		}
		return toReturn;
	}
	
	
	private boolean aRendre() {
		return nbkilometres >= this.louejusque;
	}
	
	private boolean enCourtDeLocation() {
		return this.louejusque >= (double) 0;
	}

	//GETTERS ET SETTERS
	public String getImmatriculation() {
		return immatriculation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getNbroues() {
		return nbroues;
	}
	public void setNbroues(int nbroues) {
		this.nbroues = nbroues;
	}
	public double getNbkilometres() {
		return nbkilometres;
	}
	public void setNbkilometres(double nbkilometres) {
		this.nbkilometres = nbkilometres;
	}
	public double getLouejusque() {
		return louejusque;
	}
	public void setLouejusque(double louejusque) {
		this.louejusque = louejusque;
	}
	public List<Moteur> getMoteurs() {
		return moteurs;
	}
	public Carburant getCarburant() {
		return carburant;
	}
	public void setCarburant(Carburant carburant) {
		this.carburant = carburant;
	}
}
