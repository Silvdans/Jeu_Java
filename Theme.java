package com.company;

import java.util.ArrayList;
import java.util.List;

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
}
