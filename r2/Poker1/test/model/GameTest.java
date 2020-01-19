/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Game;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bartosz
 */
public class GameTest {
    
    /**
     *
     */
    public GameTest() {
    }

    

    /**
     * Test of resultToDisplay method, of class Game.
     */
    @Test
    public void testResultToDisplay() {
        System.out.println("resultToDisplay");
        Game instance = new Game();
        String expResult = "It is High Card ";
        String result = instance.resultToDisplay();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test is checking if the exceptions are thrown by methods.
     */
    @Test
    public void testCardsToDisplay() {
        
        int i = 0;
        Game instance = new Game();
       
        try{
            instance.cardsToDisplay(0);
        }
        catch(IndexOutOfBoundsException e){
            fail("An expection should be thrown when the stack has no cards");
        }
        
        instance.getResult();
        try{
            instance.cardsToDisplay(-1);
        }
         catch(IndexOutOfBoundsException e){
            fail("An expection should be thrown when parametr has negative value");
        }
        
        try{
            instance.cardsToDisplay(10);
        }
         catch(IndexOutOfBoundsException e){
            fail("An expection should be thrown when the parametr is out of bounds");
        }
   
        
        
    }
    
}
