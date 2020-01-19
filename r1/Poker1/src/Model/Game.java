/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Collections;

/**
 * Class game is used to simulate game of Poker. Upon the start it
 * puts 5 cards from deck to the table and checks what poker hand 
 * is on the table. Then it give result to controller.
 * @author Bartosz
 */
public class Game {



    /**
     *Deck which is used to play the game.
     */

    private final Deck deck;

    /**
     * Hand will contain actual cards from the game and from that
     * the result will be acquired
     */
    public Hand hand;

    /**
     * result contains the result of the game
     */
    public int result;

    /**
     *Default Constructor
     */
    public Game(){
    deck = new Deck();
    hand = new  Hand();
    result = 0;
    }    

    /**
     * 
     * 
     * @return value of the result e.g 1 - High Card
     */
    public int getResult(){


return result;
}

    /**
     *Method that prepare starts the whole game. First it put 
     * five cards from deck to the table then it checks what poker hand
     * is that
     */
    private void start(){
Collections.shuffle(deck.ListofCards);
for(int i=0; i<5; i++)
hand.drawaCard(deck);

 Checker check = new Checker();
 check.ListofCards = this.hand.ListofCards;
 result = check.checkstateofHand();
 

}

    /**
     *Method that restart whole game by putting cards back to the deck
     */
  private void restart(){
   if(!hand.ListofCards.isEmpty()){
   
   for(int i=0; i<5; i++){
   hand.putCardBackIntoDeck(deck);
   }
   Collections.shuffle(deck.ListofCards);
   }
    
}

    /**
     * Gets result to display to view controller
     * @return text to display 
     */
    public String resultToDisplay(){

this.restart();
this.start();


switch(this.getResult()){

    case 1:
        return "It is High Card ";
        
    case 2: 
        return "It is One Pair";
        
    case 3:
        return "It is Two Pairs"; 
    
    case 4:
        return "It is Three of a Kind"; 
      
    case 5: 
        return "It is Straight"; 
      
    case 6:
        return "It is Flush";
  
    case 7: 
        return "It is Full House"; 
       
    case 8: 
        return "It is Four of a kind"; 
      
    case 9: 
        return "It is Straight Flush";
    default: break;
        
}

          return null;
    
      
}   
   
    /**
     * Gets Id of Card to Display
     * @param numberOfCardToDisplay number of Card to display 
     * @return ID of Card which that should be displayed
     */
    public  int cardsToDisplay(int numberOfCardToDisplay){
   
     try{
         
        return this.hand.ListofCards.get(numberOfCardToDisplay).getIdOfCard();
     }
     catch(IndexOutOfBoundsException e){
          System.err.println("Out of Bounds");
           return 0;
     }
   
  }
}
