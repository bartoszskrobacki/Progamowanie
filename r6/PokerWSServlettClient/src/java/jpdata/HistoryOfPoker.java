package jpdata;

import javax.persistence.*;
/**
 *The class that implements JPA entity related to Correctness table in database
 * @author Bartosz
 */
@Entity
@Table(name = "Poker", schema ="", catalog="")
public class HistoryOfPoker   {
    
   
    private int id;
    
    private String firstCard;//Field that represents column from the table
    private String secondCard;//Field that represents column from the table
    private String thirdCard;//Field that represents column from the table
    private String fourthCard;//Field that represents column from the table
    private String fifthCard; //Field that represents column from the table
    private String result;//Field that represents column from the table

    /**
     * Getter method for id column
     * @return
     */    
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
        
    }
     /**
     * Setter method for id column
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }  
    
    /**
     * Getter method for the specified column
     * @return
     */     
    @Basic
    @Column(name = "FirstCard")
    public String getFirstCard() {
        return firstCard;
        
    }
    /**
     * Setter method for the value
     * @param f
     */
    public void setFirstCard(String f) {
        firstCard = f;
    }  
    
    /**
     *
     * @return
     */
    @Basic
    @Column(name = "secondCard")
    public String getsecondCard() {
        return secondCard;
        
    }
    /**
     * Setter method for the value
     * @param f
     */
    public void setsecondCard(String f) {
       secondCard = f;
    }  
    
     /**
     * Getter method for the specified column
     * @return
     */     
    @Basic
    @Column(name = "thirdCard")
    public String getthirdCard() {
        return thirdCard;
        
    }
    /**
     * Setter method for the value
     * @param f
     */
    public void setthirdCard(String f) {
        thirdCard = f;
    }  
         /**
     * Getter method for the specified column
     * @return
     */     
    /**
     * Getter method for the specified column
     * @return
     */     
    @Basic
    @Column(name = "fourthCard")
    public String getFourthCard() {
        return fourthCard;
        
    }
    /**
     * Setter method for the value
     * @param f
     */
    public void setFourthCard(String f) {
       fourthCard = f;
    }  
           
    /**
     *
     * @return
     */
    @Basic
    @Column(name = "fifthCard")
    public String getFifthCard() {
        return fifthCard;
        
    }
    /**
     * Setter method for the value
     * @param f
     */
    public void setFifthCard(String f) {
       fifthCard = f;
    }  
        /**
     * Getter method for the specified column
     * @return
     */     
    @Basic
    @Column(name = "Result")
    public String getResult() {
        return result;
        
    }
    /**
     * Setter method for the value
     * @param f
     */
    public void setResult(String f) {
        result = f;
    } 
    
    /**
     *
     */
    public HistoryOfPoker(){}
    
    
           
}
