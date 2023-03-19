/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

/**
 *
 * @author kavip
 */
public abstract class Doctor {
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
    
    public boolean canOperate() {
        return surgeon && onDuty;
    }
}
