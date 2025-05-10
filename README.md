# Projet POO - Gestion de rectangles en Java

Ce projet a été réalisé par un groupe de 7 étudiants de CRYPTO.

## Membres de l'équipe

| Nom et prénom                     | Matricule    |
|------------------------------------|--------------|
| KEMTSOP TETSAGHO JOEL              | 24ENSPM515   |
| LEMDJOU MANIGUE VIANI MARIE-MAR    | 24ENSPM328   |
| NGOUNOU SIMO KAMILA SINTHIA        | 24ENSPM339   |
| NJIKI NGUEWO JULES KEVIN           | 24ENSPM452   |
| OUMAROU OUSSEINI                   | 22ENSPM0484   |
| TAMBEKOU KAPNANG CYRIL             | 24ENSPM341   |
| TANYI NANDO DIVIN ANDERSON         | 24ENSPM329   |

## Description du projet

Ce projet consiste à implémenter des rectangles en Java, avec deux versions :
- **Rectangle standard** (côtés parallèles aux axes)
- **Rectangle incliné** (`SlantedRectangle`, pouvant être tourné d'un angle donné)

## Fonctionnalités principales

### 🟢 Gestion des rectangles
- Création via différents constructeurs (points, dimensions, etc.)
- Calcul de la surface (`surface()`)
- Vérification si un point ou un autre rectangle est contenu (`contains()`)
- Translation (`translate()`) et rotation (`rotate()` pour `SlantedRectangle`)

### 🟢 Dessins (ensembles de rectangles)
- Ajout/suppression de rectangles dans un `Dessin`
- Calcul de la surface totale
- Rectangle englobant (`hull()`) couvrant tous les rectangles du dessin

### 🟢 Bonnes pratiques POO
- Héritage (`SlantedRectangle` étend `Rectangle`)
- Redéfinition de méthodes (`equals()`, `toString()`, `contains()`)
- Gestion des conflits de méthodes (surcharge et polymorphisme)

## Structure du projet

### 📂 Classes principales

1. **`Point`**  
   Représente un point 2D (x, y)

2. **`Rectangle`**
   - Version de base (côtés parallèles aux axes)
   - Méthodes : `surface()`, `translate()`, `contains()`, `hull()`

3. **`SlantedRectangle`** (hérite de `Rectangle`)
   - Ajoute une rotation (`angle`)
   - Redéfinit `contains()` et `getCorners()` pour gérer l'inclinaison

4. **`Dessin`**
   - Stocke un tableau de rectangles
   - Permet de calculer leurs propriétés globales
