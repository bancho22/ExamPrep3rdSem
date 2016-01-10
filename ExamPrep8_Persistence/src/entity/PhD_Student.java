/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Bancho
 */
@Entity
public class PhD_Student extends Employee implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String dissSubject;

    
    public PhD_Student() {
    }

    public PhD_Student(Integer id, String dissSubject, int soSecNo, double wage, String taxClass, String firstName, String lastName, Date birthDate, int age, boolean isMarried, Grade grade) {
        super(soSecNo, wage, taxClass, firstName, lastName, birthDate, age, isMarried, grade);
        this.id = id;
        this.dissSubject = dissSubject;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDissSubject() {
        return dissSubject;
    }

    public void setDissSubject(String dissSubject) {
        this.dissSubject = dissSubject;
    }
    
    
}
