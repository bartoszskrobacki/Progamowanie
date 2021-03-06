/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that is used to contain the result and cards from one poker game.
 * @author Bartosz
 */
public class HistoryOfGame {
    
   private final String card1;
   private String card2;
   private String card3;
   private String card4;
   private String card5;
   private int result;
    
   HistoryOfGame(String card1, String card2, String card3, String card4, String card5, int result){
       this.card1 = card1;
       this.card2 = card2;
       this.card3 = card3;
       this.card4 = card4;
       this.card5 = card5;
       this.result = result;
       
   }
   
    /**
     *method that  returns string with name of the card
     * @return name and color of Card
     */
    public String getCard1(){
       return card1;
   }

    /**
    *method that  returns string with name of the card
     * @return name and color of Card
     */
    public String getCard2(){
       return card2;
   }

    /**
     *method that  returns string with name of the card
     * @return name and color of Card
     */
    public String getCard3(){
       return card3;
   }

    /**
     *method that  returns string with name of the card
     * @return name and color of Card
     */
    public String getCard4(){
       return card4;
   }

    /**
    *method that  returns string with name of the card
     * @return name and color of Card
     */
    public String getCard5(){
       return card5;
   }

    /**
     * method that returns string with the result of the game
     * @return result of the game
     */
    public int getResult(){
       return result;
   }
}
