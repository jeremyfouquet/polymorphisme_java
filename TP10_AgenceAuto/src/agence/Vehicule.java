package agence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import exception.MonException;

public abstract class Vehicule {
	private TypeMoteur carburant;
	private String immatriculation;
	private double prix;
	private int nbroues;
	private double nbkilometres = 0;
	private double louejusque = Double.NaN;
	private Date dateCT;
	private Date dateMiseEnService;
	private List<Moteur> moteurs = new ArrayList<Moteur>(2);

	public Vehicule(int prix) {
		this.immatriculation = this.getClass().getSimpleName()+AgenceAuto.id++;
		dateMiseEnService = new Date();
	}

	public Vehicule(int prix, TypeMoteur typeMoteur) {
		this(prix);
	}
	
	public abstract String klaxonner();
	
	public double nbKilometreRestant() {
		double km = Double.POSITIVE_INFINITY;
		if(this.moteurs.size() > 0) {
			km = 0;
			for (Carburant typeMoteur : carburant.getCarburant()) {
				Moteur moteur = null;
				for(Moteur m : this.moteurs) {
					if(m.getTypeMoteur().equals(typeMoteur)) {
						moteur = m;
					}
				}
				km += moteur.nbKilometreRestant();
			}
		} else {
			System.out.printf("%s\n", "Le véhicule est mécanique, vous pouvez roulez tant que vous n'êtes pas épuisé");
		}
		return km;
	};
	
	public void ajouterCarburant(double quantite, Carburant carburant) throws MonException {
		if(this.moteurs.size() > 0) {
			double ajoute = quantite;
			boolean stop = false;
			double mis = 1;
			while (ajoute > (double) 0 && stop == false) {
				Moteur moteur = trouveLeMoteurPourLeBonCarburant(carburant);
				if(moteur != null) {
					if (carburant == Carburant.Electrique) {
						Electrique m = (Electrique) moteur;
						m.ajouterCarburant((float)mis);
					} else {
						Essence m = (Essence) moteur;
						m.ajouterCarburant(mis);
					}
					if(moteur.reservoirPlein()) {
						stop = true;
					}
					ajoute -= mis;
				} else {
					throw new MonException("Vous vous trompez de carburant attention !");
				}
			}
			if(stop) {
				System.out.printf("%s\n", "Le véhicule est plein, il n'est plus nécésaire d'ajouter du carburant");
			}
		} else {
			System.out.printf("%s\n", "Le véhicule est mécanique, pas besoin de carburant");
		}
	};
	
	
	
	public void kilometreParcouru() {
		System.out.printf("%s %.1f %s\n", "Le vehicule a parcouru", this.nbkilometres, "kilomètres");
	}
	
	public void rendreLocation() {
		AgenceAuto.vehiculesLoues.remove(this);
		AgenceAuto.vehicules.add(this);
		this.louejusque = Double.NaN;
	}
	
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
	
	public int prochainCT() {
		Date aujourdhui = new Date();
		int annees = 0;
		int prochainCT;
		if (this.dateCT == null) {
			int ct = 4;
			prochainCT = convertionDateEnAnnees(this.dateMiseEnService) + ct;
		} else {
			int ct = 2;
			prochainCT = convertionDateEnAnnees(this.dateCT) + ct;
		}
		annees = prochainCT - convertionDateEnAnnees(aujourdhui);
		if(annees > 0) {
			System.out.printf("Il reste %d annee(s) avant le prochain contrôle technique\n", annees);
		} else if (annees == 0){
			System.out.printf("%s\n", "Vous devez faire votre contrôle technique cette annee");
		} else {
			System.out.printf("Vous avez depassé la date du contrôle technique depuis %d\n", -annees);
		}
		return annees;
	}
	
	public void faireCT() {
		Date aujourdhui = new Date();
		this.dateCT = aujourdhui;
	}
	
	protected void loue(double nbKilometresLoue) {
		this.louejusque = nbkilometres+nbKilometresLoue;
	}
	
	private Moteur trouveLeMoteurPourLeBonCarburant(Carburant carburant) {
		List<Moteur> moteur = new ArrayList<Moteur>(1);
		for (Moteur m : this.moteurs) {
			if (m.getTypeMoteur() == carburant) {
				moteur.add(m);
			}
		}
		Moteur moteurTrouve = null;
		if (moteur.size() > 0) {
			moteurTrouve = moteur.get(0);
		}
		return moteurTrouve;
	}

	private int convertionDateEnAnnees(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		int convertion = Integer.parseInt(df.format(date));
		return convertion;
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
		if(enCoursDeLocation()) {
			if (aRendre()) {
				toReturn = true; 
			}
 		}
		return toReturn;
	}

	private boolean aRendre() {
		return nbkilometres >= this.louejusque;
	}
	
	private boolean enCoursDeLocation() {
		return this.louejusque >= (double) 0;
	}

	//GETTERS, SETTERS, EQUALS, TOSTRING
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
	public TypeMoteur getCarburant() {
		return carburant;
	}
	public void setCarburant(TypeMoteur carburant) {
		this.carburant = carburant;
	}
	public Date getDateMiseEnService() {
		return dateMiseEnService;
	}
	public Date getDateCT() {
		return dateCT;
	}
	public void setDateCT(Date dateCT) {
		this.dateCT = dateCT;
	}
	@Override
	public int hashCode() {
		return Objects.hash(carburant, dateCT, dateMiseEnService, immatriculation, louejusque, moteurs, nbkilometres,
				nbroues, prix);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicule other = (Vehicule) obj;
		return carburant == other.carburant && Objects.equals(dateCT, other.dateCT)
				&& Objects.equals(dateMiseEnService, other.dateMiseEnService)
				&& Objects.equals(immatriculation, other.immatriculation)
				&& Double.doubleToLongBits(louejusque) == Double.doubleToLongBits(other.louejusque)
				&& Objects.equals(moteurs, other.moteurs)
				&& Double.doubleToLongBits(nbkilometres) == Double.doubleToLongBits(other.nbkilometres)
				&& nbroues == other.nbroues && Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix);
	}

	@Override
	public String toString() {
		return "Vehicule [carburant=" + carburant + ", immatriculation=" + immatriculation + ", prix=" + prix
				+ ", nbroues=" + nbroues + ", nbkilometres=" + nbkilometres + ", louejusque=" + louejusque + ", dateCT="
				+ dateCT + ", dateMiseEnService=" + dateMiseEnService + ", moteurs=" + moteurs + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}
}
