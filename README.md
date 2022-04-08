# TP10 : POLYMORPHISME

# EXERCICE 1 - Géométrie

**Principe de base :**

Dans cet exercice, nous souhaitons coder des figures géométriques, pour cela l'utilisateur va saisir un nombre de points compris entre 2 et 4.

Chaque point possédera deux coordonnées x et y.

Si uniquement 2 points sont saisis, notre figure sera un segment.

Si l'utilisateur saisit 3 points, notre figure sera un Triangle, soit : 
* quelconque
* isocèle
* équilatéral
* rectangle

Si 4 points sont saisis, ce sera soit un Carré, un Rectangle ou un Losange.

Chaque figure pourra afficher son nombre de côtés, la longueur de chacun d'eux, le nombre d'angles et le degré de ceux-ci, calculer son périmètre et son aire.

**Question :**

1 Représenter le problème suivant sous forme de diagramme de classe

![diagramme de classe](TP10_Geometrie/assets/diagramme_de_classe.drawio.svg)

2 Implémenter la classe Segment, cette classe possédera un constructeur, des getters et setters ainsi qu'une méthode permettant d'afficher les coordonnées des 2 points du segment et la distance entre ces points.

3 Implémenter la classe abstraite Figure possèdent une liste de segments, et ayant pour méthode :

* Une méthode abstraite permettant de calculer l'aire de chaque figure
* Une méthode abstraite permettant de calculer le nombre d'angles
* Une méthode pouvant afficher la longueur de chacun des segments
* Une méthode permettant de calculer le périmètre total d'une figure

4 Implémenter les classes Triangle et Rectangle héritant de Figure, coder les méthodes abstraites de celles-ci et redéfinir les méthodes nécessaires.

5 Utiliser une surcharge de constructeurs afin de permettre à l'utilisateur de choisir entre un carré, un rectangle, un losange ou entre les différents triangles.

6 Bonus (Pour les maîtres du Java) Coder un générateur de figure qui, en fonction du nombre de côtés souhaité, du nombre d'angles droits et du nombre de côtés égaux, construit la figure la plus adéquate.

# EXERCICE 2 - Écosystème
 
**Principe de base :**

Dans cet exercice, nous souhaitons modéliser un écosystème dans lequel nous trouverons des végétaux ainsi que des animaux. Du côté des végétaux, nous trouverons des fleurs et des légumes. Pour les animaux, nous trouverons des herbivores, des carnivores, des omnivores et des charognards.

* Les herbivores sont des animaux pouvant manger des végétaux de n'importe quel type ou exclusivement des légumes.
* Les carnivores sont des animaux pouvant manger des herbivores ainsi que d'autres carnivores.
* Les omnivores eux peuvent manger des carnivores, des herbivores des plantes ainsi que des œufs.
* Les charognards sont des animaux mangeant des animaux morts.

De plus, chacune des espèces présentent dans cet écosystème pourra se reproduire, pour cela :

* Les légumes posséderont un nombre de graines indiquant le nombre de reproductions possibles.
* Les fleurs utiliseront une quantité de pollen qui se divisera par 2 à chaque reproduction. De plus, pour réaliser cela elles nécessiteront une autre fleur.
* Du côté des animaux ceux-ci seront, soit ovipares et nécessiteront un partenaire du sexe opposé pour se reproduire, soit ils seront vivipares et pondront des œufs.

**Question :**

1 Représenter le problème suivant sous forme de diagramme de classe.

![diagramme de classe](TP10_Ecosysteme/assets/diagramme_de_classe.drawio.svg)

2 Coder les objets Vegetaux, Fleurs et Legumes en choisissant pour chacun d'eux le type de classe approprié. À noter qu'une fleur ne pourra se reproduire que si celle-ci est éclose.

3 Coder les interfaces ovipares et vivipares

4 Coder l'objet Animal héritant des interfaces ovipare et vivipare. Chaque animal possédera une espèce, un sexe, une taille, un poids, une espérance de vie et pourra se nourrir en fonction de son régime alimentaire se reproduire ou mourir pour ensuite être mangé par un charognard. Lors de la reproduction des vivipares, l'enfant récupère aléatoirement les caractéristiques (espérance de vie, poids, taille, sexe) selon celle de son père ou de sa mère. 

5 Coder les différents régimes alimentaires.

