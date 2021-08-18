/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.churchplanner.area;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ingrycht Antunes
 */

@Entity
@Table(name="area")
public class Area {
    
    @Id
    @Column(name="areaID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer areaID;
    
    @Column(nullable = false, length = 20)
    private String areaName;

    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    
    
    
    
}
