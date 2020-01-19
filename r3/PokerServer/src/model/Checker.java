/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collections;

/**
 *Class that contains all the methods for checking Poker Hands. 
 * @author Bartosz
 */
public class Checker extends Stack {
    
    /**
     * Checks what is the best poker hand
     * @return Value of the deal
     */
int checkstateofHand(){
if(ListofCards.size()==5)
{
Collections.sort(ListofCards, new SortbyValue());

if(this.straightFlush())
{
return 9;
} 
else if(this.fourofaKind())    
{
return 8;
}
else if (this.fullHouse()){
return 7;    
}
else if (this.flush()){
return 6;     
}
else if (this.straight())
{
return 5; 
}
else if(this.threeofaKind())
{
return 4;
}
else if(this.twoPairs())
{
return 3;
}
else if(this.onePair())
{
return 2;
}
else if(this.highCard())
{
return 1;  
}

    }
return 0;
}    
    
    /**
     * Checks if it is straight flush
     * @return true if it is straight flush
     */
    boolean straightFlush(){ 
  
    String color = ListofCards.get(0).getColor();
  
    for (int i=1; i<5; i++)
    {
       if(!color.equals(ListofCards.get(i).getColor()) || ListofCards.get(i-1).getValue() != ListofCards.get(i).getValue() - 1)
           return false;
      
    }
    
    return true;
}
 
    /**
     * Checks if it is four of a kind
     * @return true if it is four of a kind
     */
    boolean fourofaKind(){
 for(int i =0; i<2;i++)
 {
     if(ListofCards.get(i).getValue() == ListofCards.get(i+1).getValue() &&
         ListofCards.get(i).getValue() == ListofCards.get(i+2).getValue() &&  
         ListofCards.get(i).getValue() == ListofCards.get(i+3).getValue() )
         return true;
  }
    return false;
 }

    /**
     * Checks if it is full house
     * @return true if it is full house
     */
    boolean fullHouse(){
    
    if(this.threeofaKind())
    {
        if(ListofCards.get(0).getValue() == ListofCards.get(1).getValue() && 
           ListofCards.get(0).getValue() == ListofCards.get(2).getValue() &&
           ListofCards.get(3).getValue() == ListofCards.get(4).getValue())
        return true;
        
        else if (ListofCards.get(2).getValue() == ListofCards.get(3).getValue() && 
           ListofCards.get(2).getValue() == ListofCards.get(4).getValue() &&
           ListofCards.get(0).getValue() == ListofCards.get(1).getValue())
         return true;   
            
    }
     return false;
 }

    /**
     * Checks if it is flush
     * @return true if it is flush
     */
    boolean flush(){
 String color = ListofCards.get(0).getColor();
  
    for (int i=1; i<5; i++)
    {
       if(!color.equals(ListofCards.get(i).getColor()))
               return false;
 }
    return true;
 }

    /**
     * Checks if it is straight
     * @return true if it is straight
     */
    boolean straight(){
      for (int i=1; i<5; i++)
    {
       if(ListofCards.get(i-1).getValue() != ListofCards.get(i).getValue() - 1)
           return false;
      
    }
    return true;
 }

    /**
      * Checks if it is three of a kind
     * @return true if it is three of a kind
     */
    boolean threeofaKind(){
      for(int i =0; i<3;i++)
 {
     if(ListofCards.get(i).getValue() == ListofCards.get(i+1).getValue() &&
         ListofCards.get(i).getValue() == ListofCards.get(i+2).getValue() )
         return true;
  }
    return false;
 }
 
    /**
      * Checks if it is two pairs
     * @return true if it is two pairs
     */
    boolean twoPairs(){
     
     if(ListofCards.get(0).getValue() == ListofCards.get(1).getValue() &&
        ListofCards.get(2).getValue() == ListofCards.get(3).getValue())
         return true;
     else if(ListofCards.get(0).getValue() == ListofCards.get(1).getValue() &&
        ListofCards.get(3).getValue() == ListofCards.get(4).getValue())
         return true;
     else if(ListofCards.get(1).getValue() == ListofCards.get(2).getValue() &&
        ListofCards.get(3).getValue() == ListofCards.get(4).getValue())
         return true;
     
     return false;
 }
 
    /**
     * Checks if it is one pair
     * @return true if it is one pair
     */
    boolean onePair(){
     for(int i =1; i<5;i++)
 {
     if(ListofCards.get(i).getValue() == ListofCards.get(i-1).getValue())
         return true;
  }
    return false;
 }
 
    /**
      * Checks if it is high card
     * @return true if it is high card
     */
    boolean highCard(){
    
     return true;
 }


    
}
