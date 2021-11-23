package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phase1 implements Phase{
    private Joueurs joueurs;
    private Themes themes;
    private Theme themeactuel;
    public Phase1(Joueurs joueurs,Themes themes){
        this.joueurs = joueurs;
        this.themes = themes;
    }
    @Override
    public void selectionerJoueurs() {
        joueurs.selectionJoueursParticipants();
    }

    public void selectionnerJoueurGagnantsRandom(int nbJoueurGagnantsMax){
        int nbJoueursGagnants = 0;
        List<Joueur> joueursNonGagnants = new ArrayList<Joueur>();
        for(Joueur joueur : joueurs.getJoueursSelectionnes()){
            if(joueur.getEtat().equals(EtatJoueur.GAGNANT)){
                nbJoueursGagnants += 1;
            }
            if (joueur.getEtat().equals(EtatJoueur.SELECTIONNE))
            {
                joueursNonGagnants.add(joueur);
            }
        }
        while (nbJoueursGagnants < nbJoueurGagnantsMax){
            int random = (int)(Math.random() * (joueursNonGagnants.size()));
            joueursNonGagnants.get(random).setEtat(EtatJoueur.GAGNANT);
            nbJoueursGagnants +=1;
        }
    }
    @Override
    public void déroulerPhase() {
        selectionerJoueurs();
        joueurs.afficherJoueursSelectionees();
        System.out.println("Le Thème selectionné est : "+themes.getCurrentTheme().getNom());
        themes.setThemesSelectionnees(this);
        boolean touslesjoueursontjoues;
        int nbJoueurActuel = 0;
        while(!joueurs.verifGagnants(3))
        {
            Question question = themes.getThemeByName(themes.getCurrentTheme().getNom()).selectionQuestion(this);
            themes.setDernierTheme(themes.getCurrentTheme().getId());
            touslesjoueursontjoues = false;
            if(question == null)
            {
                selectionnerJoueurGagnantsRandom(3);
                touslesjoueursontjoues = true;
            }

            while(!touslesjoueursontjoues)
            {
                Joueur joueurActuel = joueurs.getJoueursSelectionnes().get(nbJoueurActuel);
                System.out.println("C'est au joueur "+joueurActuel.getNom() +" de répondre à la question suivante : ");
                if(question instanceof QCM) {
                    System.out.println("Vous avez le choix entre ces 4 options :");
                    int i = 1;
                    for (String reponse : question.getReponse()){
                        System.out.println("Réponse N° "+i+" : "+reponse);
                        i++;
                    }
                }
                if(question instanceof RC){
                    System.out.println("Veuillez rentrer votre réponse sous forme de réponse courte");
                }
                if (question instanceof VF){
                    System.out.println("La réponse est elle vraie ou fausse ? V/F");
                }
                Scanner scanner = new Scanner(System.in);
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
                if(nbJoueurActuel > 3)
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
