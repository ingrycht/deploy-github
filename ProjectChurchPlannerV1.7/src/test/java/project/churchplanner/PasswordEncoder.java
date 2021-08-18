/*
 * This is a class that encodes the pw to add it into the password column on Members table
 */
package project.churchplanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Ingrycht Antunes
 */
public class PasswordEncoder {
    public static void main(String[] args) {
        PasswordEncoder pw = new PasswordEncoder();
        String rawPassword = "";
        String encodedPassword = pw.pwEncoder(rawPassword);
        
        System.out.println(encodedPassword);
    }
    
    public String pwEncoder(String pw){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = pw;
        String encodedPassword = encoder.encode(rawPassword);
        return encodedPassword;
    }
    
}
