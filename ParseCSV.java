package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseCSV {
    private Themes themes;
    public ParseCSV(Themes themes){
        this.themes = themes;
    }
    public void parse(){
        File fileToParse = new File("test.csv");
        //System.out.println(fileToParse.getAbsolutePath());

        BufferedReader fileReader = null;
        if (!fileToParse.exists()) {
            try{
                fileToParse.createNewFile();
            }catch (java.io.IOException e){
                e.printStackTrace();
            }
        }
        //separateur fichier csv
        final String DELIMITER = ",";
        try {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileToParse));

            //Lire le fichier ligne par ligne
            while ((line = fileReader.readLine()) != null)
            {
                String[] tokens  = line.split(DELIMITER);

                for (Theme theme : this.themes.getThemes()){
                    if(theme.getNom().equals(tokens[0])) {

                        if (tokens[1].equals("QCM")) {
                            List<String> reponse = new ArrayList<String>();
                            reponse.add(tokens[4]);
                            reponse.add(tokens[5]);
                            reponse.add(tokens[6]);
                            reponse.add(tokens[7]);
                            this.themes.getThemeByName(theme.getNom()).addQuestion(new QCM(tokens[2], tokens[3], tokens[4], reponse));
                        }
                        if (tokens[1].equals("VF")) {
                            this.themes.getThemeByName(theme.getNom()).addQuestion(new VF(tokens[2], tokens[3], tokens[4]));
                        }
                        if (tokens[1].equals("RC")) {
                            this.themes.getThemeByName(theme.getNom()).addQuestion(new VF(tokens[2], tokens[3], tokens[4]));
                        }
                    }
                }
                System.out.println(themes.getThemeByName("Histoire").getQuestions().size());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



