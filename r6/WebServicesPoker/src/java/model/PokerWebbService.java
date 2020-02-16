/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Krzys
 */
@WebService(serviceName = "PokerWebbService")
@Stateless()
public class PokerWebbService {
Game game = new Game();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetResult")
    public String GetResult() {
        //TODO write your implementation code here:
               
        return  game.resultToDisplay();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetCard")
    public Integer GetCard(@WebParam(name = "numbercard") int numbercard) {
      
        return  game.cardsToDisplay(numbercard);
    }
}
