/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.City;
import entity.Country;
import facade.WorldFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bancho
 */
public class Main {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WORLD_REST_APIPU");
        WorldFacade wf = new WorldFacade(emf);
        
//        for (Country c : wf.getCountries(100000000)) {
//            System.out.println(c.getName());
//        }
        
        for (City c : wf.getCities("BGR")) {
            System.out.println(c.getName());
        }
    }
    
}
