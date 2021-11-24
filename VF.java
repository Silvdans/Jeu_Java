package com.company;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VF extends Question{

    public VF(String difficultée,String question,String bonneReponse){
        super(difficultée,question,bonneReponse);
    }

    public VF(){

    }
    public void ajouterReponse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("La réponse est elle Vraie ou Fausse ?(V ou F)");
        String rep = scanner.nextLine().toLowerCase(Locale.ROOT);
        this.bonneReponse = rep;
    }

    public void demanderReponse(){
        System.out.println("Vrai ou Faux ? (Rentrez V ou F)");
    }

}
