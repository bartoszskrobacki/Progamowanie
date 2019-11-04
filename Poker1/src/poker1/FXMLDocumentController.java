/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker1;

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
    private Label label;
    
    @FXML
    private ImageView Card0;
    @FXML
    private ImageView Card1;
    @FXML
    private ImageView Card2;
    @FXML  
    private ImageView Card3;
    @FXML  
    private ImageView Card4;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event)  {
        
        Game game1 = new Game();
        game1.Start();
       
        try{
        Image cardimage1 = new Image(getClass().getResource("PNG/" + game1.Cardstodisplay()[0] +".png").toExternalForm());
        Image cardimage2 = new Image(getClass().getResource("PNG/" + game1.Cardstodisplay()[1] +".png").toExternalForm());
        Image cardimage3 = new Image(getClass().getResource("PNG/" + game1.Cardstodisplay()[2] +".png").toExternalForm());
        Image cardimage4 = new Image(getClass().getResource("PNG/" + game1.Cardstodisplay()[3] +".png").toExternalForm());
        Image cardimage5 = new Image(getClass().getResource("PNG/" + game1.Cardstodisplay()[4] +".png").toExternalForm());
        
       
        
        label.setText(game1.result);
        
        Card0.setImage(cardimage1);
        Card1.setImage(cardimage2);
        Card2.setImage(cardimage3);
        Card3.setImage(cardimage4);
        Card4.setImage(cardimage5);
        } catch (NullPointerException e){
            System.err.println("File does not exist");
        }
   
    }
    
    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        
    
    }    
    
}
