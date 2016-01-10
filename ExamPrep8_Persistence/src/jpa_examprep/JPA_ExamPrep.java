/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_examprep;

import db.Facade;
import entity.Employee;
import entity.Grade;
import entity.Person;
import entity.Student;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bancho
 */
public class JPA_ExamPrep {

    public static void main(String[] args) {
//        Persistence.generateSchema("JPA_ExamPrepPU", null);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_ExamPrepPU");
//        EntityManager em = emf.createEntityManager();
//        try{
//            Grade excellent = new Grade("excellent", 6);
//            Grade very_good = new Grade("very good", 5);
//            
//            Calendar cal = Calendar.getInstance();
//            cal.set(Calendar.YEAR, 1995);
//            cal.set(Calendar.MONTH, Calendar.OCTOBER);
//            cal.set(Calendar.DAY_OF_MONTH, 22);
//            
//            Person p1 = new Person("Bancho", "Petrov", cal.getTime(), 19, false, excellent);
//            
//            cal.set(Calendar.YEAR, 1995);
//            cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
//            cal.set(Calendar.DAY_OF_MONTH, 21);
//            
//            Person p2 = new Student(42, Calendar.getInstance().getTime(), "Vasil", "Milanov", cal.getTime(), 19, false, very_good);
//            p2.setSupervisor(p1);
//            
//            cal.set(Calendar.YEAR, 1961);
//            cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
//            cal.set(Calendar.DAY_OF_MONTH, 2);
//            
//            Person p3 = new Employee(610902, 500.0, "taxable", "Liliya", "Petrova", cal.getTime(), 54, false, excellent);
//            p3.setSupervisor(p1);
//            
//            p1.addSupervised(p2);
//            p1.addSupervised(p3);
//            
//            em.getTransaction().begin();
//            em.persist(excellent);
//            em.persist(very_good);
//            em.persist(p1);
//            em.persist(p2);
//            em.persist(p3);
//            em.getTransaction().commit();
//            
//        }finally{
//            em.close();
//        }
        
        
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_ExamPrepPU");
        Facade f = new Facade(emf);
        Person p = f.getPerson(1);
        
//        Person p1 = new Person("Alen", "Nikolov", Calendar.getInstance().getTime(), 0, false, f.getGrade(2));
//        int id = f.addPerson(p1);
//        System.out.println(id);
    }
    
}
