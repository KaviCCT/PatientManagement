/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientmanagement;

/**
 *
 * @author kavip
 */
public class Patient implements PatientInterface{
    private String name;
    private int patientId;
    private String department;
    private Boolean isInpatient;
    private String[] complaints;
    
    @Override
    public void dischargeInpatient() {
    }
    
    @Override
    public void admitInpatient(String department){
        
    }
    
}
