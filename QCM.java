package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QCM extends Question{
    public QCM(String difficultée,String question,List<String>reponse,String bonneReponse){
        super(difficultée,question,reponse,bonneReponse);
    }
    public QCM(){
        this.reponse = new ArrayList<String>();
    }
    public void ajouterReponse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez renseigner les 4 réponses possibles");
        int i  = 1;
        while(i < 5)
        {
            System.out.println("Réponse numéro : "+i);
            this.reponse.add(scanner.nextLine());
            i++;
        }
        boolean reponseIsValid = false;
        while(!reponseIsValid) {
            System.out.println("Quelle est la bonne réponse ?");
            String rep = scanner.nextLine();
            if (!(reponse.contains(rep))){
                System.out.println("Veuillez rentrer une réponse correspondante à une des 4 renseignées");
                for(String reponse : reponse){
                    System.out.println(reponse);
                }
            }
            else {
                reponseIsValid = true;
                this.bonneReponse = rep;
            }
        }

    }

    public List<String> getReponse() {
        return reponse;
    }

    @Override
    public void setReponse(List<String> reponse) {
        this.reponse = reponse;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public void setBonneReponse(String bonneReponse) {
        this.bonneReponse = bonneReponse;
    }
}
