/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerclient;

import client.Client;
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
    
    /**
     * label to display result
     */
    @FXML
    private Label label; 

    /**
     * view of image1
     */
    @FXML
    private ImageView Card0; 

    /**
     * view of image2
     */
    @FXML
    private ImageView Card1; 

    /**
     * view of image3
     */
    @FXML
    private ImageView Card2; 

    /**
     *view of image4
     */
    @FXML  
    private ImageView Card3; 

    /**
     * view of image5
     */
    @FXML  
    private ImageView Card4; 
    
    private static Client client;
  
    
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

   label.setText(client.CheckPokerHand());
   Card0.setImage(cardImage[client.CardsToDisplay(0)]);
   Card1.setImage(cardImage[client.CardsToDisplay(1)]);
   Card2.setImage(cardImage[client.CardsToDisplay(2)]);
   Card3.setImage(cardImage[client.CardsToDisplay(3)]);
   Card4.setImage(cardImage[client.CardsToDisplay(4)]);
        
    }
    
    /**
     * The method that initializes the state of that window 
 and loads all the images to cardImage
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       client = new Client (".properties");
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
