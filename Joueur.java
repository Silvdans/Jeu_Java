package com.company;

public class Joueur {

    private static int id_to_associate=100;
    private int id;
    private String nom;
    private int score = 0;
    private Etat etat;

    public Joueur(String nom){
        this.nom = nom;
        this.id = Joueur.id_to_associate;
        Joueur.id_to_associate+=10;
        this.etat = Etat.EN_ATTENTE;

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

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
