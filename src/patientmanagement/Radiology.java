/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

/**
 *
 * @author kavip
 */
public class Radiology extends Doctor{
        public Radiology (String docName, String dept, boolean isSurgeon, boolean isOnDuty) {
        this.name = docName;
        this.department = dept;
        this.speciality = "ENT";
        this.surgeon = isSurgeon;
        this.onDuty = isOnDuty;
        this.canPrescribe = false;
        this.canAdmit = false; 
        this.canDischarge = false;
        this.canTransfer = true;
    }  
    
}
