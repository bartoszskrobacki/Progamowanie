/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jpdata.HistoryOfPoker;


/**
 *  Servlet that is responsible for displaying the history result to the client of our site.
    * @author Bartosz
 */
@WebServlet(name = "HistoryServlet", urlPatterns = {"/HistoryServlet"})
public class HistoryServlet extends HttpServlet {

    
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

    

        try (PrintWriter out = response.getWriter()) {
        try{    
           EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PokerPersistance");
           EntityManager entityManager = entityManagerFactory.createEntityManager();
           List<HistoryOfPoker> history =  entityManager.createQuery("SELECT o FROM HistoryOfPoker o").getResultList();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HistoryServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HistoryServlet</h1>");
            out.println();
        try{
            
        
            for(HistoryOfPoker one : history){
                out.println(one.getFirstCard() + ", " + one.getsecondCard() + ", " + one.getthirdCard() + ", " + one.getFourthCard() + ", " + one.getFifthCard()+ ", " + one.getResult() + "<br />" );
            }
        }catch(NullPointerException e){
            out.println("Exception" + e.getMessage());
        }    
  
            
            
            out.println("</body>");
            out.println("</html>");
        }catch(PersistenceException e){
            out.println("Exception" + e.getMessage());
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
