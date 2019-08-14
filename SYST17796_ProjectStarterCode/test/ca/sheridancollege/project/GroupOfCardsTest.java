/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

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
public class GroupOfCardsTest {
    
    public GroupOfCardsTest() {
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

  
   
    /**
     * Test of busted method, of class GroupOfCards.
     */
    @Test
    public void testBustedGood() {
        System.out.println("Goood");
        int handvalue = 24;
        GroupOfCards instance = null;
        boolean expResult = true;
        boolean result = instance.busted(handvalue);
        assertEquals(expResult, result);
        
    }
     @Test
    public void testBustedBad() {
        System.out.println("Badddddd");
        int handvalue = 18;
        GroupOfCards instance = null;
        boolean expResult = false;
        boolean result = instance.busted(handvalue);
        assertEquals(expResult, result);
        
    }
     @Test
    public void testBustedBoundary() {
        System.out.println("Boundary");
        int handvalue = 22;
        GroupOfCards instance = null;
        boolean expResult = true;
        boolean result = instance.busted(handvalue);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of takeTurn method, of class GroupOfCards.
     */
    @Test
    public void testTakeTurnGood() {
        System.out.println("Goooood");
        Game deck = null;
        GroupOfCards instance = null;
        int expResult =18 ;
        int result = instance.takeTurn(deck);
        assertEquals(expResult, result);
       
    }
    
   @Test
    public void testTakeTurnBad() {
        System.out.println("Badddddd");
        Game deck = null;
        GroupOfCards instance = null;
        int expResult =22 ;
        int result = instance.takeTurn(deck);
        assertEquals(expResult, result);
       
    }
@Test
    public void testTakeTurnBoundary() {
        System.out.println("Boundary");
        Game deck = null;
        GroupOfCards instance = null;
        int expResult = 21;
        int result = instance.takeTurn(deck);
        assertEquals(expResult, result);
       
    }

    
}
