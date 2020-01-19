/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Bartosz
 */
public class Client implements Closeable {
    
    /**
     * port number
     */
    private int port;
    
    /**
     * represents the address of the server
     */
    private String address;
    
    /**
     * represents the socket to connect to server
     */
    private Socket socket;
    
    /**
     * buffered input character stream
     */
    private BufferedReader input;
    
    /**
     * output character stream
     */
    private PrintWriter output;
    
    /**
     * Constructor of Client class, which is used to establish connection to the server. It reads the parameters (port and server address)
     * from the file.
     * @param propertiesFileName File, where properties server_address and port is stored
     */
    public Client(String propertiesFileName) {
        try{
            Properties properties = new Properties();
            FileInputStream in = new FileInputStream(propertiesFileName);
            properties.load(in);
            port = Integer.parseInt(properties.getProperty("port"));
            address = properties.getProperty("server_address");
            socket = new Socket(address,port);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

        } catch(IOException e){
            System.err.println("Connection does not work");
           
        }
    }
    
    /**
     * Method that invokes the CheckPokerHand method in the server and returns the result of the game to the display.
     * @return string with the result of the game
     */
    public String CheckPokerHand()
    {
        try{
            output.println("CheckPokerHand");
            String Message=input.readLine();
        

            if(Message.contains("100"))
            return input.readLine();
            
            if(Message.contains("101"))
                 return Message;
            
            if(Message.contains("200"))
                return "Connection between client and server wasn't executed properly";
            
        }
        
        catch(IOException e){
            return e.getMessage();
        }
        return "Connection between client and server wasn't executed properly";
    }
    
    /**
     * Method that sends the number of the card which should be displayed as parameter and returns the id of this card.
     * @param i number of what card should be displayed
     * @return if of the card that should be displayed
     */
    public int CardsToDisplay(int i){
        try{
            output.println("CardtoDisplay");
            String controlMessage=input.readLine();
            if(controlMessage.contains("100"))
                output.println(i);
            controlMessage=input.readLine();
            if(controlMessage.contains("101"))
               return Integer.parseInt(input.readLine());
             if(controlMessage.contains("200")){
                return 0;}
        } catch(IOException e){
           System.err.println("IOException in CardsToDisplay");
        }
        return 0;
    }
    
    /**
     * Method returns list of available solutions on server.
     * @return List of available commands
     * @throws IOException
     */
    public List<String> Help() throws IOException{
        output.println("HELP");
        String Message=input.readLine();
        if(Message.contains("150")){
            Message = input.readLine();
            return Arrays.asList(Message.split("|"));
        }else{
            throw new IOException("Unexpected response from server");
        }
    }
    
    /**
     * Close the connection
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        if(socket!=null){
            socket.close();
        }
    } 
    
}
