/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * The class that represents the single Card
 * It is used in List of this object type to store deck and hand
 * @author Bartosz
 */
public class Card {

    /**
     * Full name of the card
     */
    private final String name;

    /**
     * Value of the card
     */
    private final int value;

    /**
     * Color of the Card
     */
    private final String color;

    /**
     * Unique number for all the cards
     */
    private final int idOfCard;
    
    /**
     * Constructor that fills class variables with values
     * @param name
     * @param value
     * @param color
     * @param numberOfCard
     */
    Card(String name, int value, String color, int numberOfCard){
    this.name= name;
    this.value = value;
    this.color = color;
    this.idOfCard = numberOfCard;
    }
    
    /**
     *
     * @return name of the card
     */
    public String getName()
    {
        return name;
    }
    
    /**
     *
     * @return value of the card
     */
    public int getValue()
    {
        return value;
    }
     
    /**
     *
     * @return color of the card
     */
    public String getColor()
    {
        return color;
    }
    
    /**
     *
     * @return ID of the Crd
     */
    public int getIdOfCard()
    {
        return idOfCard;
    }

    /**
     *
     * @return combination of name and color
     */
    public String getNameandColor(){
        return this.getName() + " of " + this.getColor();
    }
}   
