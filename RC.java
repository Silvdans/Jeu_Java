package com.company;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class RC extends Question{

    public RC(String difficultée,String question,String bonneReponse){
        super(difficultée,question,bonneReponse);
    }

    public RC(){

    }
    public void ajouterReponse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez renseigner votre réponse courte");
        String rep = scanner.nextLine().toLowerCase(Locale.ROOT);
        this.bonneReponse = rep;
    }
    public void demanderReponse(){
        System.out.println("Veuillez rentrez une reponse courte");
    }
    public List<String> getReponse() {
        return reponse;
    }
}
