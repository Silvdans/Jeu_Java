package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public abstract class Question {

    private static int id_to_associate=1;
    private  int id;
    private String difficultée;
    private String question;
    private EtatQuestion etat;
    protected List<String> reponse;
    protected String bonneReponse;


    public Question(String difficultée, String question,String bonneReponse){
        this.id = Question.id_to_associate;
        Question.id_to_associate += 1;
        this.difficultée = difficultée;
        this.question = question;
        this.reponse = reponse;
        this.bonneReponse = bonneReponse;
        this.etat = EtatQuestion.EN_ATTENTE;
    }
    public Question(){

    }
    public void verifierReponse(Joueur joueurActuel){
        Scanner scanner = new Scanner(System.in);
        String reponse = scanner.nextLine();
        if(reponse.equals(this.getBonneReponse())){
            joueurActuel.incrementeScore(2);

            System.out.println("Félicitation c'est la bonne réponse, votre score a augmenté de 2 point");
            System.out.println("Votre Score est maintenant de : "+joueurActuel.getScore()+" points");
        }
        else{
            System.out.println("Dommage ce n'est pas la bonne réponse ! ");
            System.out.println("La bonne réponse était : "+this.getBonneReponse());
            System.out.println("Votre Score est toujours de : "+joueurActuel.getScore()+" points");
        }
    }
    public abstract void ajouterReponse();

    public void afficherThemes(){
        System.out.println("themes");
    }

    public String getDifficultée() {
        return difficultée;
    }

    public void setDifficultée(String difficultée) {
        this.difficultée = difficultée;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getReponse() {
        return reponse;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public void setBonneReponse(String bonneReponse) {
        this.bonneReponse = bonneReponse;
    }

    public abstract void demanderReponse();

    public EtatQuestion getEtat() {
        return etat;
    }

    public void setEtat(EtatQuestion etat) {
        this.etat = etat;
    }
}
