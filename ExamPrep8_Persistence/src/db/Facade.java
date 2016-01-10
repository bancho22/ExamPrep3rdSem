/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Grade;
import entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Bancho
 */
public class Facade {
    
    private EntityManagerFactory emf;
    
    public Facade(EntityManagerFactory emf){
        this.emf = emf;
    }
    
    private EntityManager getEntitymanager(){
        return emf.createEntityManager();
    }
    
    
    public int addPerson(Person p){
        EntityManager em = getEntitymanager();
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return p.getId();
    }
    
    public void editPerson(Person p){
        EntityManager em = getEntitymanager();
        try{
            em.getTransaction().begin();
            em.refresh(p);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public Person getPerson(int id){
        EntityManager em = getEntitymanager();
        Person p = null;
        try{
            em.getTransaction().begin();
            p = em.find(Person.class, id);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        
        if (p != null) {
            List<Person> supervised = getSupervised(p);
            p.setSupervised(supervised);
        }
        return p;
    }
    
    public void deletePerson(Person p){
        EntityManager em = getEntitymanager();
        try{
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public Grade getGrade(int id){
        EntityManager em = getEntitymanager();
        Grade g = null;
        try{
            em.getTransaction().begin();
            g = em.find(Grade.class, id);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return g;
    }
    
    private List<Person> getSupervised(Person p){
        EntityManager em = getEntitymanager();
        List<Person> supervised = new ArrayList();
        try{
            TypedQuery<Person> query = (TypedQuery<Person>) em.createQuery("SELECT p FROM Person p WHERE p.supervisor = :supervisor_Id");
            query.setParameter("supervisor_Id", p);
            supervised = query.getResultList();
        }finally{
            em.close();
        }
        return supervised;
    }
}
