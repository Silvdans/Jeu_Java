package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Themes {

    private List<Theme> themes = new ArrayList<Theme>();
    private List<Theme> themesSelectionnees = new ArrayList<Theme>();
    private List<Theme> themesConsommés = new ArrayList<Theme>();
    private String themecreateurs;

    private static int theme_courant = 0;
    private int dernierTheme;
    public Themes() {

        Theme theme1 = new Theme("Histoire");
        Theme theme2 = new Theme("Science");
        Theme theme3 = new Theme("Sport");
        Theme theme4 = new Theme("Télévision");
        Theme theme5 = new Theme("Célébrités");
        Theme theme6 = new Theme("Philosophie");
        Theme theme7 = new Theme("Séries/Films");
        Theme theme8 = new Theme("Jeux Vidéos");
        Theme theme9 = new Theme("Mythologie");
        Theme theme10 = new Theme("Culture Générale");

        themes.add(theme1);
        themes.add(theme2);
        themes.add(theme3);
        themes.add(theme4);
        themes.add(theme5);
        themes.add(theme6);
        themes.add(theme7);
        themes.add(theme8);
        themes.add(theme9);
        themes.add(theme10);
    }

    public void changerTheme(){
        theme_courant += 1;
    }

    public Theme getCurrentTheme(){
        return themes.get(theme_courant);
    }
    public String toString(){
        return "test";
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public Theme getThemeByName(String nomTheme){
        Theme varTheme = null;
        for (Theme theme : this.themesSelectionnees){
            if(theme.getNom().equals(nomTheme)){
                varTheme = theme;
            }
        }
        if(varTheme == null){
            throw new InputMismatchException();
        }
        return varTheme;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public List<Theme> getThemesSelectionnees() {
        return themesSelectionnees;
    }

    public void setThemesSelectionnees(Phase phase) {
        if(phase instanceof Phase1){
            this.themesSelectionnees.addAll(themes);
        }
        if(phase instanceof  Phase2){
            this.themesSelectionnees.clear();
            List<Theme> doublons = new ArrayList<Theme>();
            int i = 0;
            while(i < 6)
            {
                int random = (int)(Math.random() * (themes.size()));

                if(!(themes.get(random).getId() == dernierTheme) && !(doublons.contains(themes.get(random))))
                {
                    this.themesSelectionnees.add(this.themes.get(random));
                    doublons.add(this.themes.get(random));
                    i++;
                }

            }
        }
        if(phase instanceof  Phase3){
            this.themesSelectionnees.clear();
            List<Theme> doublons = new ArrayList<Theme>();
            int i = 0;
            while(i < 3)
            {
                int random = (int)(Math.random() * (themes.size()));

                if(!(themes.get(random).getId() == dernierTheme) && !(doublons.contains(themes.get(random))))
                {
                    this.themesSelectionnees.add(this.themes.get(random));
                    doublons.add(this.themes.get(random));
                    i++;
                }

            }
        }
    }
    public void afficherThemesSelectionnes(){
        for (Theme theme : this.themesSelectionnees){
            System.out.println(theme.getNom());
        }
    }
    public static int getTheme_courant() {
        return theme_courant;
    }

    public static void setTheme_courant(int theme_courant) {
        Themes.theme_courant = theme_courant;
    }
    public int getDernierTheme() {
        return dernierTheme;
    }

    public void setDernierTheme(int dernierTheme) {
        this.dernierTheme = dernierTheme;
    }

    public List<Theme> getThemesConsommés() {
        return themesConsommés;
    }

    public void addThemesConsommés(Theme theme) {
        this.themesConsommés.add(theme);
    }
}
