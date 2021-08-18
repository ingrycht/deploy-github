/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.churchplanner.bookmember;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Ingrycht Antunes
 */

public class BookmemberId  implements Serializable{
    
    private Integer activityID;
    private Integer memberID;

    public BookmemberId() {
    }

    
    public BookmemberId(Integer activityID, Integer memberID) {
        this.activityID = activityID;
        this.memberID = memberID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.activityID);
        hash = 47 * hash + Objects.hashCode(this.memberID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BookmemberId other = (BookmemberId) obj;
        if (!Objects.equals(this.activityID, other.activityID)) {
            return false;
        }
        if (!Objects.equals(this.memberID, other.memberID)) {
            return false;
        }
        return true;
    }
    
    
    
}
