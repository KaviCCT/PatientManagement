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
public class Radiology extends Doctor{
        public Radiology (String docName, String dept, boolean isSurgeon, boolean isOnDuty) {
        this.name = docName;
        this.department = dept;
        this.speciality = "Radiology";
        this.surgeon = isSurgeon;
        this.onDuty = isOnDuty;
        this.canPrescribe = false;
        this.canAdmit = false; 
        this.canDischarge = false;
        this.canTransfer = true;
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
