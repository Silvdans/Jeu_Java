package com.company;

public class Joueur {

    private static int id_to_associate=100;
    private int id;
    private String nom;
    private int score = 0;
    private EtatJoueur etat;
    private Theme themeChoisi;

    public Joueur(String nom){
        this.nom = nom;
        this.id = Joueur.id_to_associate;
        Joueur.id_to_associate+=10;
        this.etat = EtatJoueur.EN_ATTENTE;

    }
    public void Saisie(){

    }
    public String toString(){
        return "joueur";
    }

    public void updateScore(){

    }

    public void changementEtat(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public EtatJoueur getEtat() {
        return etat;
    }

    public void setEtat(EtatJoueur etat) {
        this.etat = etat;
    }

    public void incrementeScore(int points){
        this.score+=points;
    }
    public Theme getThemeChoisi() {
        return themeChoisi;
    }

    public void setThemeChoisi(Theme themeChoisi) {
        this.themeChoisi = themeChoisi;
    }
}
