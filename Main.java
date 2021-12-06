package com.company;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.security.PrivateKey;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Initialisation des Class et variable
	    Joueurs joueurs = new Joueurs();
        Themes themes = new Themes();
        ParseCSV parseCSV = new ParseCSV(themes);
        String choix;
        Scanner scanner = new Scanner(System.in);

        boolean run = true;
        while(run) {
            System.out.println("Voulez-vous jouer ou configurer de nouvelles questions ('Jouer'/'Config')");
            choix = scanner.nextLine();
            switch (choix) {
                case "Jouer" -> {
                    parseCSV.parse();
                    Phase phase = new Phase1(joueurs, themes);
                    phase.déroulerPhase();
                    Phase phase2 = new Phase2(joueurs, themes);
                    phase2.selectionerJoueurs();
                    phase2.déroulerPhase();
                    Phase phase3 = new Phase3(joueurs, themes);
                    phase3.selectionerJoueurs();
                    phase3.déroulerPhase();
                    run = false;
                }

                //        for (int i=0; i < 20;i++)
                //        {
                //            System.out.println(themes.getThemes().get(themes.selectionTheme()).getNom());
                //        }

                case "Config" -> {
                    boolean ajoutQuestion = true;
                    while (ajoutQuestion) {
                        System.out.println("Voulez vous ajouter une question ? O/N");
                        String reponse = scanner.nextLine();
                        if (reponse.equals("O")) {
                            System.out.println("Dans quel thème voulez vous rajouter votre question");
                            String reptheme = scanner.nextLine();
                            themes.getThemeByName(reptheme).ajoutQuestion();
                        } else if (reponse.equals("N")) {
                            ajoutQuestion = false;
                        }
                    }
                }
                default -> throw new IllegalStateException("La valeur entrée n'est pas correcte :" + choix);
            }
        }

        }
}
