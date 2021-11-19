package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataJson {
    private Themes themes;

    public DataJson(Themes themes){
        this.themes = themes;
    }
    public void writeDataInJsonFile(Theme theme) throws IOException {
        File file = new File("datas.json");
        FileWriter writer = new FileWriter(file, true);
        Gson gson = new Gson();
        if(!file.exists()){
            System.out.println("Le fichier existe pas");
        }
        JsonParser parser = new JsonParser();
        JsonArray a = (JsonArray) parser.parse(new FileReader("data.json"));
        //Object object = gson.fromJson(new FileReader("datas.json"), Object.class);
        for (Object o : a){
            JsonObject xx = (JsonObject) o;
        }

        String jsonString = gson.toJson(themes);

        writer.write(jsonString);
        writer.close();
    }
    public void readDataFromJsonFile(){

    }

}

