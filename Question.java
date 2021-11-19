package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public abstract class Question {
    private String difficultée;
    private String question;
    protected List<String> reponse;
    protected String bonneReponse;

    public Question(String difficultée, String question,List<String> reponse,String bonneReponse){
        this.difficultée = difficultée;
        this.question = question;
        this.reponse = reponse;
        this.bonneReponse = bonneReponse;
    }
    public Question(){

    }

    public abstract void ajouterReponse();

    public void suppressionQuestion(){

    }
    public int selectionQuestion(){
        return 0;
    }
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


    public abstract void setReponse(List<String> reponse);
}
