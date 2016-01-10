/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.City;
import entity.Country;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Bancho
 */
public class WorldFacade {
    private EntityManagerFactory emf;
    
    public WorldFacade(EntityManagerFactory emf){
        this.emf = emf;
    }
    
    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public List<Country> getCountries(){
        EntityManager em = getEntityManager();
        List<Country> countries = new ArrayList<Country>();
        try{
            countries = em.createNamedQuery("Country.findAll").getResultList();
        }finally{
            em.close();
        }
        return countries;
    }
    
    public List<Country> getCountries(int minPop){
        EntityManager em = getEntityManager();
        List<Country> countries = new ArrayList<Country>();
        try{
            Query query = em.createQuery("SELECT c FROM Country c WHERE c.population > :population");
            query.setParameter("population", minPop);
            countries = query.getResultList();
        }finally{
            em.close();
        }
        return countries;
    }
    
    public List<City> getCities(String code){
        EntityManager em = getEntityManager();
        List<City> cities = new ArrayList<City>();
        try{
            Query query = em.createNamedQuery("City.findByCountryCode");
            query.setParameter("countryCode", code);
            cities = query.getResultList();
        }finally{
            em.close();
        }
        return cities;
    }
    
    public City addCity(City city){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(city);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return city;
    }
}
