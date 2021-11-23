package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


public class Themes {

    private List<Theme> themes = new ArrayList<Theme>();
    private List<Theme> themesSelectionnees = new ArrayList<Theme>();
    private static int theme_courant = 0;
    public Themes() {

        Theme theme1 = new Theme("Histoire");
        List<String> reponse = new ArrayList<>();
        reponse.add("Paris");
        reponse.add("Manchester");
        reponse.add("Liverpool");
        reponse.add("Londres");
        theme1.addQuestion(new QCM("facile", "Paris ?",reponse,"1"));
        List<String> reponse1 = new ArrayList<>();
        reponse1.add("Louis XIV");
        reponse1.add("KobaLaD");
        reponse1.add("Wejdene");
        reponse1.add("Arouf gangsta");
        theme1.addQuestion(new QCM("facile","Roi soleil ?",reponse1,"1"));

        themes.add(theme1);
        themes.add(new Theme("Science"));
        themes.add(new Theme("Sport"));
        themes.add(new Theme("Télévision"));
        themes.add(new Theme("Célébrités"));
        themes.add(new Theme("Philosophie"));
        themes.add(new Theme("Séries/Films"));
        themes.add(new Theme("Jeux Vidéos"));
        themes.add(new Theme("Mythologie"));
        themes.add(new Theme("Culture Générale"));
    }

    public String selectionTheme(){
        theme_courant += 1;
        if(theme_courant>10)
        {
            theme_courant = 1;
        }
        return themes.get(theme_courant-1).getNom();
    }

    public String getCurrentTheme(){
        return themes.get(theme_courant).getNom();
    }
    public int selection5Themes(){
        return 0;
    }
    public String toString(){
        return "test";
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public Theme getThemeByName(String nomTheme){
        Theme varTheme = null;
        for (Theme theme : this.themes){
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

    public void setThemesSelectionnees(List<Theme> themesSelectionnees) {
        this.themesSelectionnees = themesSelectionnees;
    }

    public static int getTheme_courant() {
        return theme_courant;
    }

    public static void setTheme_courant(int theme_courant) {
        Themes.theme_courant = theme_courant;
    }

}
