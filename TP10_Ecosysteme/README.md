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

![diagramme de classe](assets/diagramme_de_classe.drawio.svg)

2 Coder les objets Vegetaux, Fleurs et Legumes en choisissant pour chacun d'eux le type de classe approprié. À noter qu'une fleur ne pourra se reproduire que si celle-ci est éclose.

3 Coder les interfaces ovipares et vivipares

4 Coder l'objet Animal héritant des interfaces ovipare et vivipare. Chaque animal possédera une espèce, un sexe, une taille, un poids, une espérance de vie et pourra se nourrir en fonction de son régime alimentaire se reproduire ou mourir pour ensuite être mangé par un charognard. Lors de la reproduction des vivipares, l'enfant récupère aléatoirement les caractéristiques (espérance de vie, poids, taille, sexe) selon celle de son père ou de sa mère. 

5 Coder les différents régimes alimentaires.

6 Ajouter l'objet œuf, cet objet aura des caractéristiques par défaut tant qu'il n'a pas été fertilisé par un mal de son espèce et disparaîtra de son environnement pour laisser place à un animal une fois éclos. À noter que celui-ci peut être consommé par les animaux omnivores.

7 Implémenter votre environnement, celui-ci possédera une liste d'espèces (végétal + animal) et pourra ajouter, retirer ou afficher les espèces de cette liste.

8 Développer un jeu de test dans votre main ou à l'aide de Junit permettant de tester votre programme
