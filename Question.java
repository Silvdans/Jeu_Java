package com.company;

public abstract class Question {
    private String difficultée;
    private String question;
    public Question(String difficultée, String question){
        this.difficultée = difficultée;
        this.question = question;
    }
    public void ajoutQuestion(){

    }

    public void suppressionQuestion(){

    }
    public int selectionQuestion(){
        return 0;
    }
    public void afficherThemes(){
        System.out.println("themes");
    }
}
