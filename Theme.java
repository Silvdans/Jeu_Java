package com.company;

import java.io.File;
import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Theme {

    private List<Question> questions = new ArrayList<Question>();
    private String nom;
    private static int id_to_associate=100;
    private int id;
    public Theme(String nom){
        this.nom = nom;
        this.id = Theme.id_to_associate;
        Theme.id_to_associate+=10;
    }
    public void suppressionQuestion(){

    }

    public Question selectionQuestion(Phase phase){
        String difficultee = null;
        if(phase instanceof Phase1)
        {
            difficultee = "facile";
        }
        if(phase instanceof Phase2)
        {
            difficultee = "moyen";
        }
        if(phase instanceof Phase3)
        {
            difficultee = "difficile";
        }
        List<Question> questionsCourantes = new ArrayList<Question>();
        for (Question question : this.questions){
            if (question.getDifficultée().equals(difficultee) && question.getEtat().equals(EtatQuestion.EN_ATTENTE)){
                questionsCourantes.add(question);
            }
        }
        if(questionsCourantes.size() == 0)
        {
            return null;
        }
        else{
            int random = (int)(Math.random() * (questionsCourantes.size()));
            Question question = questionsCourantes.get(random);
            question.setEtat(EtatQuestion.UTILISEE);
            return question;
        }



    }
    public void ajoutQuestion() {
        //Création fichier question

        String newLine = System.getProperty("line.separator");
        //FileWriter writer = new FileWriter(file);
        Question question;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel type de question voulez créer, QCM, RC, ou VF");
        //RC = Rep courte, VF = Vrai ou Faux
        String type = scanner.nextLine();
        switch (type){
            case "QCM":
                question = new QCM();
                break;
            case "RC":
                question = new RC();
                break;
            case "VF":
                question = new VF();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        //Entrée de la difficultee de la question

        System.out.println("Veuillez rentrer votre question :");
        String stringQuestion = scanner.nextLine();
        question.setQuestion(stringQuestion);

        question.ajouterReponse();

        System.out.println("Quelle est la difficultée de votre question : 1 = facile, 2 = moyen, 3 = difficile");
        int Nbdifficultée = scanner.nextInt();
        switch (Nbdifficultée) {
            case 1:
                question.setDifficultée("facile");
                break;
            case 2:
                question.setDifficultée("moyen");
                break;
            case 3:
                question.setDifficultée("difficile");
                break;
        }
        this.addQuestion(question);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public int getId() {
        return id;
    }
}
