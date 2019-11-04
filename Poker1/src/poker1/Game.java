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
public class Game {

Deck deck;
Table table;
String result;

Game(){
deck = new Deck();
table = new Table();
}    


void Start(){

for(int i=0; i<5; i++)
table.drawacard(deck);

 Checker check = new Checker();
 check.ListofCards = this.table.ListofCards;
 result = check.CheckstateofTable();



}

    /**
     *
     */
    void Restart(){
 
    
 this.Start();
    
}

    /**
     *
     * @return
     */
    String[] Cardstodisplay(){
    
    String[] Card = new String[5];
    for(int i=0;i<5;i++)
    {
        Card[i] = String.valueOf(this.table.ListofCards.get(i).getValue()) + this.table.ListofCards.get(i).getColor().toCharArray()[0];
        System.out.print(Card[i] + " ");
    }
    
    return Card;
}



    
}
