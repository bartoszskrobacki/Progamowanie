/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker1;

import java.util.Collections;

/**
 *
 * @author Bartosz
 */
public class Checker extends Stack {
    
    
String CheckstateofTable(){
if(ListofCards.size()==5)
{
Collections.sort(ListofCards, new SortbyValue());

if(this.StraightFlush())
{
return "It is Straight Flush";
} 
else if(this.FourofaKind())    
{
return "It is Four of a kind";
}
else if (this.FullHouse()){
return "It is Full House";    
}
else if (this.Flush()){
return "It is Flush";       
}
else if (this.Straight())
{
return "It is Straight"; 
}
else if(this.ThreeofaKind())
{
return "It is Three of a Kind"; 
}
else if(this.TwoPairs())
{
return "It is Two Pairs";
}
else if(this.OnePair())
{
return "It is One Pair";
}
else if(this.HighCard())
{
return "High Card is: " + this.ListofCards.get(4).getName();    
}

    }
return null;
}    
    
    
    
    
boolean StraightFlush(){ 
  
    String color = ListofCards.get(0).getColor();
  
    for (int i=1; i<5; i++)
    {
       if(color != ListofCards.get(i).getColor() || ListofCards.get(i-1).getValue() != ListofCards.get(i).getValue() - 1)
           return false;
      
    }
    
    return true;
}
 
 boolean FourofaKind(){
 for(int i =0; i<2;i++)
 {
     if(ListofCards.get(i).getValue() == ListofCards.get(i+1).getValue() &&
         ListofCards.get(i).getValue() == ListofCards.get(i+2).getValue() &&  
         ListofCards.get(i).getValue() == ListofCards.get(i+3).getValue() )
         return true;
  }
    return false;
 }

 boolean FullHouse(){
    
    if(this.ThreeofaKind())
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

 boolean Flush(){
 String color = ListofCards.get(0).getColor();
  
    for (int i=1; i<5; i++)
    {
       if(color != ListofCards.get(i).getColor())
               return false;
 }
    return true;
 }

 boolean Straight(){
      for (int i=1; i<5; i++)
    {
       if(ListofCards.get(i-1).getValue() != ListofCards.get(i).getValue() - 1)
           return false;
      
    }
    return true;
 }

 boolean ThreeofaKind(){
      for(int i =0; i<4;i++)
 {
     if(ListofCards.get(i).getValue() == ListofCards.get(i+1).getValue() &&
         ListofCards.get(i).getValue() == ListofCards.get(i+2).getValue() )
         return true;
  }
    return false;
 }
 
 boolean TwoPairs(){
     boolean s1, s2, s3;
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
 
 boolean OnePair(){
     for(int i =1; i<5;i++)
 {
     if(ListofCards.get(i).getValue() == ListofCards.get(i-1).getValue())
         return true;
  }
    return false;
 }
 
 boolean HighCard(){
    
     return true;
 }


    
}
