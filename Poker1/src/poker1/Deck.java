/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker1;

import java.util.*;
import java.util.LinkedList;

/**
 *
 * @author Bartosz
 */
public class Deck extends Stack {

    /**
     *
     */
    Deck(){
        ListofCards = new LinkedList();
        String[] color = {"Clubs", "Diamonds","Hearts", "Spades"};
        String[] names = {"Two", "Three", "Four", "Five","Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

        for(int i = 0; i<4; i++)
        {

            for(int j = 0; j<13; j++)
            {
            Card nowa = new Card(names[j],j+2,color[i]);
            ListofCards.add(nowa); 
            Collections.shuffle(ListofCards);
            }
    }
    
}
}