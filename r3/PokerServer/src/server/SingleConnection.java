/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import model.Game;

/**
 *
 * @author Bartosz
 */
public class SingleConnection extends Thread implements Closeable {
    
    /**
     * field represents the connection to the client
     */
    private Socket socket;
    
    /**
     * buffered input character stream
     */
    private BufferedReader input;
    
    /**
     * Formatted output character stream
     */
    private PrintWriter output;
    
    /**
     * Instance of game, represents the model
     */
    private static Game game;
    
    /**
     * The constructor of instance of the SingleService class. Use the socket as
     * a parameter.
     * @param socket socket representing connection to the client
     * @throws IOException it is thrown by socket
     */
    public SingleConnection(Socket socket) throws IOException{
        this.socket = socket;
        output = new PrintWriter(
            new BufferedWriter(
                new OutputStreamWriter(
                    socket.getOutputStream())),true);
        input = new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream()));
        
    }
    
    /**
     * Realizes the service
     */
    @Override
    public final void run() {
        try{
            game = new Game();
            while(true) {
                String message =  input.readLine();
                switch(message){
                   case "CheckPokerHand":
                    checkPokerHand();
                    break;
                   case "CardtoDisplay":
                    CardsToDisplay();
                    break;
                   default:
                   output.println("200: Unknown command");
                     }
                }
            } catch(IOException e){
                System.err.println("Single Server Connection exception: " + e.getMessage());
            }
        }
    
    /**
     * The method that starts the game and sends the result of the game to the client.
     */
    private final void checkPokerHand(){
        
       
        output.println("100: invoked check PokerHand Method");
            
        output.println(game.resultToDisplay());
        
   
      
    }
    
    /**
     * The method that reads from output which card to display and then sends id of the card to the client
     * @throws IOException
     */
    private void CardsToDisplay() throws IOException{
            
        
            output.println("100: invoked getNTerm method");
            int i = Integer.parseInt(input.readLine());
            
            output.println("101: received A value");
            output.println(game.cardsToDisplay(i));
            
    }
    
    /**
     * Close the connection
     * @throws IOException
     */
    @Override
    public void close() throws IOException{
        if(socket != null){
            socket.close();
        }
    }
    
}
