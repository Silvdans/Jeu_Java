package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


public class Themes {

    private List<Theme> themes = new ArrayList<Theme>();
    private List<Theme> themesSelectionnees = new ArrayList<Theme>();
    private List<Theme> themesConsommés = new ArrayList<Theme>();

    private static int theme_courant = 0;

    private int dernierTheme;
    public Themes() {

        Theme theme1 = new Theme("Histoire");
        List<String> reponse = new ArrayList<>();
        reponse.add("Paris");
        reponse.add("Manchester");
        reponse.add("Liverpool");
        reponse.add("Londres");
        theme1.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        List<String> reponse1 = new ArrayList<>();
        reponse1.add("Louis XIV");
        reponse1.add("KobaLaD");
        reponse1.add("Wejdene");
        reponse1.add("Arouf gangsta");
        theme1.addQuestion(new QCM("facile","Roi soleil ?","1",reponse1));
        themes.add(theme1);

        Theme theme2 = new Theme("Science");
        List<String> reponse2 = new ArrayList<String>();
        reponse2.add("Albert Einstein");
        reponse2.add("Isaac Newton");
        reponse2.add("Tupac");
        reponse2.add("Marie Curie");
        theme2.addQuestion(new QCM("moyen","Qui a élaboré la loi de la gravitation universelle ?","2",reponse2));
        List<String> reponse3 = new ArrayList<String>();
        reponse3.add("H2O");
        reponse3.add("CH3");
        reponse3.add("C17H21NO4");
        reponse3.add("NH3");
        theme2.addQuestion(new QCM("moyen","Quelle est la formule chimique de l'ammoniac ?","4",reponse3));
        themes.add(theme2);

        Theme theme3 = new Theme("Sport");
        theme3.addQuestion(new RC("moyen","Quel pays a gagné la coupe du monde de 1998","france"));
        theme3.addQuestion(new VF("moyen","Un français a t'il battu le record de Renaud Lavillenie au saut à la perche ?","f"));
        themes.add(theme3);

        Theme theme4 = new Theme("Télévision");
        theme4.addQuestion(new RC("moyen","En quelle année a eu lieu la première édition de la star académie ?","2001"));
        theme4.addQuestion(new VF("moyen","La première télévision a été inventée en 1925","v"));
        themes.add(theme4);

        Theme theme5 = new Theme("Célébrités");
        themes.add(theme5);

        Theme theme6 = new Theme("Philosophie");
        List<String> reponse10 = new ArrayList<String>();
        List<String> reponse11 = new ArrayList<String>();
        themes.add(theme6);

        Theme theme7 = new Theme("Séries/Films");
        List<String> reponse12 = new ArrayList<String>();
        List<String> reponse13 = new ArrayList<String>();
        themes.add(theme7);

        Theme theme8 = new Theme("Jeux Vidéos");
        List<String> reponse14 = new ArrayList<String>();
        List<String> reponse15 = new ArrayList<String>();
        themes.add(theme8);

        Theme theme9 = new Theme("Mythologie");
        List<String> reponse16 = new ArrayList<String>();
        List<String> reponse17 = new ArrayList<String>();
        themes.add(theme9);

        Theme theme10 = new Theme("Culture Générale");
        List<String> reponse18 = new ArrayList<String>();
        List<String> reponse19 = new ArrayList<String>();
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
