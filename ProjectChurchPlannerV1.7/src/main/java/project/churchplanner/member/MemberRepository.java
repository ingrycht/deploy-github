/*
 * This class encapsulates the reuired logic to access data sources.
 */
package project.churchplanner.member;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ingrycht Antunes
 */
@Repository
public interface MemberRepository extends CrudRepository<Member, Integer>, JpaRepository<Member, Integer> {
    
    @Query("SELECT m FROM Member m WHERE m.username = :username")
    public Member getUserByUsername(@Param("username")String username);
    
    @Query("SELECT u FROM Member u WHERE u.username = ?1")
    Member findByUsername(String username);
    
//    @Query("SELECT u FROM bookmember u WHERE u.memberID = ?1")
//    public List<Member> findByActivityID(Integer activityID);
    
    //@Query("SELECT m FROM Member m WHERE m.name LIKE %:keyword%")
    //method that retrive the record by search part of the name
    List<Member> findByNameContainingIgnoreCase(@Param("keyword") String keyword);
    
    @Query("SELECT u FROM Member u WHERE u.name = ?1")
    Member findByNameContains(String name);
    
    //@Query("SELECT m.email FROM Member m WHERE m.name = ?1")
    Member findByName(String name);    

//    public List<Member> findByActivityID(Integer activityID);
    
}
