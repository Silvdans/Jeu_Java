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
    public void selectionnerJoueurGagnantsRandom(int nbJoueurGagnantsMax) {
        int nbJoueursGagnants = 0;
        List<Joueur> joueursNonGagnants = new ArrayList<Joueur>();
        for (Joueur joueur : joueurs.getJoueursSelectionnes()) {
            if (joueur.getEtat().equals(EtatJoueur.GAGNANT)) {
                nbJoueursGagnants += 1;
            }
            if (joueur.getEtat().equals(EtatJoueur.SELECTIONNE)) {
                joueursNonGagnants.add(joueur);
            }
        }
        while (nbJoueursGagnants < nbJoueurGagnantsMax) {
            int random = (int) (Math.random() * (joueursNonGagnants.size()));
            joueursNonGagnants.get(random).setEtat(EtatJoueur.GAGNANT);
            nbJoueursGagnants += 1;
        }
        joueursNonGagnants.clear();
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
        boolean touslesjoueursontjoues;
        while(!(joueurs.verifGagnants(2))) {
            touslesjoueursontjoues = false;
            while(!touslesjoueursontjoues){

                Joueur joueurActuel = joueurs.getJoueursSelectionnes().get(nbJoueurActuel);
                Question question = joueurActuel.getThemesChoisis().get(0).selectionQuestion(this);
                if(question == null)
                {
                    selectionnerJoueurGagnantsRandom(2);
                    touslesjoueursontjoues = true;
                }
                else{
                    System.out.println("C'est au joueur "+joueurActuel.getNom() +" de répondre à la question suivante : ");
                    System.out.println(question.getQuestion());
                    question.demanderReponse();

                    String reponse = scanner.nextLine();
                    if(reponse.equals(question.getBonneReponse())){
                        joueurActuel.incrementeScore(2);

                        System.out.println("Félicitation c'est la bonne réponse, votre score a augmenté de 1 point");
                        System.out.println("Votre Score est maintenant de : "+joueurActuel.getScore()+" points");
                    }
                    else{
                        System.out.println("Dommage ce n'est pas la bonne réponse ! ");
                        System.out.println("La bonne réponse était : "+question.getBonneReponse());
                        System.out.println("Votre Score est toujours de : "+joueurActuel.getScore()+" points");
                    }
                    nbJoueurActuel+=1;
                    if(nbJoueurActuel > 2)
                    {
                        nbJoueurActuel = 0;
                        touslesjoueursontjoues = true;
                    }
                    for(int i =0;i < 20;i++)
                    {
                        System.out.println("----------------------------------------------");
                    }
                }

            }
            this.joueurs.afficherJoueursGagnants();
        }
    }
}

