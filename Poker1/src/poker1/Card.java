/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker1;

/**
 *
 * @author Bartosz
 */
public class Card {

    /**
     *
     */
    public String name;

    /**
     *
     */
    public int value;

    /**
     *
     */
    public String color;
    
    Card(String name, int value, String color){
    this.name= name;
    this.value = value;
    this.color = color;
    }
    
    /**
     *
     * @return
     */
    public String getName()
    {
        return name;
    }
    
    /**
     *
     * @return
     */
    public int getValue()
    {
        return value;
    }
     
    /**
     *
     * @return
     */
    public String getColor()
    {
        return color;
    }
}
