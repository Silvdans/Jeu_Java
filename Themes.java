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
        List<String> reponse2 = new ArrayList<>();
        reponse2.add("10 millions d'années av J-C");
        reponse2.add("3 millions d'années av J-C\"");
        reponse2.add("5 millions d'années av J-C\"");
        reponse2.add("20 millions d'années av J-C\"");
        theme1.addQuestion(new QCM("facile", "On situe l’apparition de l’homme à","2",reponse2));
        List<String> reponse3 = new ArrayList<>();
        reponse3.add("a l'apparition de l'homme");
        reponse3.add("A l'invention de l'écriture");
        reponse3.add("A l'âge de fer");
        reponse3.add("A la mort de Papa Johnny");
        theme1.addQuestion(new QCM("facile","La préhistoire débute","1",reponse3));
        List<String> reponse4 = new ArrayList<>();
        reponse4.add("Les tribus belges");
        reponse4.add("Les Arvenes");
        reponse4.add("Les Celtes");
        reponse4.add("Le Wakanda");
        theme1.addQuestion(new QCM("facile", "En 1 500 av. J.-C., la conquête du territoire français commence avec","3",reponse4));
        List<String> reponse5 = new ArrayList<>();
        reponse5.add("En juillet 1914");
        reponse5.add("En Aout 1914");
        reponse5.add("En novembre 1914");
        reponse5.add("Le 30 février 2070");
        theme1.addQuestion(new QCM("facile","Quand débutent les combats de la Première Guerre mondiale ?","2",reponse5));
        List<String> reponse6 = new ArrayList<>();
        reponse6.add(" Louis-Philippe");
        reponse6.add("Louis XIV");
        reponse6.add(" Napoléon 1er");
        reponse6.add("Napoléon III");
        theme1.addQuestion(new QCM("facile", "Les Invalides abritent le tombeau de :","3",reponse6));
        List<String> reponse7 = new ArrayList<>();
        reponse7.add("Louis XIV");
        reponse7.add("KobaLaD");
        reponse7.add("Wejdene");
        reponse7.add("Arouf gangsta");
        theme1.addQuestion(new QCM("facile","Roi soleil ?","1",reponse7));
        List<String> reponse8 = new ArrayList<>();
        reponse8.add("Louis XIV");
        reponse8.add("KobaLaD");
        reponse8.add("Wejdene");
        reponse8.add("Arouf gangsta");
        theme1.addQuestion(new QCM("facile","Roi soleil ?","1",reponse8));
        List<String> reponse9 = new ArrayList<>();
        reponse9.add("Louis XIV");
        reponse9.add("KobaLaD");
        reponse9.add("Wejdene");
        reponse9.add("Arouf gangsta");
        theme1.addQuestion(new QCM("facile","Roi soleil ?","1",reponse9));
        List<String> reponse10 = new ArrayList<>();
        reponse10.add("Louis XIV");
        reponse10.add("KobaLaD");
        reponse10.add("Wejdene");
        reponse10.add("Arouf gangsta");
        theme1.addQuestion(new QCM("facile","Roi soleil ?","1",reponse10));
        themes.add(theme1);

        Theme theme2 = new Theme("Science");
        List<String> reponse11 = new ArrayList<String>();
        reponse11.add("Albert Einstein");
        reponse11.add("Isaac Newton");
        reponse11.add("Tupac");
        reponse11.add("Marie Curie");
        theme2.addQuestion(new QCM("moyen","Qui a élaboré la loi de la gravitation universelle ?","2",reponse11));
        List<String> reponse12 = new ArrayList<String>();
        reponse12.add("H2O");
        reponse12.add("CH3");
        reponse12.add("C17H21NO4");
        reponse12.add("NH3");
        theme2.addQuestion(new QCM("moyen","Quelle est la formule chimique de l'ammoniac ?","4",reponse12));
        theme2.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme2.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme2.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme2.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme2.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme2.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme2.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme2.addQuestion(new QCM("facile", "Paris ?","1",reponse));


        themes.add(theme2);

        Theme theme3 = new Theme("Sport");
        theme3.addQuestion(new RC("moyen","Quel pays a gagné la coupe du monde de 1998","france"));
        theme3.addQuestion(new VF("moyen","Un français a t'il battu le record de Renaud Lavillenie au saut à la perche ?","f"));
        theme3.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme3.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme3.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme3.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme3.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme3.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme3.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme3.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        themes.add(theme3);

        Theme theme4 = new Theme("Télévision");
        theme4.addQuestion(new RC("moyen","En quelle année a eu lieu la première édition de la star académie ?","2001"));
        theme4.addQuestion(new VF("moyen","La première télévision a été inventée en 1925","v"));
        theme4.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme4.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme4.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme4.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme4.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme4.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme4.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme4.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        themes.add(theme4);

        Theme theme5 = new Theme("Célébrités");
        theme5.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme5.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme5.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme5.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme5.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme5.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme5.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme5.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme5.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme5.addQuestion(new QCM("facile", "Paris ?","1",reponse));

        themes.add(theme5);

        Theme theme6 = new Theme("Philosophie");
        theme6.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme6.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme6.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme6.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme6.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme6.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme6.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme6.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme6.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme6.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        themes.add(theme6);

        Theme theme7 = new Theme("Séries/Films");
        theme7.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme7.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme7.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme7.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme7.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme7.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme7.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme7.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme7.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme7.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        themes.add(theme7);

        Theme theme8 = new Theme("Jeux Vidéos");
        theme8.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme8.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme8.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme8.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme8.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme8.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme8.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme8.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme8.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme8.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        themes.add(theme8);

        Theme theme9 = new Theme("Mythologie");
        theme9.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme9.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme9.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme9.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme9.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme9.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme9.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme9.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme9.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme9.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        themes.add(theme9);

        Theme theme10 = new Theme("Culture Générale");
        theme10.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme10.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme10.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme10.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme10.addQuestion(new QCM("facile", "Paris ?","1",reponse));
        theme10.addQuestion(new QCM("moyen", "Paris ?","1",reponse));
        theme10.addQuestion(new QCM("moyen", "Paris ?","1",reponse));
        theme10.addQuestion(new QCM("moyen", "Paris ?","1",reponse));
        theme10.addQuestion(new QCM("moyen", "Paris ?","1",reponse));
        theme10.addQuestion(new QCM("moyen", "Paris ?","1",reponse));
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
