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
public class OccupationalTherapy extends Doctor {
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

//    public OccupationalTherapy(String docName, String dept, boolean isSurgeon, boolean isOnDuty) {
//    super( docName, dept, "Occupational Therapy", isSurgeon, isOnDuty, true, false, true, false);
//    }

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

    public void setCanPrescribe(boolean canPrescribe) {
        this.canPrescribe = canPrescribe;
    }

    public boolean isCanAdmit() {
        return canAdmit;
    }

    public void setCanAdmit(boolean canAdmit) {
        this.canAdmit = canAdmit;
    }

    public boolean isCanDischarge() {
        return canDischarge;
    }

    public void setCanDischarge(boolean canDischarge) {
        this.canDischarge = canDischarge;
    }

    public boolean isCanTransfer() {
        return canTransfer;
    }

    public void setCanTransfer(boolean canTransfer) {
        this.canTransfer = canTransfer;
    }

    public static ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public static void setDoctors(ArrayList<Doctor> doctors) {
        Doctor.doctors = doctors;
    }
    
       
        
}
