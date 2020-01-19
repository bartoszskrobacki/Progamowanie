/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;

/**
 *
 * @author Bartosz
 */
public class Server implements Closeable {
    
    /**
     * port number
     */
    private int PORT;
    
    /**
     * field represents the socket waiting for client connections
     */
    private ServerSocket serverSocket;
    
    /**
     *Creates the server socket
     *
     * @throws IOException when port is already bind
     */
    public Server() throws IOException{
        serverSocket = new ServerSocket(PORT);
    }
    
    /**
     * * Constructor of Server class, which is used to establish connection to the server. It reads the parameters (port and server address)
     * from the file.
     * @param propertiesFileName File, where properties server_address and port is stored.
     * @throws IOException
     */
    public Server(String propertiesFileName) throws IOException{
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream(propertiesFileName);
        properties.load(in);
        PORT=Integer.parseInt(properties.getProperty("port"));
        serverSocket = new ServerSocket(PORT);
        while(true)
        new SingleConnection(serverSocket.accept()).start();
    }
    
    /**
     * Close connection
     * @throws IOException
     */
    public void close() throws IOException{
        if(serverSocket != null){
            serverSocket.close();
        }
    }
}
