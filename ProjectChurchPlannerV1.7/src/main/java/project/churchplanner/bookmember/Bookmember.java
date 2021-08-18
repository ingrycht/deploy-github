/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.churchplanner.bookmember;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author Ingrycht Antunes
 */

@Entity
@IdClass(BookmemberId.class)
@Table(name = "bookmember")
public class Bookmember {
 
    @Id
    private Integer activityID;
    @Id
    private Integer memberID;
    private Integer activityroleID;

    public Integer getActivityID() {
        return activityID;
    }

    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public Integer getActivityroleID() {
        return activityroleID;
    }

    public void setActivityroleID(Integer activityroleID) {
        this.activityroleID = activityroleID;
    }
    
    
    
}
