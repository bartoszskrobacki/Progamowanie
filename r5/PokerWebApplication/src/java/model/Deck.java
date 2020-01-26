/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;
import java.util.LinkedList;

/**
 * Class that extends stack. It is list of 52 cards for standard poker play 
 * 
 * @author Bartosz
 */
public class Deck extends Stack {

    /**
     * Default constructor
     * It prepares the standard deck that contains 52 cards
     */
    Deck(){
        ListofCards = new LinkedList();
        String[] color = {"Clubs", "Diamonds","Hearts", "Spades"};
        String[] names = {"Two", "Three", "Four", "Five","Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
        int number_of_card= 0;
        
            for(String element : color){
       
            for(int j = 0; j<13; j++)
            {
            Card nowa = new Card(names[j],j+2,element,number_of_card);
            ListofCards.add(nowa); 
       
            number_of_card++;
            }
   }
        
}
}