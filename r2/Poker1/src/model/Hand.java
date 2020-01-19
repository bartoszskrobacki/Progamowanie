/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * The class expanding basic Stack to Table. It contains all methods to
 * put cards to the table and put them back into deck.
 * @author Bartosz
 */
public class Hand extends Stack {

    /**
     * Put one card from deck to the table
     * @param deckinuse deck we are currently using in game
     */
    void drawaCard(Deck deckinuse){
   try{
   this.ListofCards.add(0,deckinuse.ListofCards.get(0));
   deckinuse.ListofCards.remove(0);    
   }
   catch(IndexOutOfBoundsException e){
       System.err.println("Out of Bounds");
   }
   }

    /**
     * Put one card back from table to the deck
     * @param deckinuse deck we are currently using in game
     */
    void putCardBackIntoDeck(Deck deckinuse){
    try{
    deckinuse.ListofCards.add(0,this.ListofCards.get(0));
    this.ListofCards.remove(0);
    }
    catch(IndexOutOfBoundsException e){
       System.err.println("Out of Bounds");
   }
    }

 
 
}
