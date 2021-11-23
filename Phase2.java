package com.company;

import java.util.Scanner;

public class Phase2 implements Phase{
    private Joueurs joueurs;
    private Themes themes;
    private Theme themeactuel;
    public Phase2(Joueurs joueurs,Themes themes){
        this.joueurs = joueurs;
        this.themes = themes;
    }
    public void selectionerJoueurs(){
        joueurs.getJoueursSelectionnes().removeIf(joueur -> joueur.getEtat().equals(EtatJoueur.ELIMINE));
    }

    public void déroulerPhase(){
        themes.setThemesSelectionnees(this);
        System.out.println("Les thèmes selectionnes sont :");
        themes.afficherThemesSelectionnes();
        Scanner scanner = new Scanner(System.in);
        for (Joueur joueur : joueurs.getJoueursSelectionnes())
        {
            System.out.println(joueur.getNom()+ ": Veuillez choisir un thème");
            String theme = scanner.nextLine();
            joueur.setThemeChoisi(themes.getThemeByName(theme));
        }

        while(!joueurs.verifGagnants(2)) {


        }
    }

}
