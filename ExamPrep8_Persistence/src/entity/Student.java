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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bancho
 */
@Entity
public class Student extends Person implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int matNr;
    
    @Temporal(TemporalType.DATE)
    private Date matDate;

    
    
    public Student() {
    }

    public Student(int matNr, Date matDate, String firstName, String lastName, Date birthDate, int age, boolean isMarried, Grade grade) {
        super(firstName, lastName, birthDate, age, isMarried, grade);
        this.id = id;
        this.matNr = matNr;
        this.matDate = matDate;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMatNr() {
        return matNr;
    }

    public void setMatNr(int matNr) {
        this.matNr = matNr;
    }

    public Date getMatDate() {
        return matDate;
    }

    public void setMatDate(Date matDate) {
        this.matDate = matDate;
    }
    
    
    
}
