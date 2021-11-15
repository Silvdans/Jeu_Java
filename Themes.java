package com.company;

import java.util.ArrayList;
import java.util.List;

public class Themes {

    private List<Theme> themes = new ArrayList<Theme>();
    private List<Theme> themesSelectionnees = new ArrayList<Theme>();
    private static int theme_courant = 0;
    public Themes() {
        themes.add(new Theme("1"));
        themes.add(new Theme("2"));
        themes.add(new Theme("3"));
        themes.add(new Theme("4"));
        themes.add(new Theme("5"));
        themes.add(new Theme("6"));
        themes.add(new Theme("7"));
        themes.add(new Theme("8"));
        themes.add(new Theme("9"));
        themes.add(new Theme("10"));
    }

    public int selectionTheme(){
        theme_courant += 1;
        if(theme_courant>9)
        {
            theme_courant = 1;
        }
        return theme_courant-1;
    }

    public int selection5Themes(){
        return 0;
    }
    public String toString(){
        return "test";
    }
}
