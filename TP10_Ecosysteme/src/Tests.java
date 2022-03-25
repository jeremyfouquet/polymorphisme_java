import java.util.ArrayList;

import Ecosysteme.Carnivores;
import Ecosysteme.Charognards;
import Ecosysteme.EcoSysteme;
import Ecosysteme.Especes;
import Ecosysteme.Fleurs;
import Ecosysteme.Herbivores;
import Ecosysteme.Legumes;
import Ecosysteme.Omnivores;
import Ecosysteme.Vegetaux;
import exception.MonException;

public class Tests {
	private EcoSysteme eco;
	
	public Tests() {
		eco = new EcoSysteme();
		// TODO Auto-generated constructor stub
	}
	
	public void testSeReproduireFleur(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL");
		Fleurs maFleur1 = new Fleurs();
		Fleurs maFleur2 = new Fleurs();
		int nbFleursAvant = EcoSysteme.especes.size();
		maFleur1.eclore(true);
		try {
			maFleur1.seReproduire(maFleur2);
		} catch (MonException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int nbFleursApres = EcoSysteme.especes.size();
			boolean conditionTestSucces = nbFleursAvant == nbFleursApres-1;
			System.out.printf("DETAILS DU TEST: nombre de fleurs avant reproduction:%s , nb de fleurs apres:%s\n", nbFleursAvant, nbFleursApres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 2", "PARTICULIER");
		nbFleursAvant = EcoSysteme.especes.size();
		try {
			maFleur2.seReproduire(maFleur1);
		} catch (MonException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int nbFleursApres = EcoSysteme.especes.size();
			boolean conditionTestSucces = nbFleursAvant == nbFleursApres;
			System.out.printf("DETAILS DU TEST: nombre de fleurs avant reproduction:%s , nb de fleurs apres:%s\n", nbFleursAvant, nbFleursApres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 3", "PARTICULIER");
		nbFleursAvant = EcoSysteme.especes.size();
		try {
			maFleur1.seReproduire(maFleur2);
		} catch (MonException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int nbFleursApres = EcoSysteme.especes.size();
			boolean conditionTestSucces = nbFleursAvant == nbFleursApres;
			System.out.printf("DETAILS DU TEST: nombre de fleurs avant reproduction:%s , nb de fleurs apres:%s\n", nbFleursAvant, nbFleursApres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 4", "PARTICULIER");
		nbFleursAvant = EcoSysteme.especes.size();
		maFleur2.eclore(true);
		try {
			maFleur2.seReproduire(maFleur2);
		} catch (MonException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int nbFleursApres = EcoSysteme.especes.size();
			boolean conditionTestSucces = nbFleursAvant == nbFleursApres;
			System.out.printf("DETAILS DU TEST: nombre de fleurs avant reproduction:%s , nb de fleurs apres:%s\n", nbFleursAvant, nbFleursApres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		EcoSysteme.especes = new ArrayList<Especes>();
		System.out.printf("%s\n", "-----------------------------------");
	}

	public void testSeReproduireLegume(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL");
		Legumes monLegume = new Legumes();
		int nbLegumesAvant = EcoSysteme.especes.size();
		try {
			monLegume.seReproduire();
		} catch (MonException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int nbLegumesApres = EcoSysteme.especes.size();
			boolean conditionTestSucces = nbLegumesAvant == nbLegumesApres-1;
			System.out.printf("DETAILS DU TEST: nombre de legumes avant reproduction:%s , nb de legumes apres:%s\n", nbLegumesAvant, nbLegumesApres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 2", "PARTICULIER");
		nbLegumesAvant = EcoSysteme.especes.size();
		try {
			monLegume.seReproduire();
		} catch (MonException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int nbLegumesApres = EcoSysteme.especes.size();
			boolean conditionTestSucces = nbLegumesAvant == nbLegumesApres;
			System.out.printf("DETAILS DU TEST: nombre de legumes avant reproduction:%s , nb de legumes apres:%s\n", nbLegumesAvant, nbLegumesApres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		EcoSysteme.especes = new ArrayList<Especes>();
		System.out.printf("%s\n", "-----------------------------------");
	}
	
	public void testSeNourirHerbivore(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL");
		Legumes monLegume = new Legumes();
		Herbivores monAnimale = new Herbivores();
		boolean avant = EcoSysteme.especes.contains(monLegume);
		monAnimale.seNourir(monLegume);
		boolean apres = EcoSysteme.especes.contains(monLegume);
		boolean conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence du vegetale dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.printf("%s %s\n", "CAS 2", "NORMAL");
		Fleurs maFleur = new Fleurs();
		avant = EcoSysteme.especes.contains(maFleur);
		monAnimale.seNourir(maFleur);
		apres = EcoSysteme.especes.contains(maFleur);
		conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence du vegetale dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		EcoSysteme.especes = new ArrayList<Especes>();
		System.out.printf("%s\n", "-----------------------------------");
	}
	
	public void testSeNourirCharognard(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "PARTICULIER");
		Charognards monAnimale1 = new Charognards();
		Herbivores monAnimale2 = new Herbivores();
		boolean avant = EcoSysteme.especes.contains(monAnimale2);
		try {
			monAnimale1.seNourir(monAnimale2);
		} catch (MonException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			boolean apres = EcoSysteme.especes.contains(monAnimale2);
			boolean conditionTestSucces = avant && apres;
			System.out.printf("DETAILS DU TEST: Presence de l'animal dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();

		}
		System.out.printf("%s\n", "-----------------------------------");
		System.out.printf("%s %s\n", "CAS 2", "NORMAL");
		monAnimale2.mourir();
		avant = EcoSysteme.especes.contains(monAnimale2);
		try {
			monAnimale1.seNourir(monAnimale2);
		} catch (MonException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			boolean apres = EcoSysteme.especes.contains(monAnimale2);
			boolean conditionTestSucces = avant && !apres;
			System.out.printf("DETAILS DU TEST: Presence de l'animal dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();

		}
		EcoSysteme.especes = new ArrayList<Especes>();
		System.out.printf("%s\n", "-----------------------------------");
	}
	
	public void testSeNourirOmnivore(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL");
		Omnivores monAnimale = new Omnivores();
		Vegetaux monLegume = new Legumes();
		boolean avant = EcoSysteme.especes.contains(monLegume);
		monAnimale.seNourir(monLegume);
		boolean apres = EcoSysteme.especes.contains(monLegume);
		boolean conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence du vegetale dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.printf("%s %s\n", "CAS 2", "NORMAL");
		Herbivores monAnimale2 = new Herbivores();
		avant = EcoSysteme.especes.contains(monAnimale2);
		monAnimale.seNourir(monAnimale2);
		apres = EcoSysteme.especes.contains(monAnimale2);
		conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence de l'animal dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.printf("%s %s\n", "CAS 3", "NORMAL");
		Carnivores monAnimale3 = new Carnivores();
		avant = EcoSysteme.especes.contains(monAnimale3);
		monAnimale.seNourir(monAnimale3);
		apres = EcoSysteme.especes.contains(monAnimale3);
		conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence de l'animal dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.printf("%s %s\n", "CAS 4", "NORMAL");
		Vegetaux monOeuf = new Fleurs();
		avant = EcoSysteme.especes.contains(monOeuf);
		monAnimale.seNourir(monOeuf);
		apres = EcoSysteme.especes.contains(monOeuf);
		conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence de l'oeuf dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		System.out.printf("%s\n", "-----------------------------------");
		EcoSysteme.especes = new ArrayList<Especes>();
	}
	
	public void testSeNourirCarnivore(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL");
		Carnivores monAnimale = new Carnivores();
		Carnivores monAnimale2 = new Carnivores();
		boolean avant = EcoSysteme.especes.contains(monAnimale2);
		monAnimale.seNourir(monAnimale2);
		boolean apres = EcoSysteme.especes.contains(monAnimale2);
		boolean conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence de l'animal dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.printf("%s %s\n", "CAS 2", "NORMAL");
		Herbivores monAnimale3 = new Herbivores();
		avant = EcoSysteme.especes.contains(monAnimale3);
		monAnimale.seNourir(monAnimale3);
		apres = EcoSysteme.especes.contains(monAnimale3);
		conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence de l'animal dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		System.out.printf("%s\n", "-----------------------------------");
		EcoSysteme.especes = new ArrayList<Especes>();
	}
	
	public void testSeReproduireOvipare(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL|PARTICULIER");
		Herbivores monAnimale = new Herbivores();
		Herbivores monAnimale2 = new Herbivores();
		int avant = EcoSysteme.especes.size();
		Herbivores enfant = null;
		try {
			monAnimale.seReproduire(monAnimale2);
			enfant = (Herbivores) EcoSysteme.especes.get(EcoSysteme.especes.size()-1);
		} catch (MonException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int apres = EcoSysteme.especes.size();
			boolean conditionTestSucces = enfant == null ? avant == apres : avant == apres-1;
			System.out.printf("DETAILS DU TEST: Nombre d'animal avant reproduction:%d , nb apres:%d\n", avant, apres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
			System.out.printf("%s\n", "-----------------------------------");
		}
		eco.voirEcoSysteme();
		EcoSysteme.especes = new ArrayList<Especes>();
	}

}
