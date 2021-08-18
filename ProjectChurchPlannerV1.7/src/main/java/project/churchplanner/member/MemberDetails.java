/*
 * This class provide user details information to be used by spring security
 */
package project.churchplanner.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Ingrycht Antunes
 */
public class MemberDetails implements UserDetails {
    
    private final Member member;

    public MemberDetails(Member member) {
        this.member = member;
    }
    
    

    @Override
    //Need to set up the roles authority
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = member.getRole();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        
        authorities.add(new SimpleGrantedAuthority(roles));
        //authorities.add(new SimpleGrantedAuthority("USER"));
                
        return authorities;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
//        System.out.println(member.getUsername());
        return member.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return member.isEnabled();
    }
    
    public String getUserDetails(){
        return "Member Details:" + "\nname=" + member.getName()
                + "\naddress=" + member.getAddress()
                + "\nTown=" + member.getTown()
                + "\nCity=" + member.getCity()
                + "\nPostCode=" + member.getPostcode();
    }

    
    
    
    
}
