/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package patientmanagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * STUDENT NAME:    Kavi Patak
 * STUDENT ID:      sba22391
 * 
 */

// A TEST CLASS FOR NameValidatoe
public class NameValidatorTest {
    
    public NameValidatorTest() {
    }

    /**
     * Test of isGood method, of class NameValidator.
     */
    
    // TWO UNIT TEST CASE ATTEMPTS FOR POSITIVE AND NEGETAIVE OUTCOMES
    // MULTIPLE ATTEMPTS MADE BASED ON CLASS NOTES BUT TO NO AVAIL
    // TEST CASES WHERE THUS RUN MANUALLY 
    
    //NEGATIVE TESTING
   @Test
    public void testvalidateNameFalse() {
        System.out.println("isGood");
        String name = "32";
        boolean result = NameValidator.validateName(name);
        assertEquals(false, result);

    }
    
    //POSITIVE TESTING
    @Test
    public void testvalidateNameTrue() {
        System.out.println("isGood");
        String name = "POOA";
        boolean expResult = true;
        boolean result = NameValidator.validateName(name);
        assertEquals(expResult, result);

    }
    
    
    
    
}
