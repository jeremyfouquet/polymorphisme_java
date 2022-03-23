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

![diagramme de classe](assets/diagramme_de_classe.drawio.svg)

2 Implémenter les différents objets de votre diagramme

3 Dans votre main, réaliser un jeu de test permettant de valider vos différentes fonctionnalités. Pour rappel, un jeu de test ne doit pas permettre à l'utilisateur de tester votre programme mais plutôt montrer les différents cas que vous avez vous même testé. Pour réaliser cela, vous êtes libre d'utiliser une technologie comme JUNIT ou de les faire à la main dans votre main. Chaque test doit avoir un commentaire précisant le cas à tester (cas normal ou particulier), exécuter les méthodes nécessaires et afficher les résultats obtenus en console.
