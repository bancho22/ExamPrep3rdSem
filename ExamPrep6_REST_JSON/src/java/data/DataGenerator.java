/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Bancho
 */
public class DataGenerator {
    
    private String[] firstNames;
    private String[] lastNames;
    private String[] streetNames;
    private String[] cityNames;
    
    private Gson gson;
    private Random rand;
    private final int TEST_ARRAYS_LENGTH;

    public DataGenerator() {
        TEST_ARRAYS_LENGTH = 4;
        firstNames = new String[TEST_ARRAYS_LENGTH];
        lastNames = new String[TEST_ARRAYS_LENGTH];
        streetNames = new String[TEST_ARRAYS_LENGTH];
        cityNames = new String[TEST_ARRAYS_LENGTH];
        
        firstNames[0] = "Jim";
        firstNames[1] = "Johnny";
        firstNames[2] = "Jack";
        firstNames[3] = "Captian";
        
        lastNames[0] = "Daniels";
        lastNames[1] = "Morgan";
        lastNames[2] = "Beam";
        lastNames[3] = "Walker";
        
        streetNames[0] = "Baker st. 221B";
        streetNames[1] = "Sthvej 243";
        streetNames[2] = "Othervej 324";
        streetNames[3] = "Thirdvej 854";
        
        cityNames[0] = "Kobenhavn";
        cityNames[1] = "Aalborg";
        cityNames[2] = "Aarhus";
        cityNames[3] = "Odense";
        
        gson = new GsonBuilder().setPrettyPrinting().create();
        rand = new Random();
    }
    
    public String getData(int n, String dataType){
        String[] split = dataType.split(",");
        
        ArrayList<String[]> arraysToUse = new ArrayList<String[]>();
        
        for (String type : split) {
            switch(type){
                case "fName":
                    arraysToUse.add(firstNames);
                    break;
                case "lName":
                    arraysToUse.add(lastNames);
                    break;
                case "street":
                    arraysToUse.add(streetNames);
                    break;
                case "city":
                    arraysToUse.add(cityNames);
                    break;
                default:
                    break;
            }
        }
        
        JsonArray jsonArr = new JsonArray();
        int j;
        for (int i = 0; i < n; i++) {
            JsonObject jsonP = new JsonObject();
            j = 0;
            for (String type : split) {
                jsonP.addProperty(type, arraysToUse.get(j++)[rand.nextInt(TEST_ARRAYS_LENGTH)]);
            }
            jsonArr.add(jsonP);
        }
        return gson.toJson(jsonArr);
    }
    
}
