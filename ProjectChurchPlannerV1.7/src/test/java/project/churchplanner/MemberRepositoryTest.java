/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.churchplanner;

import project.churchplanner.member.MemberRepository;
import project.churchplanner.member.Member;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

/**
 *
 * @author Ingrycht Antunes
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class MemberRepositoryTest {
    
    @Autowired
    private MemberRepository repo;
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Test
    public void testCreateUser(){
        Member member = new Member();
        EncodedPW pw = new EncodedPW();
        String encodedPassword = pw.pwEncoder("gyselle");
        member.setMemberID(Integer.SIZE);
        member.setName("Anita Antunes");
        member.setAddress("36 Ardkeen");
        member.setTown("Cavan");
        member.setCity("Cavan");
        member.setPostcode("H12 YT22");
        member.setDob("02-MAR-1958");
        member.setPhone("0894756262");
        member.setEmail("orilta.antunes@gmail.com");
        member.setUsername("gyselle.antunes");
        member.setPassword(encodedPassword);
        member.setRole("USER");
        
        Member savedMember = repo.save(member);
        System.out.println("Hello from MemberRepositoryTest" + savedMember);
        Member existMember = entityManager.find(Member.class, savedMember.getMemberID());
        
       
        assertThat(existMember.getEmail()).isEqualTo(member.getEmail());
    }
    
    @Test 
    public void testFindUserByUsername(){
        String username = "neal.cardoso";
        Member member = repo.findByUsername(username);
        
        System.out.println("This username exist? " + assertThat(member).isNotNull());
    }
}
