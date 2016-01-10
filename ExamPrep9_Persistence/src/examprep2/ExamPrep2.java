/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examprep2;

import entity.Student;
import entity.Studypoint;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Bancho
 */
public class ExamPrep2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamPrep2PU");
        EntityManager em = emf.createEntityManager();
        
        //1
        //List<Student> results = em.createNamedQuery("Student.findAll").getResultList();
        
        //2
        //List<Student> results = em.createNamedQuery("Student.findByFirstname").setParameter("firstname", "Jan").getResultList();
        
        //3
        //List<Student> results = em.createNamedQuery("Student.findByLastname").setParameter("lastname", "olsen").getResultList();
        
        //for-loop for the three cases above
//        for (Student result : results) {
//            System.out.println(result.toString());
//        }
        
        
        //4
//        List<Student> students = em.createNamedQuery("Student.findById").setParameter("id", 2).getResultList();
//        Student s = students.get(0);
//        TypedQuery<Studypoint> query = (TypedQuery<Studypoint>) em.createQuery("SELECT s FROM Studypoint s WHERE s.studentId = :studentId");
//        query.setParameter("studentId", s);
//        List<Studypoint> results = query.getResultList();
//        
//        int score = 0;
//        for (Studypoint result : results) {
//            score += result.getScore();
//        }
//        System.out.println(score);
        
        
        //5
//        List<Student> students = em.createNamedQuery("Student.findAll").getResultList();
//        int totalScore = 0;
//        for (Student s : students) {
//            TypedQuery<Studypoint> query = (TypedQuery<Studypoint>) em.createQuery("SELECT s FROM Studypoint s WHERE s.studentId = :studentId");
//            query.setParameter("studentId", s);
//            List<Studypoint> results = query.getResultList();
//
//            for (Studypoint result : results) {
//                totalScore += result.getScore();
//            }
//        }
//        System.out.println(totalScore);
        
        
        //6
//        List<Student> students = em.createNamedQuery("Student.findAll").getResultList();
//        Student highestScoring = null;
//        int highestScore = 0;
//        for (Student s : students) {
//            TypedQuery<Studypoint> query = (TypedQuery<Studypoint>) em.createQuery("SELECT s FROM Studypoint s WHERE s.studentId = :studentId");
//            query.setParameter("studentId", s);
//            List<Studypoint> results = query.getResultList();
//
//            int score = 0;
//            for (Studypoint result : results) {
//                score += result.getScore();
//            }
//            if (s.getId() == 1) {
//                highestScoring = s;
//                highestScore = score;
//            }else{
//                if (score > highestScore) {
//                    highestScoring = s;
//                    highestScore = score;
//                }
//            }
//        }
//        System.out.println(highestScoring.toString());
        
        
        
        //7
//        List<Student> students = em.createNamedQuery("Student.findAll").getResultList();
//        Student lowestScoring = null;
//        int lowestScore = 0;
//        for (Student s : students) {
//            TypedQuery<Studypoint> query = (TypedQuery<Studypoint>) em.createQuery("SELECT s FROM Studypoint s WHERE s.studentId = :studentId");
//            query.setParameter("studentId", s);
//            List<Studypoint> results = query.getResultList();
//
//            int score = 0;
//            for (Studypoint result : results) {
//                score += result.getScore();
//            }
//            if (s.getId() == 1) {
//                lowestScoring = s;
//                lowestScore = score;
//            }else{
//                if (score < lowestScore) {
//                    lowestScoring = s;
//                    lowestScore = score;
//                }
//            }
//        }
//        System.out.println(lowestScoring.toString());
        
    }
    
}
