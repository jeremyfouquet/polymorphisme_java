/** 
 * @author Jeremy Fouquet
 */
package agence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import exception.MonException;

public abstract class Vehicule {
	private TypeMoteur carburant; // type de moteur (Electrique, Essence, Hybride)
	private String immatriculation; // immatriculation unique à chaque vehicule
	private double prix; // prix du vehicule
	private int nbroues; // nombre de roues du vehicule
	private double nbkilometres = 0; // nombre total de kilometre parcouru par le vehicule depuis la mise en circulation
	private double louejusque = Double.NaN; // Dans le cas d'une location la valeur ne doit jamais être dépassé par this.nbkilometres
	private Date dateCT; // Coorespond à la derniere date du contrôle technique realisé sinon null
	private Date dateMiseEnService; // correspond à la date d'instance de classe
	private List<Moteur> moteurs = new ArrayList<Moteur>(2); // Liste des moteurs du vehicule s'il en dispose (cf:carburant)

	/**
	 * 
	 * Constructeur en cas de vehicule mecanique
	 * 
	 * @param prix
	 */
	public Vehicule(double prix) {
		this.immatriculation = this.getClass().getSimpleName()+AgenceAuto.id++;
		dateMiseEnService = new Date();
	}

	/**
	 * 
	 * Constructeur en cas de vehicule à moteur
	 * 
	 * @param prix
	 * @param typeMoteur
	 */
	public Vehicule(double prix, TypeMoteur typeMoteur) {
		this(prix);
	}
	
	/**
	 * 
	 * Retourne une String correspondant au klaxonne du vehicule
	 * 
	 * @return String klaxonne du vehicule
	 */
	public abstract String klaxonner();
	
	/**
	 * 
	 * Calcule le nombre de kilometre que le vehicule est capable de faire en fonction de son moteur
	 * 
	 * @return double nombre de kilometre pouvant être réalisé par le vehicule infinity si le vehicule est mecanique
	 */
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
	
	/**
	 * 
	 * Ajout unite par unite une quantite souhaité de carburant au reservoire du vehicule s'il en a jusqu'à ce qu'il soit plein
	 * 
	 * @param quantite quantite de carburant souhaité ajouté au vehicule
	 * @param carburant Electrique ou Essence
	 * @exception MonException Si le carburant ne convient à aucun moteur
	 */
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
	
	
	/**
	 * 
	 * Affiche le nombre de kilometre parcouru au total avec le vehicule
	 * 
	 */
	public void kilometreParcouru() {
		System.out.printf("%s %.1f %s\n", "Le vehicule a parcouru", this.nbkilometres, "kilomètres");
	}
	
	/**
	 * 
	 * Retrourne le vehicule loué parmis les vehicule à vendre
	 */
	public void rendreLocation() {
		AgenceAuto.vehiculesLoues.remove(this);
		AgenceAuto.vehicules.add(this);
		this.louejusque = Double.NaN;
	}

	/**
	 * 
	 * Parcoure km par km une distance souhaité (pour les vehicule à moteur : tant que le reservoir de carburant n'est pas vide)
	 * 
	 * @param kilometresAParcourir distance à parcourir
	 */
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

	/**
	 * 
	 * Affiche un message d'information sur la date du prochain contrôle technique et calcule l'annee du prochain controle
	 * 
	 * @return int distance en années (à aujourd'hui) jusqu'au prochain contrôle technique
	 */
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
	
	/**
	 * 
	 * Affecte la date du contrôle technique à aujourd'hui
	 * 
	 */
	public void faireCT() {
		Date aujourdhui = new Date();
		this.dateCT = aujourdhui;
	}
	
	/**
	 * 
	 * loue le vehicule pour un certain nombre de kilometre
	 * 
	 * @param double nombre de kilometre durant lequels la location est valide
	 */
	protected void loue(double nbKilometresLoue) {
		this.louejusque = nbkilometres+nbKilometresLoue;
	}
	
	/**
	 * 
	 * Selectionne l'un des moteur de la liste du vehicule en fonction de son carburant
	 * 
	 * @param carburant permet de distinguer le moteur souhaité
	 * @return Moteur moteur souhaité
	 */
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

	/**
	 * 
	 * Convertie un Date en int à partir de son année
	 * 
	 * @param date date depuis laquelle est recupéré l'année
	 * @return int année en int de l'année passé en paramettre
	 */
	private int convertionDateEnAnnees(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		int convertion = Integer.parseInt(df.format(date));
		return convertion;
	}
	
	/**
	 * 
	 * Verifie qu'il y ait 1 moteur et du carburant dans celui ci
	 * 
	 * @return boolean si le moteur à du carburant true sinon false
	 */
	private boolean moteurPremierActif() {
		boolean toReturn = false;
		if (moteurs.size() > 0) {
			if (moteurs.get(0).nbKilometreRestant() > 0) {
				toReturn = true;
			}
		}
		return toReturn;
	}
	
	/**
	 * 
	 * Verifie qu'il y ait 2 moteurs et du carburant dans le 2eme
	 * 
	 * @return boolean si le 2eme moteur à du carburant true sinon false
	 */
	private boolean moteurSecondActif() {
		boolean toReturn = false;
		if (moteurs.size() > 1) {
			if (moteurs.get(1).nbKilometreRestant() > 0) {
				toReturn = true;
			}
		}
		return toReturn;
	}
	
	/**
	 * 
	 * Verifie si la location est terminé
	 * 
	 * @return boolean si la location est terminé true, dans tous les autres cas false
	 */
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
