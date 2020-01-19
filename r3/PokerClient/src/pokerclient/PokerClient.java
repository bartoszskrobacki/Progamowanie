/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerclient;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Bartosz
 */
public class PokerClient extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        Properties properties = new Properties();
        properties.setProperty("port", "8887");
        properties.setProperty("server_adress", "192.168.1.109");
        
        try(FileOutputStream out = new FileOutputStream(".properties")){
            properties.store(out, "--Configuration--");
            
        } catch(IOException e){
            System.err.println(e.getMessage());
            
        }
        launch(args);
    }
    
}
