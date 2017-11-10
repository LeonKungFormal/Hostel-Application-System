/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HostelApplication;

import java.io.IOException;
import java.io.PrintWriter;
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
public class UpdateApplication extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
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
        try {
            HttpSession session = request.getSession();
            
            String name = request.getParameter("name");
            Application applications = (Application)session.getAttribute("application");
            String ic = applications.getIc();
            String gender = request.getParameter("gender");
            String address = request.getParameter("address");
            String contactNum = request.getParameter("contactNum");                       
            
            System.out.println(name);
            System.out.println(ic);
            System.out.println(gender);
            System.out.println(contactNum);
            
            session.setAttribute("name",name);
            session.setAttribute("gender",gender);
            session.setAttribute("address",address);
            session.setAttribute("contactNum",contactNum);  
            
            String nameError = "";
            String addressError= "";
            String contactNumError= "";
            
            //Name validation
            if(name==null || name == "" || name == " " || name.isEmpty()){
                nameError = "Empty field";
                session.setAttribute("nameError", nameError);
            }            
            if(name.length()>20){
                nameError = "Name too long"; 
                session.setAttribute("nameError", nameError);
            }
            //Address validation
            if(address==null || address == "" || address == " " || address.isEmpty()){
                addressError = "Empty field";
                session.setAttribute("addressError", addressError);
            }
            if(address.length()>100){    
                addressError = "IC/passport number too long or not full digit";            
                session.setAttribute("addressError", addressError);
            }
            //Contact number validation
            if(contactNum==null || contactNum == "" || contactNum == " " || contactNum.isEmpty()){
                contactNumError = "Empty field";
                session.setAttribute("contactNumError", contactNumError);
            }
            for(int i = 0;i<contactNum.length();i++){    
                if(Character.isDigit(ic.charAt(i))==false)
                contactNumError = "IC/passport is not fully number";
                session.setAttribute("contactNumError", contactNumError);
            }
            if(contactNum.length()>9){    
                contactNumError = "IC/passport number too long or not full digit";            
                session.setAttribute("contactNumError", contactNumError);
            }
            
            //Check if any error message to send and send it
            if(nameError.length()>0)
                if(addressError.length()>0||contactNumError.length()>0){
                session.setAttribute("name",name);
                session.setAttribute("ic",ic);
                session.setAttribute("address",address);
                session.setAttribute("contactNum",contactNum);                     
                response.sendRedirect("HostelApplication/AddApplicationError.jsp");
                
                }
                   
            
            ApplicationService applicationService = new ApplicationService(em);
            
            Application applicationUpdate = new Application(name,ic,gender,address,contactNum);   
            
            utx.begin();
            boolean success = applicationService.updateApplication(applicationUpdate);
            utx.commit();

            session.setAttribute("success", success);
            response.sendRedirect("HostelApplication/UpdateStatus.jsp");
        } catch (Exception ex) {
            Logger.getLogger(UpdateApplication.class.getName()).log(Level.SEVERE, null, ex);
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
