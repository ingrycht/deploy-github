/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.churchplanner.activity;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.churchplanner.member.Member;

/**
 *
 * @author Ingrycht Antunes
 */
@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer>, JpaRepository<Activity, Integer>{
    
    
    public List<Activity> findActivityByMemberID(Member memberID);
    
    public List<Activity> findActivityByActivitydate(Date activitydate);
   
}
