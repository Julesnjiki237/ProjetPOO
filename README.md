Ce projet a été realisé par un groupe de 7 étudiants de crypto

#Noms, prenoms et matricules des membres:

KEMTSOP TETSAGHO JOEL              24ENSPM512  
LEMDJOU MANIGUE VIANI MARIE-MAR    24ENSPM328  
NGOUNOU SIMO KAMILA SINTHIA        24ENSPM339  
NJIKI NGUEWO JULES KEVIN           24ENSPM452  
OUMAROU OUSSEINI                   22ENSPM484  
TAMBEKOU KAPNANG CYRIL             24ENSPM341  
TANYI NANDO DIVIN ANDERSON         24ENSPM329  

Ce projet consiste à implémenter des rectangles en Java, avec deux versions :

Rectangle standard (côtés parallèles aux axes)

Rectangle incliné (SlantedRectangle, pouvant être tourné d'un angle donné).

**Fonctionnalités Principales** :
✅ __Gestion des rectangles__ :

Création via différents constructeurs (points, dimensions, etc.).

Calcul de la surface (surface()).

Vérification si un point ou un autre rectangle est contenu (contains()).

Translation (translate()) et rotation (rotate() pour SlantedRectangle).

✅ __Dessins (ensembles de rectangles)__ :

Ajout/suppression de rectangles dans un Dessin.

Calcul de la surface totale.

Rectangle englobant (hull()) couvrant tous les rectangles du dessin.

✅ __Bonnes pratiques POO__ :

Héritage (SlantedRectangle étend Rectangle).

Redéfinition de méthodes (equals(), toString(), contains()).

Gestion des conflits de méthodes (surcharge et polymorphisme).

**Structure du Projet**

📂 __Classes principales__ :

Point : Représente un point 2D (x, y).

Rectangle :

Version de base (côtés parallèles aux axes).

Méthodes : surface(), translate(), contains(), hull().

SlantedRectangle (hérite de Rectangle) :

Ajoute une rotation (angle).

Redéfinit contains() et getCorners() pour gérer l'inclinaison.

Dessin :

Stocke un tableau de rectangles.

Permet de calculer leurs propriétés globales.