6 Ajouter l'objet œuf, cet objet aura des caractéristiques par défaut tant qu'il n'a pas été fertilisé par un mal de son espèce et disparaîtra de son environnement pour laisser place à un animal une fois éclos. À noter que celui-ci peut être consommé par les animaux omnivores.

7 Implémenter votre environnement, celui-ci possédera une liste d'espèces (végétal + animal) et pourra ajouter, retirer ou afficher les espèces de cette liste.

8 Développer un jeu de test dans votre main ou à l'aide de Junit permettant de tester votre programme

# EXERCICE 3 - Agence auto
 
**Présentation :**

Dans cet exercice, nous allons coder une agence de vente et location de véhicules motorisés ou non. Parmi les véhicules proposés, on retrouvera des motos, des voitures, des vélos ou des trottinettes. 

Un véhicule possédera une plaque d'immatriculation, un prix ainsi qu'un nombre de roues. De plus, si celui-ci est motorisé, on précisera aussi son type de motorisation : essence, électrique ou hybride (les 2), la capacité de son réservoir, la date de son dernier contrôle technique ainsi que son
nombre de kilomètres.

Chaque véhicule possédera un klaxon différent et pourra se déplacer, afficher le nombre de kilomètres parcouru, remplir son réservoir si celui-ci en possède un, afficher le nombre de kilomètres restant et afficher le nombre d'années restant avant le prochain contrôle technique.

Concernant les types de carburant nous considérerons l'essence comme un double et 1 unité permettra de faire un kilomètre, l'électrique lui sera un float et 10 unités permettront de réaliser un kilomètre.

Pour finir, un véhicule vendu disparaîtra de la liste des véhicules disponibles. Par contre, un véhicule loué le sera pour un certain nombre de kilomètres, une fois ce nombre atteint le véhicule sera de nouveau disponible à la location.

**Question :**

1 Représenter le problème suivant sous forme de diagramme de classe

![diagramme de classe](TP10_AgenceAuto/assets/diagramme_de_classe.drawio.svg)

2 Implémenter les différents objets de votre diagramme

3 Dans votre main, réaliser un jeu de test permettant de valider vos différentes fonctionnalités. Pour rappel, un jeu de test ne doit pas permettre à l'utilisateur de tester votre programme mais plutôt montrer les différents cas que vous avez vous même testé. Pour réaliser cela, vous êtes libre d'utiliser une technologie comme JUNIT ou de les faire à la main dans votre main. Chaque test doit avoir un commentaire précisant le cas à tester (cas normal ou particulier), exécuter les méthodes nécessaires et afficher les résultats obtenus en console.

# Auto-Évaluation :

**Lisibilité du code** : 0,5/1 bon defois je m'y perd moi même

**Commentaire** : 1/1 j'ai un peu plus commenté certaines methodes complexe (à certaine étapes de celle ci)

**Modélisation** : 2/2 je pense que c'est tout bon cette fois

**Pertinence des tests** : 1/2 mouais je sais pas, je sais jamais par où commencé, quoi mettre, où m'arréter

**Ajout perso** : 2/2 y'en a y'en a (hashMap, Interface de saisie, Generateur de figure, ...)

**Avancement du TP** : 4/4 fini

**Bonne implémentation des concept vu en cours** : 5/6
Je gonfle ma note sait-on jamais  ;P Non en fait je pense avoir bien mieux compris que depuis le premier TP.
Déjà les portés honnetement j'ai encore un peu de difficulté à comprendre quand utiliser static à par dans le main, mais sinon c'est bon j'ai bien compris le public, protected et le private.
Pour les Enums pareil j'en utilisais trop, apres ta correction du TP9 j'ai nettoyé celui ci il y en avait partout c'était une horreur :S
J'ai aussi modifié aussi la porté des classes principal que je mettait systematiquement en static.

**Bonne pratique** : 1.5/2 
J'ai amélioré l'optimisation notamment l'utilisation d'un tableau d'immatriculation dans l'Exo 3 au lieu de stocker chaque objet comme je faisait à chaque fois.
J'ai modifier dans l'Exo 1 les While en Do While pour les saisie essentiellement.
En parlant de saisie j'ai aussi fait attention à bien donner un choix simple numéraire 1 -> Valeur de mon choix

**Mauvais pratique** : 0/-2


# TOTAL : 17/20
Je suis audacieux pour ce dernier TP ;P