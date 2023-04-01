/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

import java.util.Random;

/**
 *
 * @author kavip
 */
public class Patient implements PatientInterface{
    
    //Declaring ANSI_RESET so we can reset the print colour
    public static final String ANSI_RESET = "\u001B[30m";
    //Declaring ANSI_RED colour for error message use
    public static final String ANSI_RED = "\u001B[31m";
    //Declaring ANSI_BLUE colour for User Interface use
    public static final String ANSI_BLUE = "\u001B[34m";
    
    
    private String name;
    private int patientId;
    private int nextPatientId = 1;
    private String Department;
    private boolean inPatient;
    private String[] complaints;
    private boolean needsMedication;
    private boolean needsSurgery;
    public static boolean isGood = true;

    @Override
    public String toString() {
        return "Patient{" + "name=" + name + ", patientId=" + patientId + ", nextPatientId=" + nextPatientId + ", Department=" + Department + ", inPatient=" + inPatient + ", complaints=" + complaints + ", needsMedication=" + needsMedication + ", needsSurgery=" + needsSurgery + '}';
    }
    
 

    public Patient(String name,  String[] complaints) {
        isGood = true;// boolean isGood Reset
        // if-else CONDITIONAL STATEMENT FOR VALIDATING name VIA Regex PATTERNS (Hyphenated names excepted)
        if (!(name.matches("[a-zA-Z-]+")) && !(name.matches("[a-zA-Z-]+\\s[a-zA-Z-]+"))){
            System.out.println(ANSI_RED + "Invalid Name." + ANSI_RESET);
            // IF name FAILS VALIDATION isGood BOOLEAN CHANGED AND RETURNED false AND ERROR MESSAGE PRINTED TO WINDOW
            isGood = false;
        }
        else{// name PASSES VALIDATION AND IS SET
            this.name = name;
        } 
        
        if (isGood){ // IF name & email ARE VALID EMPLOYEE NUMBER ALLOCATED
            this.patientId = nextPatientId;
            nextPatientId = nextPatientId+1;
            this.complaints = complaints;
            this.Department = this.getDepartment();
        }
    }
    
        // SETTER METHODS TO VALIDATE AND SET name ACCEPTING String name  AS A PARAMETER 
    public void setName(String name) {
        isGood = true;// boolean isGood Reset
        // if-else CONDITIONAL STATEMENT FOR VALIDATING name VIA Regex PATTERNS
        if (!(name.matches("[a-zA-Z-]+")) && !(name.matches("[a-zA-Z-]+\\s[a-zA-Z-]+"))){
            System.out.println(ANSI_RED + "Invalid Name." + ANSI_RESET);
            // IF name FAILS VALIDATION isGood BOOLEAN CHANGED AND RETURNED false AND ERROR MESSAGE PRINTED TO WINDOW
           isGood = false;
        }
        else{// name PASSES VALIDATION AND IS SET
            this.name = name;
        } 
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPatientId() {
        return this.patientId;
    }

    @Override
    public String getDepartment() {
        return this.Department;
    }

    @Override
    public boolean isInpatient() {
        return this.inPatient;
    }

    @Override
    public String[] getComplaints() {
        return this.complaints;
    }

    @Override
    public boolean needsMedication() {
        Random random = new Random ();
        return random.nextBoolean ();
    }

    @Override
    public boolean needsSurgery() {
       Random random = new Random ();
        return random.nextBoolean ();
    }

    @Override
    public void transferDepartment(String department) {
        Department = department;
    }

    @Override
    public void haveSurgery(String speciality) {
        System.out.println("Surgery perfomed!");
    }

    @Override
    public void prescribeMedication(String speciality) {
        System.out.println("Medication prescribed!");
    }

    @Override
    public void admitInpatient(String department) {
        inPatient = true;
    }

    @Override
    public void dischargeInpatient() {
        inPatient = false;
    }
    
}
