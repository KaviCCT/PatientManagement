/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

import java.util.ArrayList;

/**
 *
 * @author kavip
 */
public  class Doctor {
//    These fields will all be explicitly assigned values in the Child classes.
//    This meands that every child class will be responsible for deciding what these values should be.
//    Please see the Rheumatology class as an example
    public String name;
    public String department;
    public String speciality;
    public boolean surgeon;
    public boolean onDuty;
    public boolean canPrescribe;
    public boolean canAdmit;
    public boolean canDischarge;
    public boolean canTransfer;
    
    public static ArrayList <Doctor> doctors = new ArrayList <>();
    
    public boolean canOperate() {
        return surgeon && onDuty;
    }
     public boolean canPrescribe() {
        return canPrescribe && onDuty;
    }

    public String getName() {
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
