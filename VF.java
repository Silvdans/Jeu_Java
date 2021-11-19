package com.company;

import java.util.List;

public class VF extends Question{

    private List<String> reponses;
    private String bonneReponse;

    public VF(String difficultée,String question,List<String> reponse,String bonneReponse){
        super(difficultée,question,reponse,bonneReponse);
    }

    public VF(){

    }
    public void ajouterReponse(){

    }
    public List<String> getReponses() {
        return reponses;
    }

    @Override
    public void setReponse(List<String> reponses) {
        this.reponses = reponses;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public void setBonneReponse(String bonneReponse) {
        this.bonneReponse = bonneReponse;
    }
}
