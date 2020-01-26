/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Game;

/**
 *  Servlet that is responsible for displaying the history result to the client of our site.
    * @author Bartosz
 */
@WebServlet(name = "HistoryServlet", urlPatterns = {"/HistoryServlet"})
public class HistoryServlet extends HttpServlet {

    private Connection connection;
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
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Game game;
        
        Object object =  session.getAttribute("historyOfGames");
        if(object == null){
        game = new Game();
        }
        else{
        game = (Game) object;
        }  

        
        if((Connection)this.getServletContext().getAttribute("databaseConnection") == null)
        {
            try{
            
                Class.forName("org.apache.derby.jdbc.ClientDriver");
            
           
            }catch(ClassNotFoundException cnfe){
                System.err.println("Can't connect to database");
            }
            try{
            String url = this.getServletContext().getInitParameter("url");
            String username = this.getServletContext().getInitParameter("username");
            String password = this.getServletContext().getInitParameter("password");

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException sqle) 
        {
            connection = null;
            System.err.println("Can't connect to database!");
        }
          
        this.getServletContext().setAttribute("databaseConnection", connection);
            
        }
        else
        {
            connection = (Connection)this.getServletContext().getAttribute("databaseConnection");
        }
        
        
        

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HistoryServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HistoryServlet</h1>");
            out.println();
           
            
            try{
               Statement statement = connection.createStatement();
               ResultSet rs = statement.executeQuery("SELECT * FROM HistoryOfPoker");
               
               while(rs.next())
                   out.println(rs.getString("CARD1") + ", " + rs.getString("CARD2") + ", " + rs.getString("CARD3") + ", " + rs.getString("CARD4") + ", " + rs.getString("CARD5") + ", " + rs.getString("RESULT") + " :) <br> ");
            }
            catch (SQLException e){
                 response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Can't obtain value from database" + e.getMessage());
            }    
            
            out.println("</body>");
            out.println("</html>");
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
