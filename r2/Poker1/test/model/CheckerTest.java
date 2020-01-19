/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import model.SortbyValue;
import model.Deck;
import model.Checker;
import java.util.Collections;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Bartosz
 */
public class CheckerTest {

    private Checker firstTestData;
    private Checker secondTestData;
    private Checker thirdTestData;
     
    /**
     *Prepares 3 packs of Data for tests.
     * First pack is Straight Flush from 2 to 6.
     * Second is four of Aces.
     * Third is Full House 6s for 10s.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
    firstTestData = new Checker(); 
    secondTestData = new Checker();
    thirdTestData = new Checker();
 
    Deck testDeck = new Deck();
    Deck testDeck2 = new Deck();
    Deck testDeck3 = new Deck();
    firstTestData.ListofCards.add(0,testDeck.ListofCards.get(0)); //2C
    firstTestData.ListofCards.add(0,testDeck.ListofCards.get(1)); //3C
    firstTestData.ListofCards.add(0,testDeck.ListofCards.get(2)); //4C
    firstTestData.ListofCards.add(0,testDeck.ListofCards.get(3)); //5C
    firstTestData.ListofCards.add(0,testDeck.ListofCards.get(4)); //6C
  
    secondTestData.ListofCards.add(0,testDeck2.ListofCards.get(12)); //AC 
    secondTestData.ListofCards.add(0,testDeck2.ListofCards.get(25)); //AD
    secondTestData.ListofCards.add(0,testDeck2.ListofCards.get(38)); //AH
    secondTestData.ListofCards.add(0,testDeck2.ListofCards.get(51)); //AS
    secondTestData.ListofCards.add(0,testDeck2.ListofCards.get(13)); //2D
    
    thirdTestData.ListofCards.add(0,testDeck3.ListofCards.get(5));   //6C
    thirdTestData.ListofCards.add(0,testDeck3.ListofCards.get(18));  //6D
    thirdTestData.ListofCards.add(0,testDeck3.ListofCards.get(31));  //6H
    thirdTestData.ListofCards.add(0,testDeck3.ListofCards.get(9));  //10C
    thirdTestData.ListofCards.add(0,testDeck3.ListofCards.get(48));  //10D   
    
    Collections.sort(firstTestData.ListofCards, new SortbyValue());
    Collections.sort(secondTestData.ListofCards, new SortbyValue());
    Collections.sort(thirdTestData.ListofCards, new SortbyValue());
   
    }

   



    /**
     * Test of straightFlush method, of class Checker.
     */
    @Test
    public void testStraightFlush() {
    
    
        assertEquals("Straight Flush Test for first test data", firstTestData.straightFlush(),true);
        
        assertEquals("Straight Flush Test for second test data", secondTestData.straightFlush(),false);
        
        assertEquals("Straight Flush Test for third test data", thirdTestData.straightFlush(),false);
        
        
    
    }

    /**
     * Test of fourofaKind method, of class Checker.
     */
    @Test
    public void testFourofaKind() {
        
        assertEquals("Four of a Kind Test for first test data", firstTestData.fourofaKind(),false);
        
        assertEquals("Four of a Kind Test for second test data", secondTestData.fourofaKind(),true);
        
        assertEquals("Four of a Kind Test for third test data", thirdTestData.fourofaKind(),false);
        
        
    }

    /**
     * Test of fullHouse method, of class Checker.
     */
    @Test
    public void testFullHouse() {
        
        assertEquals("Full House Test for first test data", firstTestData.fullHouse(),false);
        
        assertEquals("Full House Test for second test data", secondTestData.fullHouse(),false);
        
        assertEquals("Full House Test for third test data", thirdTestData.fullHouse(),true);
    }

    /**
     * Test of flush method, of class Checker.
     */
    @Test
    public void testFlush() {
        
        assertEquals("Flush Test for first test data", firstTestData.flush(),true);
        
        assertEquals("Flush Test for second test data", secondTestData.flush(),false);
        
        assertEquals("Flush Test for third test data", thirdTestData.flush(),false);
    }

    /**
     * Test of straight method, of class Checker.
     */
    @Test
    public void testStraight() {
        
         assertEquals("Straight Test for first test data", firstTestData.straight(),true);
        
        assertEquals("Straight Test for second test data", secondTestData.straight(),false);
        
        assertEquals("Staight Test for third test data", thirdTestData.straight(),false);
    }

    /**
     * Test of threeofaKind method, of class Checker.
     */
    @Test
    public void testThreeofaKind() {
        
        assertEquals("Three of a Kind Test for first test data", firstTestData.threeofaKind(),false);
        
        assertEquals("Three of a Kind Test for second test data", secondTestData.threeofaKind(),true);
        
        assertEquals("Three of a Kind Test for third test data", thirdTestData.threeofaKind(),true);
    }

    /**
     * Test of twoPairs method, of class Checker.
     */
    @Test
    public void testTwoPairs() {
        
        assertEquals("Two Pairs Test for first test data", firstTestData.twoPairs(),false);
        
        assertEquals("Two Pairs Test for second test data", secondTestData.twoPairs(),true);
        
        assertEquals("Two Pairs Test for third test data", thirdTestData.twoPairs(),true);
    }

    /**
     * Test of onePair method, of class Checker.
     */
    @Test
    public void testOnePair() {
   
        
        
        
         assertEquals("One pair Test for first test data", firstTestData.onePair(),false);
        
        assertEquals("One pair Test for second test data", secondTestData.onePair(),true);
        
        assertEquals("One pair Test for third test data", thirdTestData.onePair(),true);
    }

    /**
     * Test of highCard method, of class Checker.
     */
    @Test
    public void testHighCard() {
        
        assertEquals("High card Test for first test data", firstTestData.highCard(),true);
        
        assertEquals("High card Test for second test data", secondTestData.highCard(),true);
        
        assertEquals("High card Test for third test data", thirdTestData.highCard(),true);
    }

    /**
     * Test of checkstateofHand method, of class Checker.
     */
    @Test
    public void testCheckStateofTable(){
        
       assertEquals("Check State of table Test for first test data", firstTestData.checkstateofHand(),9);
       
       assertEquals("Check State of table Test for second test data", secondTestData.checkstateofHand(),8);
        
       assertEquals("Check State of table Test for third test data", thirdTestData.checkstateofHand(),7);
        
    }
 
    
}
