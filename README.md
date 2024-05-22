# La carte aux trésors

La carte aux  trésors est une application Java qui simule une chasse au trésor sur une carte. Des aventuriers se déplacent sur la carte en collectant des trésors tout en évitant les obstacles comme les montagnes.

## Fonctionnalités

* Chargement de la carte et des aventuriers à partir d'un fichier d'entrée.
* Simulation des mouvements des aventuriers.
* Collecte de trésors par les aventuriers.
* Évitement des obstacles tels que les montagnes.
* Enregistrement de l'état final de la carte dans un fichier de sortie.

## Structure du Projet
* TreasureTrackerApp.java : classe principale de programmme
* Model : contient tout les classes de base du projet (La carte, les aventuriers, les trésors et les montages)
* Simulation : contient tout le code fonctionelle qui permet de simuler le movement d'un aventurier
* Utils :  Lecture/Ecriture de fichier

## Environnement technique

* Java 22
* Maven 3
* Junit 5
* Intellij Idea

## Installation

Clonez le dépôt :
* `git clone https://github.com/Amalou99/treasure-tracker.git`
* `cd treasure-tracker-carbonIT`

Compilez le projet avec Maven :
* `mvn clean install`

## Utilisation
Lancer la Simulation
Vous pouvez exécuter le projet en spécifiant les chemins des fichiers d'entrée et de sortie en utilisant les arguments de la ligne de commande :

`java -jar treasure-tracker-jar-with-dependencies.jar -fileInput "chemin/vers/input.txt" -fileOutput "chemin/vers/output.txt"`
Si les chemins des fichiers ne sont pas spécifiés, les fichiers par défaut situés dans le dossier resources seront utilisés et le résultat dans le dossier target.

## Format du Fichier d'Entrée
Le fichier d'entrée doit suivre ce format :

```
C - 3 - 4

M - 1 - 0

T - 1 - 1 - 2

A - Lara - 0 - 0 - S - AADADAGGA
```