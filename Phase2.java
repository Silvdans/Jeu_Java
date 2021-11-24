package com.company;

import java.util.ArrayList;
import java.util.List;
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
        joueurs.resetEtats();
    }
    @Override
    public void déroulerPhase(){
        themes.setThemesSelectionnees(this);
        System.out.println("Les thèmes selectionnes sont :");
        themes.afficherThemesSelectionnes();
        Scanner scanner = new Scanner(System.in);
        for (Joueur joueur : joueurs.getJoueursSelectionnes())
        {
            System.out.println(joueur.getNom()+ ": Veuillez choisir un premier thème");
            System.out.println("Les thèmes disponibles sont :");
            themes.afficherThemesSelectionnes();
            String theme = scanner.nextLine();
            joueur.addThemesChoisis(themes.getThemeByName(theme));
            themes.addThemesConsommés(themes.getThemeByName(theme));
            themes.getThemesSelectionnees().remove(themes.getThemeByName(theme));
        }
        int nbJoueurActuel = 0;
        boolean touslesjoueursontpasjoues = true;
        while(!(joueurs.verifGagnants(2))) {
            touslesjoueursontpasjoues = true;
            while(touslesjoueursontpasjoues){

                Joueur joueurActuel = joueurs.getJoueursSelectionnes().get(nbJoueurActuel);
                Question question = joueurActuel.getThemesChoisis().get(0).selectionQuestion(this);
                if(question == null)
                {
                    joueurs.selectionnerJoueurGagnantsRandom(2);
                    touslesjoueursontpasjoues = false;
                }
                else{
                    System.out.println("C'est au joueur "+joueurActuel.getNom() +" de répondre à la question suivante : ");
                    System.out.println(question.getQuestion());
                    question.demanderReponse();
                    question.verifierReponse(joueurActuel);
                    nbJoueurActuel+=1;
                    if(nbJoueurActuel > 2)
                    {
                        nbJoueurActuel = 0;
                        touslesjoueursontpasjoues = false;
                    }
                    for(int i =0;i < 5;i++)
                    {
                        System.out.println("----------------------------------------------");
                    }
                }
            }
        }
        this.joueurs.afficherJoueursGagnants();
    }
}

