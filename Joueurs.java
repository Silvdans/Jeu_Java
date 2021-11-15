package com.company;

import java.util.ArrayList;
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
    }
    public void selectionJoueurRandom(){

    }
    public void selectionJoueursParticipants(){
        Random randomiser = new Random();
        List<Integer> doublons = new ArrayList<Integer>();
        int i = 0;
        while(i < 4) {
            int indexJoueur = randomiser.nextInt(joueurs.size());

            if(joueurs.get(indexJoueur).getEtat().equals(Etat.EN_ATTENTE)){
                joueurs.get(indexJoueur).setEtat(Etat.SELECTIONNE);
                joueursSelectionnes.add(joueurs.get(indexJoueur));
                i += 1;
            }
        }
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
        for(Joueur joueur : joueursSelectionnes){
            System.out.println(joueur.getId());
            System.out.println(joueur.getNom());
            System.out.println(joueur.getScore());
            System.out.println(joueur.getEtat());
        }
    }
}
