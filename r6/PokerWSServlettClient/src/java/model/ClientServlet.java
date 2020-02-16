package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import jpdata.HistoryOfPoker;
import model.PokerWebbService_Service;

/**
 *
 * @author Krzys
 */
@WebServlet(urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PokerWebbService/PokerWebbService.wsdl")
    private PokerWebbService_Service service;

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
        
       

        
        
        String[] fileName = new String[52];
        prepareFileNames(fileName);
        String result ="";
        
        response.setContentType("text/html;charset=UTF-8");
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PokerPersistance");
           EntityManager entityManager = entityManagerFactory.createEntityManager();

        int lastIndex = entityManager.createQuery("SELECT o FROM HistoryOfPoker o").getResultList().size();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClientServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClientServlet at " + request.getContextPath() + "</h1>");
            try{
            result = getResult();
             out.println("<img src=images/" + fileName[getCard(0)] + ".png height=400 width=200>");
            out.println("<img src=images/" + fileName[getCard(1)] + ".png height=400 width=200>");
            out.println("<img src=images/" + fileName[getCard(2)] + ".png height=400 width=200>");
            out.println("<img src=images/" + fileName[getCard(3)] + ".png height=400 width=200>");
            out.println("<img src=images/" + fileName[getCard(4)] + ".png height=400 width=200>");
            out.println("<br>" + result);
            }catch(Exception e){
                out.println("Exception " + e);
            }
        HistoryOfPoker history = new HistoryOfPoker();
        history.setId(lastIndex);
        history.setFirstCard(fileName[getCard(0)]);
        history.setsecondCard(fileName[getCard(1)]);
        history.setthirdCard(fileName[getCard(2)]);
        history.setFourthCard(fileName[getCard(3)]);
        history.setFifthCard(fileName[getCard(4)]);
        history.setResult(result);
            
             entityManager.getTransaction().begin();
        entityManager.persist(history);
        entityManager.getTransaction().commit();
        
       
  
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

    private String getResult() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        model.PokerWebbService port = service.getPokerWebbServicePort();
        return port.getResult();
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
   

    private Integer getCard(int numbercard) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        model.PokerWebbService port = service.getPokerWebbServicePort();
        return port.getCard(numbercard);
    }
}