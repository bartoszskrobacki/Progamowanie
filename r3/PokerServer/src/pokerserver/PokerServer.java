/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerserver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import server.Server;

/**
 *
 * @author Bartosz
 */
public class PokerServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Properties properties = new Properties();
        properties.setProperty("port", "8887");
        properties.setProperty("server_adress", "192.168.1.109");
        
        try(FileOutputStream out = new FileOutputStream(".properties")){
            properties.store(out,"--Configuration--");
            
        } catch(IOException e){
            System.err.println(e.getMessage());
        }
        
        try(Server server = new Server(".properties")){
            
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
        
    }
    
}
