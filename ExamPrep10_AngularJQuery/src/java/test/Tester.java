/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import model.DataFactory;

/**
 *
 * @author Bancho
 */
public class Tester {
    
    public static void main(String[] args) {
        String members = new DataFactory().getMembersAsJson();
        //System.out.println(members.length());
        JsonArray json = new JsonParser().parse(members).getAsJsonArray();
        for (JsonElement json1 : json) {
            System.out.println(json1.toString());
        }
    }
    
}
