/*
 * This class is the business logic. The Controller calls the 
 * business service each time a resource is required.
 */
package project.churchplanner.member;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.churchplanner.EncodedPW;


/**
 *
 * @author Ingrycht Antunes
 */

@Service
public class MemberService {
    
    @Autowired
    private MemberRepository memberRepo;
    
    
    public List<Member> listAll(){
        //System.out.println("Hello from listAll() method");
        return memberRepo.findAll();
    }
    
    public void save(Member member){
        member.setPassword(EncodedPW.pwEncoder(member.getPassword()));
        memberRepo.save(member);
    }
    
    public Member get(Integer id){
        return memberRepo.findById(id).get();
    }
    
    public void delete(Integer id){
        memberRepo.findById(id).get().setEnabled(false);
        System.out.println("Hello from delete method: " + memberRepo.findById(id).get());
        memberRepo.save(memberRepo.findById(id).get());
    }
    
    public void deleteMember(Integer id){
        memberRepo.findById(id).get().setEnabled(false);
        System.out.println("Hello from delete method: " + memberRepo.findById(id).get());
        memberRepo.save(memberRepo.findById(id).get());
    }

    public Member getMemberByUsername(String username){
        return memberRepo.findByUsername(username);
    }
    
    public List<Member> findByNameContainingIgnoreCase(String name){
        List<Member> results = memberRepo.findByNameContainingIgnoreCase(name);
        return results;
    }
    
    public Member findByName(String name){
        return memberRepo.findByName(name);
    }
    
}
