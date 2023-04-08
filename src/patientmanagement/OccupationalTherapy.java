/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

import java.util.ArrayList;

/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 */

    // Occupational Therapy CLASSES BASED ON DOCTOR/DEPARTMENT PERMISSIONS
    // EXTENDS DOCTOR CLASS AS IT INHERENTS THE SAME INSTANCE FIELDS AND METHODS
    // SPECIFIC CLASS ATTRIBUTES EXPLICITLY SET WITHIN CONSTRUCTORS BASES ON DEPARTMENT PERMISSIONS
public class OccupationalTherapy extends Doctor {
    
    // String docName, String dept, boolean isSuregon, boolean isOnDuty TAKEN AS PARAMETERS 
    // FOR CONSTRUCTION WHEN READING FROM STAFF CSV FILE 
        public OccupationalTherapy (String docName, String dept, boolean isSurgeon, boolean isOnDuty) {
        this.name = docName;
        this.department = dept;
        this.speciality = "Occupational Therapy";
        this.surgeon = isSurgeon;
        this.onDuty = isOnDuty;
        this.canPrescribe = true;
        this.canAdmit = false; // explicitly declaring false instead of calling super() for better code readibility
        this.canDischarge = true;
        this.canTransfer = false; // explicitly declaring false instead of calling super() for better code readibility
    }
        
     // SPECIFIC CLASS ATTRIBUTES EXPLICITLY SET WITHIN CONSTRUCTORS BASES ON DEPARTMENT PERMISSIONS 
     public OccupationalTherapy() {
        this.department = "Occupational Therapy";
        this.surgeon = false;
        this.canPrescribe = true;
        this.canAdmit = false;
        this.canDischarge = true;
        this.canTransfer = false;
     }

    // GETTERS AND SETTERS AUTOMATICALLY SET FOR FUTURES DEVELOPEMENT USE
        @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        @Override
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

        @Override
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

        @Override
    public boolean isSurgeon() {
        return surgeon;
    }

    public void setSurgeon(boolean surgeon) {
        this.surgeon = surgeon;
    }

        @Override
    public boolean isOnDuty() {
        return onDuty;
    }

    public void setOnDuty(boolean onDuty) {
        this.onDuty = onDuty;
    }

        @Override
    public boolean isCanPrescribe() {
        return canPrescribe;
    }



        @Override
    public boolean isCanAdmit() {
        return canAdmit;
    }

        @Override
    public boolean isCanDischarge() {
        return canDischarge;
    }



        @Override
    public boolean isCanTransfer() {
        return canTransfer;
    }



    public static ArrayList<Doctor> getDoctors() {
        return doctors;
    }

        
}
