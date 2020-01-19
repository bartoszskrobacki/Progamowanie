/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewcontroller;

import model.Game;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Bartosz
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label; //label
    
    @FXML
    private ImageView Card0; //view of image1
    @FXML
    private ImageView Card1; //view of image2
    @FXML
    private ImageView Card2; //view of image3
    @FXML  
    private ImageView Card3; //view of image4
    @FXML  
    private ImageView Card4; //view of image5
    
    Game game1 = new Game();
    
    /**
     *52 images of unique cards in the poker deck
     */
    Image[] cardImage = new Image[52];
    
    /**
     * The method is calling method in model package.
     * @param event
     */
    @FXML
    private void handleButtonAction(ActionEvent event)  {
        
        
       
        label.setText(game1.resultToDisplay());
        
        Card0.setImage(cardImage[game1.cardsToDisplay(0)]);
        Card1.setImage(cardImage[game1.cardsToDisplay(1)]);
        Card2.setImage(cardImage[game1.cardsToDisplay(2)]);
        Card3.setImage(cardImage[game1.cardsToDisplay(3)]);
        Card4.setImage(cardImage[game1.cardsToDisplay(4)]);
        
        
    }
    
    /**
     * The method that initializes the state of that window 
 and loads all the images to cardImage
     * @param url default parameter 
     * @param rb  default parameter
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       try{
        String[] color = {"C","D" ,"H" , "S" };
   
        int number_of_card = 0;
        for(int i = 0; i<4; i++)
        {
            for(int j = 0; j<13; j++)
            {
            cardImage[number_of_card] = new Image(getClass().getResource("images/" + (j+2) + color[i] +".png").toExternalForm());
            number_of_card++;  
            }
    }
      } catch (NullPointerException e){
            System.err.println("File does not exist");
        }
        
    }    
    
}
