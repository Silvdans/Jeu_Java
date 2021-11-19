package com.company;

public class Jeu implements Phase{
    private Joueurs joueurs;
    private Themes themes;

    public Jeu(Joueurs joueurs,Themes themes){
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
        System.out.println("Le Thème selectionné est : "+themes.selectionTheme());
        System.out.println("La première question est :");
    }
}
