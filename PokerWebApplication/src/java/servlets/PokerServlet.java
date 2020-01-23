/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Game;
import model.HistoryOfGame;
import static org.apache.jasper.tagplugins.jstl.core.Out.output;

/**
 *
 * @author Krzys
 */
@WebServlet(name = "PokerServlet", urlPatterns = {"/PokerServlet"})
public class PokerServlet extends HttpServlet {

    
    
    
    public PokerServlet(){
    
    
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        HttpSession session = request.getSession(true);
        Game game;
        Object object =  session.getAttribute("historyOfGames");
        if(object == null){
        game = new Game();
        }
        else{
        game = (Game) object;
        }   
        String[] fileName = new String[52];
        prepareFileNames(fileName);
        String result = null;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PokerServlet</title>");            
            out.println("</head>");
            
            out.println("<body>");
            out.println("<center>");
        
            try{
            result = game.resultToDisplay();
            
           
            
            
            
            out.println("<img src=images/" + fileName[game.cardsToDisplay(0)] + ".png height=400 width=200>");
            out.println("<img src=images/" + fileName[game.cardsToDisplay(1)] + ".png height=400 width=200>");
            out.println("<img src=images/" + fileName[game.cardsToDisplay(2)] + ".png height=400 width=200>");
            out.println("<img src=images/" + fileName[game.cardsToDisplay(3)] + ".png height=400 width=200>");
            out.println("<img src=images/" + fileName[game.cardsToDisplay(4)] + ".png height=400 width=200>");
            out.print("<br />");
            out.println(result);
            out.print("<br />");
            } catch(IndexOutOfBoundsException e){
                 out.println(e.getMessage());
            }
     
           Cookie cookie;
             cookie = new Cookie("LastPokerHand", Integer.toString(game.getResult()));
           response.addCookie(cookie);
           
            Cookie[] cookies = request.getCookies();
           
            for (Cookie aCookie : cookies) {
                String name = aCookie.getName();

                if (name.equals("LastPokerHand")) {
                    out.println("The last result value was: " + aCookie.getValue());
                     
                    break;
                }
                

            }
             
            out.println("</center>");
            
            
            out.println("</body>");
            out.println("</html>");
            
            
            session.setAttribute("historyOfGames", game);
           
        }
         
    }

    static void prepareFileNames(String[] fileName){
        String[] color = {"C","D" ,"H" , "S" };
        int number_of_card = 0;
        for(int i = 0; i<4; i++)
        {
            for(int j = 0; j<13; j++)
            {
            fileName[number_of_card] = (j+2) + color[i];
            number_of_card++;  
            }
    }  
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
