/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.churchplanner.activity;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.churchplanner.member.Member;

/**
 *
 * @author Ingrycht Antunes
 */

@Service
public class ActivityService {
    
    @Autowired
    private ActivityRepository activityRepo;
    
    public List<Activity> listAll(){
        return activityRepo.findAll();
    }
    
    public void save(Activity activity){
        activityRepo.save(activity);
    }
    
    public Activity get(Integer activityID){
        return activityRepo.findById(activityID).get();
    }
    
    public void delete(Integer activityID){
        activityRepo.deleteById(activityID);
    }
    
    public List<Activity> findActivityByMemberID(Member memberID){
       // System.out.println("Hello from ActivityService. MemberID: " + memberID);
        return activityRepo.findActivityByMemberID(memberID);
    }

    public List<Activity> findActivityByActivitydate(Date activitydate){
        return activityRepo.findActivityByActivitydate(activitydate);
    }
}
