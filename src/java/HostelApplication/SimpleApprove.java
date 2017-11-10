/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HostelApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import model.Application;
import model.ApplicationService;

/**
 *
 * @author Lion
 */
public class SimpleApprove extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        HttpSession session = request.getSession();
        ArrayList<String> radioButtonList = (ArrayList<String>)session.getAttribute("radioButtonList");
        ArrayList<Boolean> radioButtonValueList = new ArrayList();
        String valueChecker;
        List<Application> applicationsList = (List)session.getAttribute("applicationList");
        
        for(int j = 0;j<radioButtonList.size();j++){
            valueChecker = request.getParameter(radioButtonList.get(j));
            if(Objects.equals(valueChecker,"true"))
            radioButtonValueList.add(true);
            else if(Objects.equals(valueChecker,"false"))
            radioButtonValueList.add(false);    
            else if(Objects.equals(valueChecker,"null"))
            radioButtonValueList.add(null);
        }
        
         ApplicationService applicationService = new ApplicationService(em);
        
         for(int i = 0;i<applicationsList.size();i++){

             applicationsList.get(i).setStatus(radioButtonValueList.get(i));
         
            utx.begin();
            applicationService.updateApplication(applicationsList.get(i));
            utx.commit();
        }    

            session.setAttribute("applicationsList", applicationsList);
            response.sendRedirect("HostelApplication/SimpleApproveStatus.jsp");
        } catch (Exception ex) {
            Logger.getLogger(SimpleApprove.class.getName()).log(Level.SEVERE, null, ex);
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
