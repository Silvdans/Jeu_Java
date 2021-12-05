package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phase1 implements Phase{
    private Joueurs joueurs;
    private Themes themes;
    public Phase1(Joueurs joueurs,Themes themes){
        this.joueurs = joueurs;
        this.themes = themes;
    }
    @Override
    public void selectionerJoueurs() {
        joueurs.selectionJoueursParticipants();
    }

    @Override
    public void déroulerPhase() {
        selectionerJoueurs();
        joueurs.afficherJoueursSelectionees();
        System.out.println("Le Thème selectionné est : "+themes.getCurrentTheme().getNom());
        themes.setThemesSelectionnees(this);
        boolean touslesjoueursontjoues;
        int nbJoueurActuel = 0;
        themes.getThemeByName(themes.getCurrentTheme().getNom()).chooseQuestions(this);
        while(!joueurs.verifGagnants(3))
        {
            Question question = themes.getThemeByName(themes.getCurrentTheme().getNom()).selectionQuestion();
            themes.setDernierTheme(themes.getCurrentTheme().getId());
            touslesjoueursontjoues = false;
            if(question == null)
            {
                joueurs.selectionnerJoueurGagnantsRandom(3);
                touslesjoueursontjoues = true;
            }

            while(!touslesjoueursontjoues)
            {
                Joueur joueurActuel = joueurs.getJoueursSelectionnes().get(nbJoueurActuel);
                System.out.println("C'est au joueur "+joueurActuel.getNom() +" de répondre à la question suivante : ");
                System.out.println(question.getQuestion());
                question.demanderReponse();
                question.verifierReponse(joueurActuel);
                nbJoueurActuel+=1;
                if(nbJoueurActuel > 3)
                {
                    nbJoueurActuel = 0;
                    touslesjoueursontjoues = true;
                }
                for(int i =0;i < 5;i++)
                {
                    System.out.println("----------------------------------------------");
                }
            }
        }
        this.joueurs.afficherJoueursGagnants();
    }
}
