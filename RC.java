package com.company;

import java.util.List;

public class RC extends Question{
    private List<String> reponse;
    private String bonneReponse;

    public RC(String difficultée,String question,Theme theme){
        super(difficultée,question,theme);
    }

    public RC(){

    }
    public void ajouterReponse(){

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
