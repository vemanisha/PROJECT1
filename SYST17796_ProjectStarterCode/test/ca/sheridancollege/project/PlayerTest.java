/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author abc
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
       @Test
    public void testHasBlackJackGood() {
        System.out.println("Good");
        int handValue = 21;
        boolean expResult = true;
        boolean result = Player.hasBlackJack(handValue);
        assertEquals(expResult, result);
        
    }
 @Test
    public void testHasBlackJackBad() {
        System.out.println("Bad");
        int handValue = 18;
        boolean expResult = false;
        boolean result = Player.hasBlackJack(handValue);
        assertEquals(expResult, result);
        
    }
     @Test
    public void testHasBlackJackBoundary() {
        System.out.println("Boundary");
        int handValue = 21;
        boolean expResult = true;
        boolean result = Player.hasBlackJack(handValue);
        assertEquals(expResult, result);
        
    }
    


   
   

   

   

   

    
    /**
     * Test of checkBust method, of class Player.
     */
    @Test
    public void testCheckBustGood() {
        System.out.println("checkBust");
        int handvalue = 25;
        boolean expResult = true;
        boolean result = Player.checkBust(handvalue);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testCheckBustBad() {
        System.out.println("checkBust");
        int handvalue =20;
        boolean expResult = false;
        boolean result = Player.checkBust(handvalue);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testCheckBustBoundary() {
        System.out.println("checkBust");
        int handvalue = 21;
        boolean expResult = false;
        boolean result = Player.checkBust(handvalue);
        assertEquals(expResult, result);
        
    }
    

   

    
}
