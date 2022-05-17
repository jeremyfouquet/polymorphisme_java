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

# Correction Exercice 1 :

Voyons le diagramme de classe.
Du coup tu as un objet point qui contient 2 double utilisé pour créer des segments. Ok jusque la tout va bien je remarque que tu as utilisé la surcharge pour les constructeur. En suite ta une figure qui utilise ces segment, cette figure peut etre un rectangle ou un triangle.
Ca semble pas mal. Puis tu as creer une autre classe utilisateur j'imagine que ces pour gere toutes les interraction avec l'utilisateur et je note la presence d'une exception personnalisé. A voir a quoi elle sert.Alors passons au code.

Ici je comprends pas trop l'interet du fichier package-info.
Sinon concernant l'exception c'est bien codé a voir ou et pourquoi c'est utilise.

--Point--
Concernant le point c'est une structure assez basique, mais c'est clean ya le necessaire, les commentaire sur les methode + attributs sont la. Le format doc est utilisé et ya même presence des source.

--Segment--
Alors segment utilise une liste de 2 point ok, ici pour plus de securité tu pouvais privilegier un tableau plutot qu'une liste vu que la taille est connu a l'avance et que le tableau a une taille fixe comme ca en soit sa protege de tout ajout potentiel.
Du coup tu as surcharger les constructeur de segment pour en avoir un par defaut et un en fonction d'une liste de point saisie par le user. Si je comprend bien l'un ces la methode par defaut et l'autre c'est pour le bonus. Pour le reste c'est pas mal et ya toujours le source a ne pas oublié bon reflexe. D'ailleurs c'est dommage qu'il n'y ai pas d'annotation @source. Après je crois qu'on peut la créer mais bon perso je me suis pas encore renseigné.

