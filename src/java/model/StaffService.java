package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class StaffService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public StaffService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addStaff(Staff staff) {
        mgr.persist(staff);
        return true;
    }

    public Staff findStaffByName(String name) {
        Staff staff = mgr.find(Staff.class, name);
        return staff;
    }

    public boolean deleteStaff(String Name) {
        Staff staff = findStaffByName(Name);
        if (staff != null) {
            mgr.remove(staff);
            return true;
        }
        return false;
    }

    public List<Staff> findAll() {
        List staffList = mgr.createNamedQuery("Staff.findAll").getResultList();
        return staffList;
    }

    public boolean updateStaff(Staff staff) {
        Staff tempStaff = findStaffByName(staff.getName());
        if (tempStaff != null) {
            tempStaff.setPassword(staff.getPassword());
            return true;
        }
        return false;
    }
}
