/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.churchplanner.activityrole;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ingrycht Antunes
 */

@Service
public class ActivityRoleService {
    
    @Autowired
    private ActivityRoleRepository activityRoleRepo;
    
    public List<Activityrole> listAll(){
        return activityRoleRepo.findAll();
    }
    
    public void save(Activityrole activityRole){
        activityRoleRepo.save(activityRole);
    }
    
    public Activityrole get(Integer activityRoleID){
        return activityRoleRepo.findById(activityRoleID).get();
    }
    
    public void delete(Integer activityRoleID){
        activityRoleRepo.deleteById(activityRoleID);
    }
    
}
