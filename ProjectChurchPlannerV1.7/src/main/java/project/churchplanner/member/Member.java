/*
 * This class is a entity class that gets the members information.
 */
package project.churchplanner.member;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Ingrycht Antunes
 */


//spring annotation to map this classes to correspond to the database
@Entity
@Table(name="member")
public class Member{
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberID;
    
    @Column(nullable = false, length = 45)
    private String name;
    
    @Column(nullable = false, length = 45)
    private String address;
    
    @Column(nullable = false, length = 20)
    private String town;
    
    @Column(nullable = false, length = 20)
    private String city;
    
    @Column(nullable = false, length = 10)
    private String postcode;
    
//    @Column(nullable = false)
//    private Date dob;
    
    private String dob;
    
    @Column(nullable = false, length = 45)
    private String phone;
    
    @Column(nullable = false, length = 45)
    private String email;
    
    @Column(nullable = false, unique = true, length = 45)
    private String username;
    
    @Column(nullable = false, length = 45)
    private String password;
    
    @Column(nullable = false, length = 45)
    private String role;
    
    @Column(nullable = false, length = 45)
    private boolean enabled;
    
    public Member() {
    }
    
    
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
  
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        //String encodedpw = pwEncoded.pwEncoder(password);
        
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    @Override
    public String toString() {
        return getName();
    }

    
}