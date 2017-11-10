package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class ApplicationService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public ApplicationService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addApplication(Application applications) {        
        mgr.persist(applications);
        return true;
    }

    public Application findApplicationByIc(String ic) {
        Application applications = mgr.find(Application.class, ic);
        return applications;
    }

    public boolean deleteApplication(String ic) {
        Application applications = findApplicationByIc(ic);
        if (applications != null) {
            mgr.remove(applications);
            return true;
        }
        return false;
    }

    public List<Application> findAll() {
        List applicationsList = mgr.createNamedQuery("Application.findAll").getResultList();
        return applicationsList;
    }
    
    public List<Application> findByDate() {
        List applicationsList = mgr.createNamedQuery("Application.findByDate").getResultList();
        return applicationsList;
    }
    
    public List<Application> findByDenied() {
        List applicationsList = mgr.createNamedQuery("Application.findByDenied").getResultList();
        return applicationsList;
    }    
    
    
    public List<Application> findByUnapprove() {
        List applicationsList = mgr.createNamedQuery("Application.findByUnapprove").getResultList();
        return applicationsList;
    }

    public boolean updateApplication(Application applications) {
        Application tempApplication = findApplicationByIc(applications.getIc());
        if (tempApplication != null) {
            tempApplication.setName(applications.getName());
            tempApplication.setGender(applications.getGender());
            tempApplication.setAddress(applications.getAddress());
            tempApplication.setContactnum(applications.getContactnum());
            tempApplication.setStatus(applications.getStatus());


            return true;
        }
        return false;
    }
}
