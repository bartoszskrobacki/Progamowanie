/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;

/**
 * Class that contains method to compare to cards by their value.
 * @author Bartosz
 */
public class SortbyValue implements Comparator<Card> {
   
    /**
     * Compare to cards by their value
     * @param card1 first card to compare
     * @param card2 second card to compare
     * @return which card has higher value
     */
    @Override
    public int compare(Card card1, Card card2)
    {
        return card1.getValue() - card2.getValue();
    }
}
