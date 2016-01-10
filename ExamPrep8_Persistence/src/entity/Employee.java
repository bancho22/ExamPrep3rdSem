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
public class Employee extends Person implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int soSecNo;
    
    private double wage;
    
    private String taxClass;

    public Employee() {
    }

    public Employee(int soSecNo, double wage, String taxClass, String firstName, String lastName, Date birthDate, int age, boolean isMarried, Grade grade) {
        super(firstName, lastName, birthDate, age, isMarried, grade);
        this.soSecNo = soSecNo;
        this.wage = wage;
        this.taxClass = taxClass;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSoSecNo() {
        return soSecNo;
    }

    public void setSoSecNo(int soSecNo) {
        this.soSecNo = soSecNo;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }
    
    
    
}
