/**
 * @author Jeremy Fouquet
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Ecosysteme.*;
import exception.ActionException;

public class Tests {
	EcoSysteme ecoSysteme;
	List<Especes> mesEspeces;
	
	public Tests() {
		ecoSysteme = new EcoSysteme();
		mesEspeces = ecoSysteme.getEspeces();
		// TODO Auto-generated constructor stub
	}
	
	public void testSeReproduireFleur(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL");
		Fleurs maFleur1 = new Fleurs(mesEspeces);
		Fleurs maFleur2 = new Fleurs(mesEspeces);
		int nbFleursAvant = mesEspeces.size();
		maFleur1.eclore();
		try {
			maFleur1.seReproduire(maFleur2, mesEspeces);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int nbFleursApres = mesEspeces.size();
			boolean conditionTestSucces = nbFleursAvant == nbFleursApres-1;
			System.out.printf("DETAILS DU TEST: nombre de fleurs avant reproduction:%s , nb de fleurs apres:%s\n", nbFleursAvant, nbFleursApres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 2", "PARTICULIER");
		nbFleursAvant = mesEspeces.size();
		try {
			maFleur2.seReproduire(maFleur1, mesEspeces);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int nbFleursApres = mesEspeces.size();
			boolean conditionTestSucces = nbFleursAvant == nbFleursApres;
			System.out.printf("DETAILS DU TEST: nombre de fleurs avant reproduction:%s , nb de fleurs apres:%s\n", nbFleursAvant, nbFleursApres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 3", "PARTICULIER");
		nbFleursAvant = mesEspeces.size();
		try {
			maFleur1.seReproduire(maFleur2, mesEspeces);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int nbFleursApres = mesEspeces.size();
			boolean conditionTestSucces = nbFleursAvant == nbFleursApres;
			System.out.printf("DETAILS DU TEST: nombre de fleurs avant reproduction:%s , nb de fleurs apres:%s\n", nbFleursAvant, nbFleursApres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 4", "PARTICULIER");
		nbFleursAvant = mesEspeces.size();
		maFleur2.eclore();
		try {
			maFleur2.seReproduire(maFleur2, mesEspeces);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int nbFleursApres = mesEspeces.size();
			boolean conditionTestSucces = nbFleursAvant == nbFleursApres;
			System.out.printf("DETAILS DU TEST: nombre de fleurs avant reproduction:%s , nb de fleurs apres:%s\n", nbFleursAvant, nbFleursApres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 5", "PARTICULIER");
		Fleurs maFleur3 = new Fleurs(mesEspeces);
		nbFleursAvant = mesEspeces.size();
		maFleur3.mourir();
		try {
			maFleur2.seReproduire(maFleur3, mesEspeces);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int nbFleursApres = mesEspeces.size();
			boolean conditionTestSucces = nbFleursAvant == nbFleursApres;
			System.out.printf("DETAILS DU TEST: nombre de fleurs avant reproduction:%s , nb de fleurs apres:%s\n", nbFleursAvant, nbFleursApres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		mesEspeces = new ArrayList<Especes>();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.println();
	}

	public void testSeReproduireLegume(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL");
		Legumes monLegume = new Legumes(mesEspeces);
		int nbLegumesAvant = mesEspeces.size();
		try {
			monLegume.seReproduire(mesEspeces);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int nbLegumesApres = mesEspeces.size();
			boolean conditionTestSucces = nbLegumesAvant == nbLegumesApres-1;
			System.out.printf("DETAILS DU TEST: nombre de legumes avant reproduction:%s , nb de legumes apres:%s\n", nbLegumesAvant, nbLegumesApres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 2", "PARTICULIER");
		nbLegumesAvant = mesEspeces.size();
		try {
			monLegume.seReproduire(mesEspeces);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int nbLegumesApres = mesEspeces.size();
			boolean conditionTestSucces = nbLegumesAvant == nbLegumesApres;
			System.out.printf("DETAILS DU TEST: nombre de legumes avant reproduction:%s , nb de legumes apres:%s\n", nbLegumesAvant, nbLegumesApres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		mesEspeces = new ArrayList<Especes>();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.println();
	}
	
	public void testSeNourirHerbivore(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL");
		Legumes monLegume = new Legumes(mesEspeces);
		Herbivores monAnimale = new Herbivores(mesEspeces);
		boolean avant = mesEspeces.contains(monLegume);
		monAnimale.seNourir(monLegume, mesEspeces);
		boolean apres = mesEspeces.contains(monLegume);
		boolean conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence du vegetale dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		System.out.printf("%s %s\n", "CAS 2", "NORMAL");
		Fleurs maFleur = new Fleurs(mesEspeces);
		avant = mesEspeces.contains(maFleur);
		monAnimale.seNourir(maFleur, mesEspeces);
		apres = mesEspeces.contains(maFleur);
		conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence du vegetale dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		mesEspeces = new ArrayList<Especes>();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.println();
	}
	
	public void testSeNourirCharognard(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "PARTICULIER");
		Charognards monAnimale1 = new Charognards(mesEspeces);
		Herbivores monAnimale2 = new Herbivores(mesEspeces);
		boolean avant = mesEspeces.contains(monAnimale2);
		try {
			monAnimale1.seNourir(monAnimale2, mesEspeces);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			boolean apres = mesEspeces.contains(monAnimale2);
			boolean conditionTestSucces = avant && apres;
			System.out.printf("DETAILS DU TEST: Presence de l'animal dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();

		}
		System.out.printf("%s %s\n", "CAS 2", "NORMAL");
		monAnimale2.mourir();
		avant = mesEspeces.contains(monAnimale2);
		try {
			monAnimale1.seNourir(monAnimale2, mesEspeces);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			boolean apres = mesEspeces.contains(monAnimale2);
			boolean conditionTestSucces = avant && !apres;
			System.out.printf("DETAILS DU TEST: Presence de l'animal dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();

		}
		mesEspeces = new ArrayList<Especes>();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.println();
	}
	
	public void testSeNourirOmnivore(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL");
		Omnivores monAnimale = new Omnivores(mesEspeces);
		Vegetaux monLegume = new Legumes(mesEspeces);
		boolean avant = mesEspeces.contains(monLegume);
		monAnimale.seNourir(monLegume, mesEspeces);
		boolean apres = mesEspeces.contains(monLegume);
		boolean conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence du vegetale dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		System.out.printf("%s %s\n", "CAS 2", "NORMAL");
		Herbivores monAnimale2 = new Herbivores(mesEspeces);
		avant = mesEspeces.contains(monAnimale2);
		monAnimale.seNourir(monAnimale2, mesEspeces);
		apres = mesEspeces.contains(monAnimale2);
		conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence de l'animal dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		System.out.printf("%s %s\n", "CAS 3", "NORMAL");
		Carnivores monAnimale3 = new Carnivores(mesEspeces);
		avant = mesEspeces.contains(monAnimale3);
		monAnimale.seNourir(monAnimale3, mesEspeces);
		apres = mesEspeces.contains(monAnimale3);
		conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence de l'animal dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		System.out.printf("%s %s\n", "CAS 4", "NORMAL");
		Oeuf monOeuf = new Oeuf(EspecesAnimale.Herbivore, mesEspeces);
		avant = mesEspeces.contains(monOeuf);
		monAnimale.seNourir(monOeuf, mesEspeces);
		apres = mesEspeces.contains(monOeuf);
		conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence de l'oeuf dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		mesEspeces = new ArrayList<Especes>();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.println();
	}
	
	public void testSeNourirCarnivore(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL");
		Carnivores monAnimale = new Carnivores(mesEspeces);
		Carnivores monAnimale2 = new Carnivores(mesEspeces);
		boolean avant = mesEspeces.contains(monAnimale2);
		monAnimale.seNourir(monAnimale2, mesEspeces);
		boolean apres = mesEspeces.contains(monAnimale2);
		boolean conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence de l'animal dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		System.out.printf("%s %s\n", "CAS 2", "NORMAL");
		Herbivores monAnimale3 = new Herbivores(mesEspeces);
		avant = mesEspeces.contains(monAnimale3);
		monAnimale.seNourir(monAnimale3, mesEspeces);
		apres = mesEspeces.contains(monAnimale3);
		conditionTestSucces = avant && !apres;
		System.out.printf("DETAILS DU TEST: Presence de l'animal dans la liste des especes de l'ecosysteme avant : %b, apres : %b\n", avant, apres);
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		mesEspeces = new ArrayList<Especes>();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.println();
	}
	
	public void testSeReproduireOvipare(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL");
		Herbivores monAnimaleF = new Herbivores(Sexe.femelle, 1.0, 100, 8, mesEspeces);
		Herbivores monAnimaleM = new Herbivores(Sexe.male, 1.0, 100, 8, mesEspeces);
		int avant = mesEspeces.size();
		Herbivores enfant = null;
		try {
			monAnimaleF.seReproduire(monAnimaleM, mesEspeces);
			enfant = (Herbivores) mesEspeces.get(mesEspeces.size()-1);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int apres = mesEspeces.size();
			boolean conditionTestSucces = enfant == null ? avant == apres : avant == apres-1;
			System.out.printf("DETAILS DU TEST: Nombre d'animal avant reproduction:%d , nb apres:%d\n", avant, apres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 2", "PARTICULIER");
		avant = mesEspeces.size();
		enfant = null;
		try {
			monAnimaleF.seReproduire(monAnimaleF, mesEspeces);
			enfant = (Herbivores) mesEspeces.get(mesEspeces.size()-1);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int apres = mesEspeces.size();
			boolean conditionTestSucces = enfant == null ? avant == apres : avant == apres-1;
			System.out.printf("DETAILS DU TEST: Nombre d'animal avant reproduction:%d , nb apres:%d\n", avant, apres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 3", "PARTICULIER");
		monAnimaleM.mourir();
		avant = mesEspeces.size();
		enfant = null;
		try {
			monAnimaleF.seReproduire(monAnimaleM, mesEspeces);
			enfant = (Herbivores) mesEspeces.get(mesEspeces.size()-1);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int apres = mesEspeces.size();
			boolean conditionTestSucces = enfant == null ? avant == apres : avant == apres-1;
			System.out.printf("DETAILS DU TEST: Nombre d'animal avant reproduction:%d , nb apres:%d\n", avant, apres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		mesEspeces = new ArrayList<Especes>();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.println();
	}
	
	public void testSeReproduireVivipare(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL");
		Omnivores monAnimale = new Omnivores(Sexe.femelle, 1.0, 100, 8, mesEspeces);
		int avant = mesEspeces.size();
		Oeuf oeuf = null;
		try {
			monAnimale.seReproduire(mesEspeces);
			oeuf = (Oeuf) mesEspeces.get(mesEspeces.size()-1);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int apres = mesEspeces.size();
			boolean conditionTestSucces = oeuf == null ? avant == apres : avant == apres-1;
			System.out.printf("DETAILS DU TEST: Nombre d'espece avant reproduction:%d , nb apres:%d\n", avant, apres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 2", "PARTICULIER");
		monAnimale.mourir();
		avant = mesEspeces.size();
		oeuf = null;
		try {
			monAnimale.seReproduire(mesEspeces);
			oeuf = (Oeuf) mesEspeces.get(mesEspeces.size()-1);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int apres = mesEspeces.size();
			boolean conditionTestSucces = oeuf == null ? avant == apres : avant == apres-1;
			System.out.printf("DETAILS DU TEST: Nombre d'espece avant reproduction:%d , nb apres:%d\n", avant, apres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 3", "PARTICULIER");
		Omnivores monAnimale2 = new Omnivores(Sexe.male, 1.0, 100, 8, mesEspeces);
		avant = mesEspeces.size();
		oeuf = null;
		try {
			monAnimale2.seReproduire(mesEspeces);
			oeuf = (Oeuf) mesEspeces.get(mesEspeces.size()-1);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			int apres = mesEspeces.size();
			boolean conditionTestSucces = oeuf == null ? avant == apres : avant == apres-1;
			System.out.printf("DETAILS DU TEST: Nombre d'espece avant reproduction:%d , nb apres:%d\n", avant, apres);
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		mesEspeces = new ArrayList<Especes>();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.println();
	}
	
	public void testFertiliseOeuf(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL");
		Omnivores monAnimale = new Omnivores(Sexe.male, 1.0, 100, 8, mesEspeces);
		new Oeuf(monAnimale.getEspece(), mesEspeces);
		int size = mesEspeces.size() - 1;
		Oeuf oeuf = (Oeuf) mesEspeces.get(size);
		Omnivores enfant = null;
		try {
			monAnimale.fertilise(oeuf, mesEspeces);
			enfant = (Omnivores) mesEspeces.get(size);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			boolean conditionTestSucces = enfant == null ? mesEspeces.get(size).equals(oeuf) : mesEspeces.get(size).equals(enfant);
			System.out.printf("DETAILS DU TEST: L'Oeuf avant la fertilisation est un %s, apres est un %s\n", oeuf.getClass().getSimpleName(), enfant.getClass().getSimpleName());
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 2", "PARTICULIER");
		Omnivores monAnimale2 = new Omnivores(Sexe.femelle, 1.0, 100, 8, mesEspeces);
		new Oeuf(monAnimale.getEspece(), mesEspeces);
		size = mesEspeces.size() - 1;
		oeuf = (Oeuf) mesEspeces.get(size);
		enfant = null;
		try {
			monAnimale2.fertilise(oeuf, mesEspeces);
			enfant = (Omnivores) mesEspeces.get(size);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			Especes espece = mesEspeces.get(size);
			boolean conditionTestSucces = enfant == null ? mesEspeces.get(size).equals(oeuf) : mesEspeces.get(size).equals(enfant);
			System.out.printf("DETAILS DU TEST: L'Oeuf avant la fertilisation est un %s, apres est un %s\n", espece.getClass().getSimpleName(), espece.getClass().getSimpleName());
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 3", "PARTICULIER");
		size = mesEspeces.size() - 1;
		oeuf = (Oeuf) mesEspeces.get(size);
		oeuf.mourir();
		enfant = null;
		try {
			monAnimale.fertilise(oeuf, mesEspeces);
			enfant = (Omnivores) mesEspeces.get(size);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			Especes espece = mesEspeces.get(size);
			boolean conditionTestSucces = enfant == null ? mesEspeces.get(size).equals(oeuf) : mesEspeces.get(size).equals(enfant);
			System.out.printf("DETAILS DU TEST: L'Oeuf avant la fertilisation est un %s, apres est un %s\n", espece.getClass().getSimpleName(), espece.getClass().getSimpleName());
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		System.out.printf("%s %s\n", "CAS 4", "PARTICULIER");
		new Oeuf(monAnimale.getEspece(), mesEspeces);
		size = mesEspeces.size() - 1;
		oeuf = (Oeuf) mesEspeces.get(size);
		monAnimale.mourir();
		enfant = null;
		try {
			monAnimale.fertilise(oeuf, mesEspeces);
			enfant = (Omnivores) mesEspeces.get(size);
		} catch (ActionException e) {
			System.out.printf("%s \n", e.getMessage());
		} finally {
			Especes espece = mesEspeces.get(size);
			boolean conditionTestSucces = enfant == null ? mesEspeces.get(size).equals(oeuf) : mesEspeces.get(size).equals(enfant);
			System.out.printf("DETAILS DU TEST: L'Oeuf avant la fertilisation est un %s, apres est un %s\n", espece.getClass().getSimpleName(), espece.getClass().getSimpleName());
			System.out.printf("SUCCES : %b \n", conditionTestSucces);
			System.out.println();
		}
		mesEspeces = new ArrayList<Especes>();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.println();
	}
	
	public void testAjouterEtVoir(String nom) {
		System.out.printf("TEST : %s\n",nom);			
		System.out.println();
		System.out.printf("%s %s\n", "CAS 1", "NORMAL");
		ecoSysteme = new EcoSysteme();
		mesEspeces = ecoSysteme.getEspeces();
		int avant = mesEspeces.size();
		int size = Arrays.asList(TypeEspece.values()).size();
		new Carnivores(mesEspeces);
		new Herbivores(mesEspeces);
		new Charognards(mesEspeces);
		new Omnivores(mesEspeces);
		new Fleurs(mesEspeces);
		new Legumes(mesEspeces);
		new Oeuf(EspecesAnimale.Carnivore, mesEspeces);
		int apres = mesEspeces.size();
		boolean conditionTestSucces = avant == apres - size;
		System.out.printf("DETAILS DU TEST: L'ecosysteme avant avoir ajouté les %d types d'especes différentes est de : %d, apres est de : %d\n", size, avant, apres);
		ecoSysteme.voirEspeces();
		System.out.printf("SUCCES : %b \n", conditionTestSucces);
		System.out.println();
		mesEspeces = new ArrayList<Especes>();
		System.out.printf("%s\n", "-----------------------------------");
		System.out.println();
	}

}
