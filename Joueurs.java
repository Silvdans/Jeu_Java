package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Joueurs {

    private List<Joueur> joueurs = new ArrayList<Joueur>();
    private List<Joueur> joueursSelectionnes = new ArrayList<Joueur>();
    public Joueurs(){
        joueurs.add(new Joueur("Mathis"));
        joueurs.add(new Joueur("Loic"));
        joueurs.add(new Joueur("Michel"));
        joueurs.add(new Joueur("Jean"));
        joueurs.add(new Joueur("Rachel"));
        joueurs.add(new Joueur("Yoan"));
        joueurs.add(new Joueur("Roger"));
        joueurs.add(new Joueur("Pero"));
        joueurs.add(new Joueur("Richard"));
        joueurs.add(new Joueur("Momo"));
        joueurs.add(new Joueur("Miguel"));
        joueurs.add(new Joueur("Marie"));
        joueurs.add(new Joueur("Coline"));
        joueurs.add(new Joueur("Natsu"));
        joueurs.add(new Joueur("Orianna"));
        joueurs.add(new Joueur("Annie"));
        joueurs.add(new Joueur("Cassiopeia"));
        joueurs.add(new Joueur("Zerator"));
        joueurs.add(new Joueur("Sangoku"));
        joueurs.add(new Joueur("Natacha"));

    }
    public void selectionJoueurRandom(){

    }
    public void selectionnerJoueurGagnantsRandom(int nbJoueurGagnantsMax){
        int nbJoueursGagnants = 0;
        List<Joueur> joueursNonGagnants = new ArrayList<Joueur>();
        System.out.println("Il n'y a plus de questions dans un des thèmes, les joueurs gagnants sont séléctionnés aléatoirement");
        for(Joueur joueur : this.getJoueursSelectionnes()){
            if(joueur.getEtat().equals(EtatJoueur.GAGNANT)){
                nbJoueursGagnants += 1;
            }
            if (joueur.getEtat().equals(EtatJoueur.SELECTIONNE))
            {
                joueursNonGagnants.add(joueur);
            }
        }

        while (nbJoueursGagnants < nbJoueurGagnantsMax){

            int maxScore = 0;
            for (Joueur joueur : joueursNonGagnants)
            {
                if(joueur.getScore()>maxScore){
                    maxScore = joueur.getScore();
                }
            }
            List<Joueur> listejoueursMemeScore = new ArrayList<Joueur>();
            for (Joueur joueur :joueursNonGagnants){
                if(maxScore == joueur.getScore()){
                    listejoueursMemeScore.add(joueur);
                }
            }
            if(listejoueursMemeScore.size() > 1){
                int random = (int)(Math.random() * (listejoueursMemeScore.size()));
                listejoueursMemeScore.get(random).setEtat(EtatJoueur.GAGNANT);
                nbJoueursGagnants +=1;
            }
            else{
                listejoueursMemeScore.get(0).setEtat(EtatJoueur.GAGNANT);
                nbJoueursGagnants +=1;
            }
        }
    }
    public void resetEtats(){
        for (Joueur joueur : joueursSelectionnes){
            joueur.setEtat(EtatJoueur.SELECTIONNE);
        }
    }

    public void afficherJoueursGagnants(){
        for(Joueur joueur : joueursSelectionnes){
            if(joueur.getEtat().equals(EtatJoueur.GAGNANT)){
                System.out.println(joueur.getNom()+" est qualifié !");
            }
        }
    }
    public void selectionJoueursParticipants(){
        Random randomiser = new Random();
        int i = 0;
        while(i < 4) {
            int indexJoueur = randomiser.nextInt(joueurs.size());

            if(joueurs.get(indexJoueur).getEtat().equals(EtatJoueur.EN_ATTENTE)){
                joueurs.get(indexJoueur).setEtat(EtatJoueur.SELECTIONNE);
                joueursSelectionnes.add(joueurs.get(indexJoueur));
                i += 1;
            }
        }
    }
    public boolean verifGagnants(int nombreGagnantsAutorises){
        int nbGagnants = 0;
        for (Joueur joueur : this.getJoueursSelectionnes()){
            if (joueur.getEtat().equals(EtatJoueur.GAGNANT)){
                nbGagnants += 1;
            }
        }
        if(nbGagnants >= nombreGagnantsAutorises)
        {
            for (Joueur joueur : this.getJoueursSelectionnes())
            {
                if(!(joueur.getEtat().equals(EtatJoueur.GAGNANT))){
                    joueur.setEtat(EtatJoueur.ELIMINE);
                }
            }
            return true;
        }
        return false;
    }
    public void afficherJoueurs(){
        for(Joueur joueur : joueurs){
            System.out.println(joueur.getId());
            System.out.println(joueur.getNom());
            System.out.println(joueur.getScore());
            System.out.println(joueur.getEtat());
        }
    }
    public void afficherJoueursSelectionees(){
        for(Joueur joueur : joueursSelectionnes)
        {
            System.out.println("Nom du joueur : "+joueur.getNom());
        }
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public List<Joueur> getJoueursSelectionnes() {
        return joueursSelectionnes;
    }

    public void setJoueursSelectionnes(List<Joueur> joueursSelectionnes) {
        this.joueursSelectionnes = joueursSelectionnes;
    }
}
