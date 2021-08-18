/*
 * This class will authenticate the user based on the username. This class is required by spring security framework
 */
package project.churchplanner.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Ingrycht Antunes
 */
public class MemberDetailsService implements UserDetailsService{

    @Autowired
    private MemberRepository memberRepo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Member member = memberRepo.getUserByUsername(username);
        
            if (member == null){
            throw new UsernameNotFoundException("Username not found!");
        }
        
        
        return new MemberDetails(member);
    }
    
}
