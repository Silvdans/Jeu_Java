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

        for (int i=0; i < 20;i++)
        {

            System.out.println(themes.getThemes().get(themes.selectionTheme()).getNom());
        }

    }
}
