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
public class LoadReport extends HttpServlet {

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
    //Load applicationlist and insert it into session
    ApplicationService applicationsService = new ApplicationService(em);
    List<Application> applicationsList = applicationsService.findAll();
    HttpSession session = request.getSession();
    session.setAttribute("applicationList", applicationsList);
            
    LocalDate localDate;
      
    ArrayList<ArrayList<Integer>> monthSubmit = new ArrayList<ArrayList<Integer>>();
    List<Integer> yearSubmit= new ArrayList();

    int Counter = 0;


    for(int i = 0;i<applicationsList.size();i++){
        localDate = applicationsList.get(i).getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(yearSubmit.contains(localDate.getYear())==false){
            
            yearSubmit.add(localDate.getYear());
            monthSubmit.add(new ArrayList());

            for(int j = 0;j<applicationsList.size();j++){
                localDate = applicationsList.get(j).getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();                
                
                if(monthSubmit.get(Counter).contains(localDate.getMonthValue())==false){
                    if (yearSubmit.get(Counter)==localDate.getYear()) {
                        monthSubmit.get(Counter).add(localDate.getMonthValue());

                    }
                  }
          }
        Counter++;    

      }
        
    }
    
/*    ArrayList<ArrayList<Integer>> totalAppMonth = new ArrayList();
    int storeTotal = 0; 
    Counter = 0;
    for (int i = 0;i<applicationsList.size();i++) {
        localDate = applicationsList.get(i).getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        for(int e = 0;e<yearSubmit.size();e++){
            if(yearSubmit.get(e)==localDate.getYear()){                 
                totalAppMonth.add(new ArrayList());
                for(int q = 0;q<monthSubmit.get(e).size();q++){                   
                if(monthSubmit.get(e).get(q)==localDate.getMonthValue()){
                    if(q==totalAppMonth.get(e).size()){                        
                    storeTotal = 0;    
                    storeTotal++;
                    totalAppMonth.get(e).add(storeTotal);
                    System.out.println(totalAppMonth.get(e).get(q));
                    
                    }
                    else{
                    storeTotal++;    
                    totalAppMonth.get(e).set(q-1,storeTotal);    
                    System.out.println(totalAppMonth.get(e).get(q-1));
                    }
                }                
                }                            
                
            }            
        }

    }
*/    

            //session.setAttribute("totalAppMonth", totalAppMonth);
              session.setAttribute("yearSubmit", yearSubmit);
              session.setAttribute("monthSubmit", monthSubmit);
              response.sendRedirect("HostelApplication/DisplayReport.jsp");
          } catch (Exception ex) {
              Logger.getLogger(LoadReport.class.getName()).log(Level.SEVERE, null, ex);
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
