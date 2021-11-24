package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QCM extends Question{
    private List<String> reponse;
    public QCM(String difficultée,String question,String bonneReponse,List<String> reponse){
        super(difficultée,question,bonneReponse);
        this.reponse = reponse;
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
    public void demanderReponse(){
        System.out.println("Vous avez le choix entre ces 4 options :");
        int i = 1;
        for (String reponse : this.reponse){
            System.out.println("Réponse N° "+i+" : "+reponse);
            i++;
        }
    }

    public List<String> getReponse() {
        return reponse;
    }

}
