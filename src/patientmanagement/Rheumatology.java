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

    // Rheumatology CLASSES BASED ON DOCTOR/DEPARTMENT PERMISSIONS
    // EXTENDS DOCTOR CLASS AS IT INHERENTS THE SAME INSTANCE FIELDS AND METHODS
    // SPECIFIC CLASS ATTRIBUTES EXPLICITLY SET WITHIN CONSTRUCTORS BASES ON DEPARTMENT PERMISSIONS
public class Rheumatology extends Doctor {
    // String docName, String dept, boolean isSuregon, boolean isOnDuty TAKEN AS PARAMETERS 
    // FOR CONSTRUCTION WHEN READING FROM STAFF CSV FILE
    public Rheumatology(String docName, String dept, boolean isSurgeon, boolean isOnDuty) {
        this.name = docName;
        this.department = dept;
        this.speciality = "Rheumatology";
        this.surgeon = isSurgeon;
        this.onDuty = isOnDuty;
        this.canPrescribe = true;
        this.canAdmit = true;
        this.canDischarge = true;
        // explicitly declaring false instead of calling super() for better code readibility
        this.canTransfer = false;
    }
    // SPECIFIC CLASS ATTRIBUTES EXPLICITLY SET WITHIN CONSTRUCTORS BASES ON DEPARTMENT PERMISSIONS
    public Rheumatology() {
        this.department = "Rheumatology";
        this.surgeon = false;
        this.canPrescribe = true;
        this.canAdmit = true;
        this.canDischarge = true;
        this.canTransfer = false;
    }

    // GETTERS AND SETTERS AUTOMATICALLY SET FOR FUTURES DEVELOPEMENT USE
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public boolean isSurgeon() {
        return surgeon;
    }

    public void setSurgeon(boolean surgeon) {
        this.surgeon = surgeon;
    }

    public boolean isOnDuty() {
        return onDuty;
    }

    public void setOnDuty(boolean onDuty) {
        this.onDuty = onDuty;
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
