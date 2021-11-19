package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Questions {

    private Themes themes;
    public Questions(Themes themes) {
        this.themes = themes;
    }

    public void ajoutQuestion() {
        //Création fichier question

    File file = new File("question.txt");
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
        //DataJson parser = new DataJson(themes);
        System.out.println("Les thèmes existants sont :");
        for(Theme theme : this.themes.getThemes()){
            System.out.println(theme.getNom());
        }
        System.out.println("Quelle est le thème de la question ?");
        String nomTheme = scanner.next();
        for (Theme theme: this.themes.getThemes())
        {
            if (theme.getNom().equals(nomTheme)){
                theme.addQuestions(question);
            }
        }
    }
}