--Figure--
Du coup ta figure a une liste de segment et un type, concernant le type je te conseilelrait plutot une enumeration rassemblant les type de figure dispo ;-)
Alors ici j'ai pas vraiment compris l'utilité de la surcharge de constructeur.
Tu as un constructeur qui creer un segment auto jusque la je suis ok. Par contre après tu en as un autre qui fait exactement la même chose sauf qui prend un paramètre qui ne sert a rien.
Je me demande concernant ce concept s'il n'y a pas un probleme dans le cours (quand je l'ai mis a jour j'ai du melangé des truc j'ai pas eu le temps de le relire). En tout cas petit info histoire qu'on soit au clair ya 2 concepts dans le cours lié au polymorphisme. En gros on t'a overloding => surcharge qui permet d'avoir plusieurs methode simailire mais utilisant pas les même info. Et l'overfitting => redefinition de methode en gros le but c'est d'avoir une famille d'objet (classe mere / plusieurs filles) et que chacune de ces classe est le même comportement (meme methode) mais que chacun fait a sa facon c'etait l'exemple dans le cours des animaux qui se deplace mais chacun a sa facon.
Par exemple la tu as un poisson lui il va nager, un chien il va marcher et un oiseau il va volé. Polymorphisme tu as plusieurs forme d'animaux et plusieurs forme de deplacement. En plus l'oiseau peut a la fois voler ou marcher => surcharge il a plusieurs moyen de se deplacer. J'espère que c'est plus clair car je crois que j'ai du m'embrouiller en redigeant le cours. Du coup ta pas besoin.
Donc ici la surcharge est pas necessaire.
Sinon faut que je vois le reste du code mais la classe abstraite est un bon choix par contre je vois pas trop pourquoi ajoutSegment est pas directement codé dans figure.
De meme pour choixFigure j'ai plutot l'impression que c'est lié a l'utilisateur alors pourquoi ne pas l'avoir mis dans cette classe ?
Par contre pour hauteur la surcharge est interessante.
Sinon pour le reste c'est pas mal.
Après ici niveau surcharge de constructeur tu peux l'utiliser si ta des constructeur differents qui par exemple te permette de creer des triangles differents car au final pour carre / rectangle c'est pareil ca depande juste des sitance mais pas forcement pour les triangles.
Par exemple un constructeur pour les triangle (isocele, equlaterale et quelconque que c'est simialire c'est en fonction du nombre de segment egaux) et un autre pour le rectangle qui est pas tout a fait pareil.
Et le polymorphisme tu l'as techniquement via tes clacul d'air et tout quand tu te place du point de vue de figure toute tes figure peuvent calculer leurs aire mais chacune a leurs facon car tu as plusieurs forme de figure (des rectangle, des carré et des triangle ;-)

--Triangle--
Ici la surcharge a un peux plus de sens car au final selon le paramètre ou non les traitement sont pas exactement pareil.
Sinon pour ajoute segment c'est pas optimal mais ok je vois pourquoi ces separé.

--Rectangle--
Pour ajoute rectangle il y avait bien moyen de mettre une methode gloable mais bon tu peux dire que c'est plus lisible comme ca mais n'hesite pas a en faire des mini fonction pour construire ou des boucle car quand on voit des instruction en bloque comme ca qui se ressemble a un caractère pret c'est sur ca marche mais c'est pas opti du tout.

--Utilisateur--
Alors pour le user ce que je te conseil c'est pour le scanner initialise le directement dans le main car la chaque utilisateur le redefini pourtant il utilise tous le même donc autant le definir des le debut et comme ca ils ont juste a l'utilisé les un après les autres.
Et pour le close je te conseil en fin de main.
Après concernant l'exception si celle-ci a pour but de termine le programme ta pas besoin d'en faire une exception tu peux faire systeme.exit() -> a verif je sais plus si c'est comme ca en Java peut etre je confond avec python. En gros si ton execution cause une erreur tu veux terminer le programme exception que tu catch pas si tu veux juste quitter systeme.exit ou terminer normalement le programme. Donc dans ce cas la je pense qu'il y a possibilité de faire plus jolie en terminant la boucle grace a une condition multiple. Après autre precision finally c'est en option après un try catch donc quand il est vide tu peux ne pas le mettre ca fait mieux.
Donc attention avec les exceptions bien codé mais mal utilisé dans ce contexte.

--DrawTriangle--
Je vois que ta ajouter une interface graphique pour afficher tes figure mais si c'est pas de toi c'est un bon bonus après a voir comment sa rend. Alors les visuel sont pas mal -> un premier pas vers le graphique (fin te reste a etudier comme le code marche) après le programme est bien guidé. Par contre je comprends pas ya un probleme je crois quand je fais genere une figure de 4 coté ca tourne dans le vent pareil pour 3 coté. Un petit probleme de boucle on dirais :P
Donc tout est clean mais les generateur marche pas.

# Correction Exercice 2 :

Alors du coup on a un ecosysteme regroupant des espece.
Parmi celles-ci on retrouve des vegetaux qui peuvent etre soit des fleur / soit des legumes
On a aussi des animaux qui sont des charogniard / herbivore / carnivore / omnivore et qui peuvent etre ovipare ou vivipare. Et pour finir on a des oeufs.

Alors a premiere vu le diagramme semble conforme a ce que j'ai demandé c'est pas mal a voir dans le code.
Du coup par exemple la ca fait un peux complexe avec tout ces classes donc par exemple tu peux faire abstraction des enumeration et les placer directement en tant qu'attribut dans les classes histoire de soulagé le diagramme. Comme si tu avait pas fait de classe a part.
Sinon ce sont une très bonne idée surtout celle lié au sexe.

Après autre detail a savoir en faite la consigne est fausse ^^'
Mais je l'ai pas changé etant donné que certain on deja fait le TP.
Niveau conception j'ai retiré des truc a codé car ca fait deja beaucoup mais en gros la structure de base est mal pensé pour la rendre plus juste il suffirait de creer des classe en dessous d'animal tel que chien / chat ... et comme ca se serait eux qui heriterais du mode de reproduction et regime alimentaire. Au final dans cette architecture on a un animal qui est a la fois un ovipare et vivipare le ou exclusif n'existe pas la il herite des 2 donc il est les 2 en même temps.
Bon voyons comment ta gere tout ca.

Alors deja toujours le package info j'imagine que c'est pour moi mais vu que je regarde tout le code je svois pas vraiment a quoi il sert. Sinon je note que tu as l'habitude de mettre tes exception dans un package a par pourquoi pas ca peut etre plus lisible et plus simple a trouvé.
Après concernant cette exeption le code est clean par contre le nom comme dans l'exo precedent j'ai un peu de mal a comprendre ce qu'elle fait. Peut etre ce qui serait interessant c'est decrire en commentaire dans la classe dans quel cas elle est utilisé.

--ENUM--
Concernant les enumerations c'est ok, tu gère que ce soit avec constructeur ou non et elles semble relativement bien utilisé.

--Vegetaux--
Du coup ici ta fais le choix de rassembler graine et pollen en un seul attribut pourquoi pas. Sinon la classe abstraite c'est un très bon choix. Alors sinon concernant les methodes petite remarque quand même. Deja le constructeur est un peu bizarre tu passe en paramètre la liste des espece pour ajouter ton vegetal. Pourquoi ne pas faire l'inverse le vegetal est creer dans l'environnement via son constructeur donc il une fois creer il peut etre ajouter a cette liste.
Ici je pense ta fais ca par soucis du constructeur du coup petit info qui est dans le cours mais peut etre tu es passé a coté ou je les pas assez mise en avant.
Dans ton cas si l'attribut est initialiser par defaut le constructeur ne sert pas a grande chose vu qu'il n'a rien a initialiser et bien sache que tu peux ne pas coder de constructeur pour une classe et tu pourra quand même creer ton objet ou appeler super() dans le cas de l'heritage. Par defaut en Java toute les classe on une classe mere appeler Object et donc on un constructeur par defaut ;-)
Après autre remarque enleveGraine et setGraine sa semble assez similaire au final enelveGraine c'est un peux un setter qui est defini dans les sous objets car chacun fait differement selon si c'est du pollen ou graine (ca c'est du au faite que ta rassembler les 2. Du coup je pense que le setter est genere mais on se demande s'il est vraiment utilise.

--Legume--
Même remarque pour le constructeur de legume.
Du coup pour sereproduire l'exception est bien gere par contre si on change le constructeur faudrait retourné le nouveau legume. Concernant enlevegrainec'est bien le setter du coup ya pas besoin de l'autre.

--Fleur--
Meme remarque pour constructeur de fleur. En gros il ne devrait y avoir que setTypeEspace.
Et pareil pour le setter sinon le reste c'est good.

--Espece--
Pour les attribut ca me semble ok.
Bon bas les constructeurs vide pas necessaire comme dis precedement ta celui de la classe objet par defaut. Bon bas pour est manger pareil si on suis ta logique normal qu'il soit ici c'est comme pour les ajout mais perso je pense ce serait plus simple que ce soit l'environnement qui a tout qui remove des elements. Pareil pour retiré espece. Au final si cela peut t'aider tu peux te demandé ajouterEspace qui ajoute quoi ou ? L'environnement ajouter une espace a sa liste des espace et avec la reponse tu sais si c'est bien placer ou non. Mais generalement quand ta une sous structure qui ajoute des truc dans la principale c'est bizarre vu que la principale a directement acces a ces info. Comme ici ton environnement a directement acces aux espaces c'est un de ces attributs donc il peut jouer avec. Sinon le reste c'est ok. Après espace c'est pas mal pour tout reunir moi perso j'ai etreVivant.

--Animaux--
Alors ok pour le premier constructeur mise a par encore l'ajout qui est a mon sens pas au bon endroit par contre j'ai pas du tout compris le 2e. De plus je note que c'est une classe abtraite mais ta pas de methode abstraite c'est un peux bizarre je m'attendais a voir une methode manger qui devrait etre implementer partout. Sinon pour le reste du code c'est ok.

--Herbivore--
Bon ici ya le meme procbleme pour les constructeurs et ya toujours le 2e dont je ne sais pas a quoi il sert. Pour se nourir c'est pas mal mise a part que comme je t'ai dis j'aurais plutot mis juste l'attribut alive a false et après dans l'environnement j'aurais supprimer l'espece de la liste.
D'ailleurs si ta du mal a imagine ce concept dit toi aussi que tu peux avoir des methodes comme en cascade je sais pas comment appeler ca mais tu peux avoir par exemple estManger qui appel sousObjet.estManger -> qui appel manger et son traitement. Ca fait une sorte de cascade pour placer les truc au bon endroit. Tu pourrait donc avoir manger qui met juste l'atttribut alive a false. Puis estManger dans environnement qui met a false et remove par exemple je sais pas si tu vois l'idée c'est encapsuler.
Sinon autre petit probleme ta oublier la methode abstraite manger du coup ca veux dire si tu ajouter des type d'animaux par exemple des regime alimentaire ca t'oblige pas a codé la methode mangé ce qui peut etre assez problematique c'est peut etre juste un oublie mais attention.

--Omnivore--
Meme remarque que herbivore sinon ta bien compris la surcharge de methode + polymorphsime on va dire même s'il manque la methode abstraite qui relie tout le monde pour le @verride.
Ce qui permet quand tu te place au niveau des animaux que chacun d'eux peut manger a sa facon. Donc on a des objet au comportement differents car ils ont pas la même forme polymorpshime.
Donc attention de pas oublié ces clause imposé qui font la magie du concept. Car en soit avoir un animal qui mange pas sa existe pas mais admettons ca peut bas après si tu demande a tout tes animaux de manger tu vas avoir un bug quand celui qui n'a pas la methode imposé essaye de la lancer donc sa fait office de protection. Sinon le code est ok. Meme remarque positive / negative pour carnivore et charognard.

--Vivipare / Ovipare--
Alors ici pas mal utilisation de methode par defaut c'est un point qu'il n'y avait pas dans le cours. Et du coup ta coder ce dont j'avais penser.
En gros la du a ma faute ta une sorte de polymorphisme bizarre. Vu que ta une surcharge de seReproduire (vu qu'elle on le même nom) au sein de animal genre selon les paramètre et sa classse il ferra differement. Je sais pas comment qualifier ca en faite. Mais dans animal ya comme une surcharge de la methode vu qu'il n'y a pas les même parametre et en plus ca provient d'interface mere donc tout les animaux font pas pareil. Une fusion des2 si ont veut. Apres niveau paramètre jaurais plutot conseiller vivipare il a le partenaire et ovipare il a en paramètre optionnel le truc dans le cours ou tu met 3 point derriere ...
D'ailleurs la c'est inversé pas grave mais pense ovipare c'est o comm oeuf et vivipare bas ya pas de o donc pas d'oeuf.
Sinon c'est pas mal la fertilisation aussi.
Après perso comme je le dit j'aurais plutot return oeuf dans les 2 cas pour que mon environnement l'ajoute a sa liste. De même pour vivipare j'aurais retourne l'animal. D'ailleurs tes pas obliger de mettre de default case dans un switch. S'il est vide tu peux viré.

--L'oeuf--
C'est pas mal aussi comme je l'ai dis mise a par que j'aurais retourne l'espece / animal (ici tu peux utiliser direct animal les plante ca fait pas d'oeuf) et j'aurais fait le remplacement dans une methode de l'environnement.


--EcoSystem--
Constructeur vide pas besoin bon bas la c'est clean. Mais du coup par rapport a mon idée je t'aurais conseiller de plutot ajouter des methode ici c'est plus logique.
Comme add espece / remove espece
Puis des truc comme se faire manger genre sa prend 2 index par exemple pour la liste sa les fait se manger puis sa update la liste.
Pareil pour se reproduire sa prend 2 animaux de la liste sa les fait se reproduire et ajoute le new animal a la liste. Ca marche aussi pour les vegetaux. Ca me parait plus logique car au final il peut pioche directement dans sa liste et faire les melange.

Niveau jeux de test j'ai envie de dire simple mais effiacec il est parfait perso je changerais juste un detail quand ta se nourrir vu qu'il y en a plusieurs mentionne la classe qui le possede genre charognard / carnivore sa evite de faire le travail mentale ok lui c'est le charognard / lui le carnivore.
Quon remarque avec les message mais sinon le jeu de tests est parfait. Clair precis et complet on a les affichage du scenario / cas, ce qu'on test et du resultat

# Correction Exercice 3 :

Alors du coup selon ton diagramme on a une agence qui possede une liste de vehicule, ces vehicules sont motoriser et utilise de l'essence soit de l'electicité et peuvent etre des velo / voiture / moto ou trotinette.

Alors selon le schema c'est un peu bizarre car dans les type il n'y a pas de type manuelle.
Après je vois que tu as mis l'attribut moteurs a 0 minimum.
Une autre solution aurait ete de rattacher moteur directement a voiture / moto et non a vehicule.
Ce qui aurait été plus pratique mais on soit c'est pas optimal mais ca semble fonctionné comme idee.

Alors pour les enum tu maitrise c'est ok par contre est ce que c'est pas un peux redondant ta une enum pour le type de moteur et une autre avec le type de carburant qui en soit continenent les 2 même element a savoir electrique / essence. Ne serait il pas mieux d'en avoir une seule ?
Après pour ton exception c'est aussi ok par contre tes nom sont tellement generaux que ca en devient un peux vague du coup ce que je te recommande a l'avenir c'est d'ajouté un commentaire d'ecrivant dans quel type de cas elle est utilse afin qu'on puisse cerné son utilisation sans avoir a lire le reste du code.

--Moteur--
C'est pas mal bonne utilisation des classe abstraite je pense que tu as compris l'interet.
Pour essence / electrique c'est assez orignial l'appel du setter pourquoi ne pas avoir passer l'attribut en protected pour directement le modifier via super.carburant = val ? Je pense que ca aurait etre plus pratique et lisible. Sinon petit conseil n'oublie pas d'utiliser super comme pour this quand tu appel une methode ou attribut de la classe mere histoire qu'on puisse facilement la localiser (même si en java c'est pas obliger c'est mieux de le faire). Mise a part ca les moteur c'est ok.

--Vehicule--
Je vois que ta utiliser une variable statique pour l'id (vu dans le cours) c'est bien pensé.
Bien pensé le double constructeurs. Bonne utilisation aussi des methode private après le convertir en année ca pouvait même etre statique car tu l'utilise pour les vehricule mais ca leurs est pas vraiment lié tu pourrait l'utiliser pour n'importe quoi. C'est une methode d'aide / utils si ta deja vu donc ce type de methode privilegie statique après moi je conseil de les mettre dans la classe du main toutes ensemble mais tu peux les laissé la ou elle sont utilisé.
Bon pour les vehicule c'est ok le code est assez simple l'heritage est maitrisé et le polymorphisme aussi visible via la methode de klaxonner.

--Agence--
Super idée la clef etrangere pour les vehicule loué comme ca tu copie colle pas tout l'objet après tu pouvais aussi gere ca via un attribut dans vehicule.
Bon et sinon le code est pas mal. Concernant les tests je vois que tu es passé sur junit. Ca me semble pas mal et assez complet. Du coup je vois une amlioration au file du Tpcette exo me semble meilleurs et plus perfectionner que le precedent.

# NOTE ET COMMENTAIRE FINAL TP10 :

Bon alors avis globale. Très bon travail tu maitrise les exceptions, l'heritage, l'objet et le polymorphisme attention quand même à la surcharge de bas en faire pour faire jolie et l'utiliser vraiment quand ya un interet. Niveau override c'est bon. Après il te reste a optimisé tes code maintenant tu peux t'y interessé vu la qualité du code et sa proprete, commentaire / lisibilité / test c'est pas mal. Ya même eu un debut de junit et interface. Sinon ce qui te reste a travailler c'est plutot niveau conception c'est le plus dur sa viendra avec le temps tes idée sont pas mal et tu arrive a les codé tel que tu les a pensé mais c'est parfois pas super logique ou optimisé. Qui est lié a qui, qui possède quoi ou encore ou placer tel ou tel fonctionnalité. Pour ca te faut de la pratique et te posé les bonne questions en esperant que les quelque indication que j'ai mis te permettrons de t"ameliorer.

Alors pour la note

1/1 Lisibilité du code

1/1 Commentaire -> ici plus de precision sur les exception ou un nom plus restraint serait pas mal

1.75/2 UML -> les regle sont respecté mais quelque amelioration peuvent etre faite niveau reflexion (ici je parle pas de simplifier les dessin)

2/2 Pertinence des tests → Bon bas la rien a dire tu es même passer sur junit pour finir

1,5/2 bonus → Alors je met 1,5 et pas 2 1 pour l'interface et 0,5 pour l'effort du bonus exo 1 car chez moi il marchait pas. ^^'

4/4 Avancement du TP → Il me semble que ta tout codé

5/6 concept → C'est pas mal tu maitrise la POO mais ya encore quelque petite erreur, les methode pas placer au bon endroit, les surcharge pour faire jolie et attention au portée ta le droit de mettre du protected sur des variables.

1,5/2 Bonne pratique → bon bas la c'est pas mal après les super sur les variable ce serait pas mal et ya certaine optimisation a revoir qui se sont amelioré au file des exo.

0/-2 Mauvais pratique → aucune

17,75
Bon bas tu es dans ton auto eval après a voir si ta eu les point dans les même categorie.
Pour les tests l'exo 2 c'etait super après ce qu'il faut mettre c'est des scenarios qui peuvent arrivé (jeux de tests) le cas bizarre ou le mec se trompe ou essaye d'arnaquer le systeme et le cas prevu pour après si tu fais des tests unitaires tu test tout donc tu es sur. Mais bon la c'est clean donc sa viendra avec le temps je pense si bien sur tu continue a en faire car faut pas croire mais souvent même en entreprise les tests et la doc sa fini par ne pas etre fait.
Les classe principale c'etait bien de les mettre en objet vu que c'est le cours comme ca ta tout regrouper en une mega structure de données. Sinon pour statique non statique ce que je peux te dire je sais pas si tu connais mais les fonction utilitaire stique ceux propre au objet non statique. En gros tu peux voir le statique (variable / methode ou même classe) comme un bien commun donc posseder par tous et le non statique comme un bien privé propre a son objet à sa classe.
Par exemple je sais pas si sa parle j'essaye de faire des dessin pour se concept mais sont pas assez clair je crois.
Par exemple tu peux penser une fontaine a eau dans un parc elle est a tout le monde donc statique tout le monde peut y boire une boiteille d'eau c'est non statique c'est propre a quelqu'un.
En gros dit toi statique c'est comme le nom c'est un monument un truc comme ca c'est pas vraiment a quelqu'un c'est un peux a tout le monde. Autre exemple tu es chez toi ta une piscine c'est ta tienne propre a qui a cette maison qui t'appartient donc c'est pas statique. Une piscine municiplae en soit c'est utilisable par tous mais faut payer l'entrée ou autre c'est a la ville. Par contre la mere tout le monde peux s'y baigner ta pas besoin d'autorisation donc c'est statique pense a ce genre de truc la piscine peux ferme se casser ou autre la mer elle est la et le restera d'ou le statique et sa depend de personne ta pas besoin d'autorisation demander a un objet (getter).

Ce qui nous donne niveau moyenne
(14,5 + 15,25 + 17,75) / 3 = 15,8

Tres bon boulot l'amelioration est la et ce voit rien que dans le der TP de l'exo 1 guider au 3 non guidé ils n'ont rien avoir continue comme ca tu maitrise les base du java exception, boucle, condition, ainsi que la POO en general modelisation Objet, heritage, polymorphisme même si certain aspect sont moins maitrise que d'autre ca viendra avec l'experience et en esperant que ces new remarque puisse t'aider a encore progresser et atteindre la perfection.