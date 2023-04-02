/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import java.util.ListIterator;


import java.util.ListIterator;
import java.util.Scanner;


/**
 *
 * @author kavip
 */
public  class Doctor {
    
    //Dcelaring ANSI_RESET so we can reset the colour
    public static final String ANSI_RESET = "\u001B[30m";
    //Dcelaring ANSI_RED colour for error message use
    public static final String ANSI_RED = "\u001B[31m";
    
    
//    These fields will all be explicitly assigned values in the Child classes.
//    This meands that every child class will be responsible for deciding what these values should be.
//    Please see the Rheumatology class as an example
    protected String name;
    protected String department;
    protected String speciality;
    protected boolean surgeon;
    protected boolean onDuty;
    protected boolean canPrescribe;
    protected boolean canAdmit;
    protected boolean canDischarge;
    protected boolean canTransfer;
    
    public static ArrayList <Doctor> doctors = new ArrayList <>();


    public Doctor() {
    }

 
    
    

    public Doctor(String name, String department, String speciality, boolean surgeon, boolean onDuty, boolean canPrescribe, boolean canAdmit, boolean canDischarge, boolean canTransfer) {
        this.name = name;
        this.department = department;
        this.speciality = speciality;
        this.surgeon = surgeon;
        this.onDuty = onDuty;
        this.canPrescribe = canPrescribe;
        this.canAdmit = canAdmit;
        this.canDischarge = canDischarge;
        this.canTransfer = canTransfer;
    }
    
    
    
    public static Doctor getSurgeon (String department){
        ListIterator <Doctor> docList = Doctor.doctors.listIterator();
        
        while(docList.hasNext()){
            Doctor doc = docList.next();
            
            if ((doc.getDepartment().matches(department)) && (doc.canOperate())){
               
                return doc;
            }

        }
        return null;
    }
    
    
    
    public static Doctor getDoc (String department){
        ListIterator <Doctor> docList = Doctor.doctors.listIterator();
        
        while(docList.hasNext()){
            Doctor doc = docList.next();
            if ((doc.getDepartment().matches(department)) && (doc.canPrescribe())){
               // System.out.println("Assigned doctor: " + docList.next().getName());
               
               return doc;
            }   
   
        }
        return null;
        //System.out.println("Assigned doctor: " + docList.next().getName());
    }

    public boolean canOperate() {
        return surgeon && onDuty;
    }
     public boolean canPrescribe() {
        return canPrescribe && onDuty;
    }

    protected String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getSpeciality() {
        return speciality;
    }

    public boolean isSurgeon() {
        return surgeon;
    }

    public boolean isOnDuty() {
        return onDuty;
    }

    public boolean isCanPrescribe() {
        return canPrescribe;
    }

    public boolean isCanAdmit() {
        return canAdmit;
    }

    public boolean isCanDischarge() {
        return canDischarge;
    }

    public boolean isCanTransfer() {
        return canTransfer;
    }

    public static ArrayList<Doctor> getDoctors() {
        return doctors;
    }
    
    
}
