/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HostelApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Application;
import model.ApplicationService;

/**
 *
 * @author Lion
 */
public class ProcessStaffFunction extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
   //Obtain session     
   HttpSession session = request.getSession();
   
   //Obtain year value in string
   int yearChoosen = Integer.parseInt(request.getParameter("year"));
   System.out.println(yearChoosen);

   //Create date varible for measure date
   LocalDate localDate;
   //Obtain drop down list name
   ArrayList<String> DDownName = (ArrayList<String>)request.getAttribute("DDownName");
   
   //store drop down list selected value
   int MonthObtainer = 0;      
   
   //Obtain parameter from previous page use dropdownlist array name 
   ArrayList<ArrayList<Integer>> counter = (ArrayList<ArrayList<Integer>>)request.getAttribute("counter");
   
   /*
   DDownName keep the list of name of the dropdownlist
   so use request.getParameter with input of DDownName to see
   */
System.out.println(counter.size());
   
   for(int k = 0;k<counter.size();k++){
       if(counter.get(k).get(0)==yearChoosen)
           MonthObtainer = Integer.parseInt(session.getAttribute(DDownName.get(counter.get(k).get(1))).toString());
   }
   
/*   for(int k = 0;k<DDownName.size();k++){
       if(Integer.parseInt(request.getParameter(DDownName.get(counter.get(k))))==yearChoosen){
       MonthObtainer = Integer.parseInt(request.getParameter(DDownName.get(counter.get(k))));
       System.out.println(request.getParameter(DDownName.get(k)));
       System.out.println(MonthObtainer);
   }
   }
 */  
   //Obtain application list from database    
    ApplicationService applicationsService = new ApplicationService(em);
    List<Application> applicationsList = applicationsService.findAll();
    
    //Create new application list to keep selected application
    ArrayList<Application> applicationsSelected = new ArrayList();
       
   //Load all application into application list
   for(int a = 0;a<applicationsList.size();a++){
       localDate = applicationsList.get(a).getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
       if(localDate.getYear()==yearChoosen){
           if(localDate.getMonthValue()==MonthObtainer){
        applicationsSelected.add(applicationsList.get(a));
           }
   }
   } 

  //Obtain value from button from previous page
   String Choice = request.getParameter("button"); 
  session.setAttribute("applicationsSelected", applicationsSelected);
        switch (Choice) {
            case "Update":
                response.sendRedirect("HostelApplication/StaffApprove.jsp");
                break;
            case "Delete":
                response.sendRedirect("../SearchItem");
                break;
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
