/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

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
    
}
