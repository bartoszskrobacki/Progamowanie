/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Card;
import model.Hand;
import model.Deck;
import static org.hamcrest.CoreMatchers.*;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bartosz
 */
public class HandTest {
    


    /**
     *The test verifies if the new object is properly added to list that stores stack of cards.
     */
    @Test
    public void testDrawaCard() {
       
        
        Hand tableTest1 = new Hand();
        Hand tableTest2 = new Hand();
        
        Deck testDeck1 = new Deck();
        Card testCard = new Card(testDeck1.ListofCards.get(0).getName(),testDeck1.ListofCards.get(0).getValue(),testDeck1.ListofCards.get(0).getColor(),testDeck1.ListofCards.get(0).getIdOfCard());
        

        tableTest1.ListofCards.add(testCard);
        tableTest2.drawaCard(testDeck1);
        
       assertThat(tableTest2.ListofCards,is(tableTest2.ListofCards));
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * The test verifies if the object card is properly put back into the deck. 
     */
    @Test
    public void testPutCardBackIntoDeck() {
        Hand tableTest1 = new Hand();
        Hand tableTest2 = new Hand();
        
        Deck testDeck1 = new Deck();
       
        
        for(int i=0; i<6; i++){        
        tableTest1.ListofCards.add(testDeck1.ListofCards.get(i));
        tableTest2.ListofCards.add(testDeck1.ListofCards.get(i));
        }
        
        for(int i=0; i<3; i++){
        tableTest1.ListofCards.remove(0);
        tableTest2.putCardBackIntoDeck(testDeck1);
        }
        
        assertThat(tableTest2.ListofCards,is(tableTest1.ListofCards));
        
        
        
        
    }
    
}
