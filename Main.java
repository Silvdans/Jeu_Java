package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Joueurs joueurs = new Joueurs();
        Themes themes = new Themes();
        //joueurs.afficherJoueurs();
        joueurs.selectionJoueursParticipants();
        joueurs.afficherJoueursSelectionees();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Le Theme");

    }
}
