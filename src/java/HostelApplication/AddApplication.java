package HostelApplication;

import model.Application;
import model.ApplicationService;
import java.io.*;
import java.util.Calendar;
import java.util.logging.*;
import javax.annotation.Resource;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.transaction.UserTransaction;

public class AddApplication extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String ic = request.getParameter("ic");
            String gender = request.getParameter("gender");
            String address = request.getParameter("address");
            String contactNum = request.getParameter("contactNum");                       
            
            HttpSession session = request.getSession();
            
            session.setAttribute("name",name);
            session.setAttribute("ic",ic);
            session.setAttribute("gender",gender);
            session.setAttribute("address",address);
            session.setAttribute("contactNum",contactNum);  
            
            String nameError = "";
            String ICError = "";
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
            //IC validation
            if(ic==null || ic == "" || ic == " " || ic.isEmpty()){
                ICError = "Empty field";
                session.setAttribute("ICError", ICError);
            }
            for(int i = 0;i<ic.length();i++){    
                if(Character.isDigit(ic.charAt(i))==false)
                ICError = "IC/passport is not fully digit";
                session.setAttribute("ICError", ICError);
            }
            if(ic.length()>12){    
                ICError = "IC/passport number too long";
                session.setAttribute("ICError", ICError);
            }
            //Address validation
            if(address==null || address == "" || address == " " || address.isEmpty()){
                addressError = "Empty field";
                session.setAttribute("addressError", addressError);
            }
            if(address.length()>100){    
                addressError = "Home address too long";            
                session.setAttribute("addressError", addressError);
            }
            //Contact number validation
            if(contactNum==null || contactNum == "" || contactNum == " " || contactNum.isEmpty()){
                contactNumError = "Empty field";
                session.setAttribute("contactNumError", contactNumError);
            }
            for(int i = 0;i<contactNum.length();i++){    
                if(Character.isDigit(ic.charAt(i))==false)
                contactNumError = "contact number is not not full digit";
                session.setAttribute("contactNumError", contactNumError);
            }
            if(contactNum.length()>9){    
                contactNumError = "contact number too long";            
                session.setAttribute("contactNumError", contactNumError);
            }
            
            //Check if any error message to send and send it
            if(nameError.length()>0||ICError.length()>0)
                if(addressError.length()>0||contactNumError.length()>0){
                session.setAttribute("name",name);
                session.setAttribute("ic",ic);
                session.setAttribute("address",address);
                session.setAttribute("contactNum",contactNum);                     
                response.sendRedirect("HostelApplication/AddApplicationError.jsp");
                
                }
            
            ApplicationService applicationService = new ApplicationService(em);
            
            Application applications = new Application(name,ic,gender,address,contactNum);   
            
            utx.begin();
            boolean success = applicationService.addApplication(applications);
            utx.commit();

            
            session.setAttribute("success", success);
            response.sendRedirect("HostelApplication/AddStatus.jsp");
        } catch (Exception ex) {
            
            System.out.println(ex.getMessage());
            Logger.getLogger(AddApplication.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
