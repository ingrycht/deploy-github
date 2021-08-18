/*
 * This class is a entity class that gets the activities information.
 */
package project.churchplanner.activity;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import project.churchplanner.member.Member;

/**
 *
 * @author Ingrycht Antunes
 */

@Entity
@Table(name="activity")
public class Activity {
    

    
    @Id
    @Column(name="activityID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityID;
    
    private String activityname;
    
    @Column(nullable = false)
    private Date activitydate;
    
    @Column(nullable = false)
    private String activitytime;
    
    @Column(nullable = false)
    private int duration;
    
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name= "bookmember",
            joinColumns = @JoinColumn(name="activityID"),
            inverseJoinColumns = @JoinColumn(name="memberID")
            )
    private List<Member> memberID;

    public Activity() {
    }
    
    public Integer getActivityID() {
        return activityID;
    }

    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public Date getActivitydate() {
        return activitydate;
    }

    public void setActivitydate(Date activitydate) {
        this.activitydate = activitydate;
    }

    public String getActivitytime() {
        return activitytime;
    }

    public void setActivitytime(String activitytime) {
        
        this.activitytime = activitytime;
    }
    

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Member> getMemberID() {
        return memberID;
    }

    public void setMemberID(List<Member> memberID) {
        this.memberID = memberID;
    }    
    
}
